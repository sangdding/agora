package capstone.agora.service;

import capstone.agora.Repository.VoteRepository;
import capstone.agora.dto.ResponseDataDto;
import capstone.agora.dto.ResponseDto;
import capstone.agora.dto.vote.VoteDto;
import capstone.agora.dto.vote.VoteFormDto;
import capstone.agora.dto.vote.VoteJoinDto;
import capstone.agora.entity.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final UserService userService;

    // 투표 리스트 가져오기
    public ResponseDataDto<List<VoteDto>> getVoteList() {
        List<Vote> voteList = voteRepository.getEntireVote();
        List<VoteDto> ret = voteList.stream().map(VoteDto::new).collect(Collectors.toList());
        return ResponseDataDto.ofSuccess("ok", ret);
    }

    // 투표 개설 하기
    @Transactional
    public void createVote(VoteFormDto voteFormDto) {
        Vote vote = voteRepository.save(Vote.builder()
                .num(voteFormDto.getNum())
                .author(voteFormDto.getAuthor())
                .title(voteFormDto.getTitle())
                .context(voteFormDto.getContext())
                .time(voteFormDto.getTime())
                .agreeCount(0)
                .opposeCount(0).build());
    }

    // 투표 하기
    @Transactional
    public ResponseDto joinVote(VoteJoinDto voteJoinDto) {
        Optional<Vote> findVote = voteRepository.getVoteByVoteNum(voteJoinDto.getNum());
        if (findVote.isEmpty()) {
            return ResponseDto.error("not-found");
        }
        Vote vote = findVote.get();
        vote.vote(voteJoinDto.getVoteType());
        try {
            voteRepository.save(vote);
            return ResponseDto.ofSuccess();
        } catch (Exception e) {
            return ResponseDto.error("update-error");
        }
    }

}
