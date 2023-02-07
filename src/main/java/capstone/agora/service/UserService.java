package capstone.agora.service;

import capstone.agora.Repository.UserRepository;
import capstone.agora.dto.*;
import capstone.agora.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseDto login(LoginFormDto loginFormDto) {
        Optional<User> findUser = userRepository.findUserByUserId(loginFormDto.getUserId());
        if (findUser.isEmpty()) {
            return ResponseDto.notFound();
        } else {
            if (findUser.get().getPassword().equals(loginFormDto.getPassword())) {
                return ResponseDto.ofSuccess();
            }
            return ResponseDto.error("password-check-needed");
        }
    }

    public ResponseDto duplicatedIdCheck(String userId) {
        if (userRepository.existsUserByUserId(userId)) {
            return ResponseDto.error("duplicated-id");
        } else {
            return ResponseDto.ofSuccess();
        }
    }

    public void register(RegisterFormDto registerFormDto) {
        userRepository.save(User.builder().userId(registerFormDto.getUserId())
                .password(registerFormDto.getPassword())
                .email(registerFormDto.getEmail())
                .nickname(registerFormDto.getNickname())
                .debateCount(0)
                .voteCount(0)
                .commentCount(0)
                .createCount(0)
                .score(0).build());
    }

    public ResponseDataDto<UserDto> getUserInfo(String userId) {
        Optional<User> findUser = userRepository.findUserByUserId(userId);
        if (findUser.isEmpty()) {
            return ResponseDataDto.ofFail("not-found");
        }
        return ResponseDataDto.ofSuccess("success",
                UserDto.builder().user(findUser.get()).build());
    }

}
