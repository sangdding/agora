package capstone.agora.controller;

import capstone.agora.dto.vote.VoteFormDto;
import capstone.agora.dto.vote.VoteJoinDto;
import capstone.agora.dto.vote.VoteType;
import capstone.agora.service.VoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(VoteController.class)
class VoteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VoteService voteService;

    String now = "2022-12-21T10:24:11";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @CreatedDate
    LocalDateTime formatDateTime = LocalDateTime.parse(now, dateTimeFormatter);
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("투표 목록 조회 테스트")
    void getVoteList() throws Exception {

        mockMvc.perform(get("/vote/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("투표 생성 테스트")
    void createVote() throws Exception {

        // given
        VoteFormDto voteFormDto = new VoteFormDto();
        voteFormDto.setAuthor("hi");
        voteFormDto.setContext("투표입니다.");
        voteFormDto.setNum(1);
        voteFormDto.setTime(formatDateTime);
        voteFormDto.setTitle("테스트");

        // then
        mockMvc.perform(post("/vote/create")
                        .content(objectMapper.writeValueAsString(voteFormDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("투표 참여 테스트")
    void joinVote() throws Exception{

        //given
        VoteJoinDto voteJoinDto = new VoteJoinDto();
        voteJoinDto.setVoteType(VoteType.AGREE);
        voteJoinDto.setNum(1);
        voteJoinDto.setUserId("hi");

        //then
        mockMvc.perform(post("/vote/join")
                        .content(objectMapper.writeValueAsString(voteJoinDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}