package capstone.agora.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "회원 가입")
public class RegisterFormDto {

    private String userId;

    private String password;

    private String email;

    private String nickname;
}
