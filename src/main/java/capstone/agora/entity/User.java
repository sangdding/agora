package capstone.agora.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id; // pk

    @Column(name = "userId")
    private String userId; // 사용자 아이디

    @Column(name = "password")
    private String password; // 비밀번호

    @Column(name = "nickname")
    private String nickname; // 닉네임

    @Column(name = "email")
    private String email; // 이메일

    @Column(name = "score")
    private int score; // 활동 점수

    @Column(name = "debateCount")
    private int debateCount; // 참여한 토론 수

    @Column(name = "voteCount")
    private int voteCount; // 참여한 투표 수

    @Column(name = "createCount")
    private int createCount; // 작성한 게시글 수

    @Column(name = "commentCount")
    private int commentCount; // 작성한 댓글 수

    @Builder
    public User(String userId, String password, String nickname, String email, int score, int debateCount, int voteCount, int createCount, int commentCount) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.score = score;
        this.debateCount = debateCount;
        this.voteCount = voteCount;
        this.createCount = createCount;
        this.commentCount = commentCount;
    }
}
