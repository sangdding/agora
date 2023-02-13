package capstone.agora.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ResponseDto {

    private final int code;
    private final String message;

    public static ResponseDto ofSuccess() {
        return new ResponseDto(200, "success");
    }

    public static ResponseDto error(String message) {
        return new ResponseDto(400, message);
    }

    public static ResponseDto notFound() {
        return new ResponseDto(404, "not found");
    }
}
