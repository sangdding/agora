package capstone.agora.controller;

import capstone.agora.dto.ResponseDto;
import capstone.agora.service.MainService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "메인", description = "공지사항, faq 관련 api입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;

    @PostMapping("/notice/create")
    public ResponseDto createNotice() {
        return mainService.createNotice();
    }

    @PostMapping("/notice/delete")
    public ResponseDto deleteNotice() {
        return ResponseDto.ofSuccess();
    }

    @PostMapping("/faq/create")
    public ResponseDto createFaq() {
        return ResponseDto.ofSuccess();
    }

    @PostMapping("/faq/delete")
    public ResponseDto deleteFaq() {
        return ResponseDto.ofSuccess();
    }
}
