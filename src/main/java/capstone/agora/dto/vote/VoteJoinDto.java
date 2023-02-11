package capstone.agora.dto.vote;

import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteJoinDto {

    private int num; // 게시글 번호

    private String userId; // 참여한 유저

    @Enumerated
    private VoteType voteType; // 투표 타입
}
