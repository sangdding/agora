package capstone.agora.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageDto {

    private String author; // 작성자

    private String text; // 내용

    private String timeStamp; // 작성시간

    private MessageType messageType; // 메세지 종류

}
