package capstone.agora.dto.comment;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@RequiredArgsConstructor
public class CommentFormDto {

    private String author; // 작성자

    private String context; // 내용

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time; // 작성 시간

}
