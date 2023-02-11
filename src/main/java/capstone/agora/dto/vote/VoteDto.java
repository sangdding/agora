package capstone.agora.dto.vote;

import capstone.agora.entity.Vote;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class VoteDto {

    private int num; // 게시글 번호

    private String author; // 작성자

    private String title; // 투표 제목

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time; // 작성 시간

    public VoteDto(Vote vote) {
        this.num = vote.getNum();
        this.author = vote.getAuthor();
        this.title = vote.getTitle();
        this.time = vote.getTime();
    }

}
