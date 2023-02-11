package capstone.agora.dto.vote;

import javax.persistence.Enumerated;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "투표 참여")
public class VoteJoinDto {

    @ApiModelProperty(name = "num", example = "1")
    private int num; // 게시글 번호

    @ApiModelProperty(name = "userId", example = "dudwn5374")
    private String userId; // 참여한 유저

    @Enumerated
    @ApiModelProperty(name = "voteType", example = "AGREE/OPPOSE")
    private VoteType voteType; // 투표 타입
}
