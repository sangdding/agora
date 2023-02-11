package capstone.agora.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id; // pk

    private String userId; // 사용자 아이디

    private String password; // 비밀번호

    private String nickname; // 닉네임

    private String email; // 이메일

    private int score; // 활동 점수

    private int debateCount; // 참여한 토론 수

    private int voteCount; // 참여한 투표 수

    private int createCount; // 작성한 게시글 수

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
