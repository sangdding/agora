package capstone.agora.controller;

import capstone.agora.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "version 1.0")
@RequestMapping("/user")
@RestController
public class UserController {

    @ApiOperation(value = "로그인", notes = "유저 로그인 폼 데이터를 전송한다.")
    @PostMapping("/login")
    public ResponseDto login() {

    }

    @ApiOperation(value = "회원가입", notes = "유저 회원가입 폼 데이터를 전송한다.")
    @PostMapping("/register")
    public ResponseDto register() {

    }

    @ApiOperation(value = "유저 정보 조회", notes = "유저의 정보를 조회한다.")
    @GetMapping("/info")
    public ResponseDto userInfo() {

    }

}
