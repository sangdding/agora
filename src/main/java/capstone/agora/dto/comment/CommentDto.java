package capstone.agora.dto.comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentDto {

    private String author; // 작성자

    private String context; // 내용

    private int recommendCnt; // 추천 수

    private int opposeCnt; // 반대 수

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createTime; // 작성 시간

}
