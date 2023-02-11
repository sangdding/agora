package capstone.agora.entity;

import capstone.agora.dto.vote.VoteType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "VOTE")
@Builder
@NoArgsConstructor
public class Vote {

    @Id
    @Column(name = "VOTE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // pk

    @Column(name = "postNum")
    private int num; // 게시글 번호

    @Column(name = "author")
    private String author; // 작성자

    @Column(name = "title")
    private String title; // 제목

    @Column(name = "context")
    private String context; // 내용

    @Column(name = "dateTime")
    private LocalDateTime time; // 작성 시간

    @Column(name = "agreeCount")
    private int agreeCount; // 찬성 수

    @Column(name = "opposeCount")
    private int opposeCount; // 반대 수

    @OneToMany(mappedBy = "vote")
    @Column(name = "comments")
    private List<Comment> comments; // 댓글

    public void vote(VoteType voteType) {
        if (voteType.equals(VoteType.AGREE)) {
            this.agreeCount += 1;
        } else {
            this.opposeCount += 1;
        }
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        if (comment.getVote() != this) {
            comment.setVote(this);
        }
    }

}
