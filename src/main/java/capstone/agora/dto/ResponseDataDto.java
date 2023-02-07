package capstone.agora.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDataDto<D> {

    private final String resultCode;
    private final String message;
    private final D data;

    public static <D> ResponseDataDto<D> ofSuccess() {
        return new ResponseDataDto<>("success", null, null);
    }

    public static <D> ResponseDataDto<D> ofSuccess(String message, D data) {
        return new ResponseDataDto<>("success", message, data);
    }

    public static <D> ResponseDataDto<D> ofFail(String message) {
        return new ResponseDataDto<>("fail", message, null);
    }
}
