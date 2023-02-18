package capstone.agora.controller;

import capstone.agora.dto.user.LoginFormDto;
import capstone.agora.dto.user.RegisterFormDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("유저 로그인 테스트")
    void login() throws Exception {
        // given
        LoginFormDto loginFormDto = new LoginFormDto();
        loginFormDto.setUserId("dudwn5374");
        loginFormDto.setPassword("1234");

        // when

        // then
        mockMvc.perform(post("/user/login")
                        .content(objectMapper.writeValueAsString(loginFormDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("회원 가입 테스트")
    void register() throws Exception {
        // given
        RegisterFormDto registerFormDto = new RegisterFormDto();
        registerFormDto.setUserId("enjxz97382");
        registerFormDto.setPassword("1234");
        registerFormDto.setNickname("hi");
        registerFormDto.setEmail("enjxz97382@gmail.com");

        // then
        mockMvc.perform(post("/user/register")
                        .content(objectMapper.writeValueAsString(registerFormDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("중복 아이디 체크 테스트")
    void duplicateIdCheck() throws Exception {
        // given
        String userId = "hi";

        // then
        mockMvc.perform(get("/user/register/check")
                        .param("userId", userId))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("유저 정보 조회 테스트")
    void userInfo() throws Exception{
        // given
        String userId = "hi";

        // then
        mockMvc.perform(get("/user/info")
                        .param("userId", userId))
                .andExpect(status().isOk())
                .andDo(print());
    }
}