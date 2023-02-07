package capstone.agora.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginFormDto {

    private String userId;
    private String password;

}
