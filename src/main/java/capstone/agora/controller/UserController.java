package capstone.agora.controller;

import capstone.agora.dto.LoginFormDto;
import capstone.agora.dto.RegisterFormDto;
import capstone.agora.dto.ResponseDataDto;
import capstone.agora.dto.ResponseDto;
import capstone.agora.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(value = "version 1.0")
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "로그인", notes = "유저 로그인 폼 데이터를 전송한다.")
    @PostMapping("/login")
    public ResponseDto login(@RequestParam LoginFormDto loginFormDto) {
        return userService.login(loginFormDto);
    }

    @ApiOperation(value = "회원가입", notes = "유저 회원가입 폼 데이터를 전송한다.")
    @PostMapping("/register")
    public ResponseDto register(@RequestParam RegisterFormDto registerFormDto) {
        userService.register(registerFormDto);
        return ResponseDto.ofSuccess();
    }

    @ApiOperation(value = "아이디 중복확인", notes = "회원가입시 아이디 중복 확인한다.")
    @GetMapping("/register/check")
    public ResponseDto duplicateIdCheck(@RequestParam String userId) {
        return userService.duplicatedIdCheck(userId);
    }

    @ApiOperation(value = "유저 정보 조회", notes = "유저의 정보를 조회한다.")
    @GetMapping("/info")
    public ResponseDataDto userInfo(@RequestParam String userId) {
        return userInfo(userId);
    }

}
