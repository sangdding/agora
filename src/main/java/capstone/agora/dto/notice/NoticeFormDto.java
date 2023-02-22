package capstone.agora.dto.notice;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "공지사항 생성 DTO")
@RequiredArgsConstructor
public class NoticeFormDto {

    @Parameter(description = "글 번호")
    private int num;

    @Parameter(description = "작성자")
    private String author;

    @Parameter(description = "제목")
    private String title;

    @Parameter(description = "내용")
    private String context;

    @Parameter(description = "작성일시")
    private LocalDateTime createTime;

}
