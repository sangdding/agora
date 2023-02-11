package capstone.agora.dto.user;

import capstone.agora.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {

    private String nickname; // 닉네임

    private int score; // 활동 점수

    private int debateCount; // 참여한 토론 수

    private int voteCount; // 참여한 투표 수

    private int createCount; // 작성한 게시글 수

    private int commentCount; // 작성한 댓글 수

    @Builder
    public UserDto(User user) {
        this.nickname = user.getNickname();
        this.score = user.getScore();
        this.debateCount = user.getDebateCount();
        this.voteCount = user.getVoteCount();
        this.createCount = user.getCreateCount();
        this.commentCount = user.getCommentCount();
    }
}
