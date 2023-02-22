package capstone.agora.service;

import capstone.agora.Repository.FaqRepository;
import capstone.agora.Repository.NoticeRepository;
import capstone.agora.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final FaqRepository faqRepository;
    private final NoticeRepository noticeRepository;

    @Transactional
    public ResponseDto createNotice() {

        return ResponseDto.ofSuccess();
    }

}
