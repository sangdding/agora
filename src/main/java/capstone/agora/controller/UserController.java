package capstone.agora.controller;

import capstone.agora.dto.ResponseDataDto;
import capstone.agora.dto.ResponseDto;
import capstone.agora.dto.user.LoginFormDto;
import capstone.agora.dto.user.RegisterFormDto;
import capstone.agora.dto.user.UserDto;
import capstone.agora.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저", description = "유저 관련 api 입니다.")
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseDto login(LoginFormDto loginFormDto) {
        return userService.login(loginFormDto);
    }

    @PostMapping("/register")
    public ResponseDto register(RegisterFormDto registerFormDto) {
        userService.register(registerFormDto);
        return ResponseDto.ofSuccess();
    }

    @GetMapping("/register/check")
    public ResponseDto duplicateIdCheck(@RequestParam String userId) {
        return userService.duplicatedIdCheck(userId);
    }

    @GetMapping("/info")
    public ResponseDataDto<UserDto> userInfo(@RequestParam String userId) {
        return userService.getUserInfo(userId);
    }

}
