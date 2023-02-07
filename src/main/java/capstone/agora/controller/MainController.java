package capstone.agora.controller;

import capstone.agora.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "api version 1.0")
@RestController
@RequestMapping("/main")
public class MainController {

    @ApiOperation(value = "공지사항 리스트", notes = "공지사항 리스트를 조회한다.")
    @GetMapping(value = "/notification")
    public ResponseDto getNotiList() {

    }

    @ApiOperation(value = "랭킹 리스트", notes = "랭킹 리스트를 조회한다.")
    @GetMapping(value = "/rank")
    public ResponseDto getRank() {

    }

    @ApiOperation(value = "열린마당", notes = "Q&A 리스트를 조회한다.")
    @GetMapping(value = "/qna")
    public ResponseDto getQnaList() {

    }
}
