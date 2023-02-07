package capstone.agora.controller;

import capstone.agora.dto.ResponseDataDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "version 1.0")
@RequestMapping("/agora")
@RestController
public class AgoraController {

    @ApiOperation(value = "실시간 토론방 리스트", notes = "현재 개설된 실시간 토론 방 리스트를 조회한다.")
    @GetMapping("/list/realtime")
    public ResponseDataDto getRealTimeRoomList() {

    }

    @ApiOperation(value = "종료된 토론방 리스트", notes = "종료된 토론방 리스트를 조회한다.")
    @GetMapping("/list/general")
    public ResponseDataDto getGeneralRoomList() {

    }
}
