package capstone.agora.dto.vote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ApiModel(value = "투표 생성")
public class VoteFormDto {

    @ApiModelProperty(name = "num", example = "1")
    private int num; // 게시글 번호

    @ApiModelProperty(name = "nickname", example = "캬캬캬")
    private String author; // 작성자

    @ApiModelProperty(name = "title", example = "깻잎 논쟁")
    private String title; // 투표 제목

    @ApiModelProperty(name = "context", example = "여자/남자친구와 같이 식사를 하는 자리에서 다른 이성의 깻잎을 떼어줄 수 있다!")
    private String context; // 투표 내용

    @ApiModelProperty(name = "create time", example = "2023-02-12T10:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time; // 작성 시간
}
