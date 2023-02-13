package capstone.agora.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id; // pk

    @Column(name = "USER_IDENTIFIER")
    private String userIdentifier; // 사용자 아이디

    @Column(name = "PASSWORD")
    private String password; // 비밀번호

    @Column(name = "NICKNAME")
    private String nickname; // 닉네임

    @Column(name = "EMAIL")
    private String email; // 이메일

    @Column(name = "SCORE")
    private int score; // 활동 점수

    @Column(name = "DEBATE_COUNT")
    private int debateCount; // 참여한 토론 수

    @Column(name = "VOTE_COUNT")
    private int voteCount; // 참여한 투표 수

    @Column(name = "CREATE_COUNT")
    private int createCount; // 작성한 게시글 수

    @Column(name = "COMMENT_COUNT")
    private int commentCount; // 작성한 댓글 수

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    private void addComment(Comment comment) {
        this.comments.add(comment);
        if (comment.getUser() != this) {
            comment.setUser(this);
        }
    }
}
