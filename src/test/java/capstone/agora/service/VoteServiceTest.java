package capstone.agora.service;

import capstone.agora.Repository.VoteRepository;
import capstone.agora.dto.vote.VoteFormDto;
import capstone.agora.dto.vote.VoteJoinDto;
import capstone.agora.dto.vote.VoteType;
import capstone.agora.entity.Vote;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoteServiceTest {

    @Autowired
    private VoteService voteService;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("투표 생성하기")
    void createVote() {
        //given
        VoteFormDto voteFormDto = new VoteFormDto();
        voteFormDto.setNum(1);
        voteFormDto.setAuthor("dudwn5374");
        voteFormDto.setTitle("깻잎논쟁");
        voteFormDto.setContext("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        voteFormDto.setTime(LocalDateTime.now());
        //when
        voteService.createVote(voteFormDto);
        //then
        Assertions.assertTrue(voteRepository.getVoteByNum(1).isPresent());
    }

    @AfterEach
    void flush() {
        voteRepository.deleteAll();
    }

}