package capstone.agora.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDto<D> {

    private final String resultCode;
    private final String message;
    private final D data;

    public static <D> ResponseDto<D> ofSuccess() {
        return new ResponseDto<>("success", null, null);
    }

    public static <D> ResponseDto<D> ofSuccess(String message, D data) {
        return new ResponseDto<>("success", message, data);
    }

    public static <D> ResponseDto<D> ofFail(String message) {
        return new ResponseDto<>("fail", message, null);
    }
}
