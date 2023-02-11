package capstone.agora.entity;

import capstone.agora.entity.User;
import capstone.agora.entity.Vote;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long id; // pk

    private String author; // 작성자

    private String context; // 본문

    private LocalDateTime createTime; // 작성 시간

    private int recommendCnt; // 추천 수

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
