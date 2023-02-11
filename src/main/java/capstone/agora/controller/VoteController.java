package capstone.agora.controller;

import capstone.agora.dto.ResponseDataDto;
import capstone.agora.dto.ResponseDto;
import capstone.agora.dto.vote.VoteDto;
import capstone.agora.dto.vote.VoteFormDto;
import capstone.agora.dto.vote.VoteJoinDto;
import capstone.agora.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "api version 1.0")
@RestController
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    @ApiOperation(value = "투표 게시글 리스트", notes = "현재 개설된 투표 리스트를 확인한다.")
    @GetMapping("/list")
    public ResponseDataDto<List<VoteDto>> getVoteList() {
        return voteService.getVoteList();
    }

    @ApiOperation(value = "투표 게시하기", notes = "투표를 만든다.")
    @PostMapping("/create")
    public ResponseDto createVote(@RequestParam VoteFormDto voteFormDto) {
        voteService.createVote(voteFormDto);
        return ResponseDto.ofSuccess();
    }

    @ApiOperation(value = "투표 참여하기", notes = "투표에 참여한다.")
    @PostMapping("/join")
    public ResponseDto joinVote(@RequestBody VoteJoinDto voteJoinDto) {
        return voteService.joinVote(voteJoinDto);
    }
}
