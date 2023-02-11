package capstone.agora.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterFormDto {

    private String userId;

    private String password;

    private String email;

    private String nickname;
}
