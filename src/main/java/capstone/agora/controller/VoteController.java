package capstone.agora.controller;

import capstone.agora.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "api version 1.0")
@RestController
@RequestMapping("/vote")
public class VoteController {

    @ApiOperation(value = "투표 게시글 리스트", notes = "현재 개설된 투표 리스트를 확인한다.")
    @GetMapping("/list")
    public ResponseDto getVoteList() {

    }
}
