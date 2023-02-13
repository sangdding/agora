package capstone.agora.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long id; // pk

    @Column(name = "AUTHOR")
    private String author; // 작성자

    @Column(name = "CONTEXT")
    private String context; // 본문

    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime; // 작성 시간

    @Column(name = "RECOMMEND_CNT")
    private int recommendCnt; // 추천 수

    @Column(name = "OPPOSE_CNT")
    private int opposeCnt; // 반대 수

    @ManyToOne
    @JoinColumn(name = "VOTE_ID")
    private Vote vote; // 투표 게시글

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user; // 작성자

    public void setVote(Vote vote) {
        this.vote = vote;
        if (!vote.getComments().contains(this)) {
            vote.getComments().add(this);
        }
    }

    public void setUser(User user) {
        this.user = user;
        if (!user.getComments().contains(this)) {
            user.getComments().add(this);
        }
    }
}
