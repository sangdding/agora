package capstone.agora.dto.user;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Schema(description = "로그인 요청 DTO")
@Getter
@Setter
@RequiredArgsConstructor
public class LoginFormDto {

    @Parameter(description = "유저 아이디")
    private String userId;

    @Parameter(description = "유저 비밀번호")
    private String password;

}
