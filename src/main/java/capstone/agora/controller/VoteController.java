package capstone.agora.controller;

import capstone.agora.dto.ResponseDataDto;
import capstone.agora.dto.ResponseDto;
import capstone.agora.dto.vote.VoteDto;
import capstone.agora.dto.vote.VoteFormDto;
import capstone.agora.dto.vote.VoteJoinDto;
import capstone.agora.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/list")
    public ResponseDataDto<List<VoteDto>> getVoteList() {
        return voteService.getVoteList();
    }

    @PostMapping("/create")
    public ResponseDto createVote(@RequestParam VoteFormDto voteFormDto) {
        voteService.createVote(voteFormDto);
        return ResponseDto.ofSuccess();
    }

    @PostMapping("/join")
    public ResponseDto joinVote(@RequestBody VoteJoinDto voteJoinDto) {
        return voteService.joinVote(voteJoinDto);
    }
}
