package capstone.agora.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(type = "object")
public class LoginFormDto {

    @Schema(
            name = "id",
            example = "dudwn5374",
            type = "string"
    )
    private String userId;

    @Schema(
            name = "password",
            example = "dudwn5374",
            type = "string"
    )
    private String password;

}
