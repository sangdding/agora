package capstone.agora.dto.vote;

import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VoteJoinDto {

    private int num; // 게시글 번호

    private String userId; // 참여한 유저

    @Enumerated
    private VoteType voteType; // 투표 타입
}
