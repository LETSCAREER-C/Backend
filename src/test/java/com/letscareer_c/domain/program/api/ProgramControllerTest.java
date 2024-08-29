package com.letscareer_c.domain.program.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letscareer_c.domain.program.application.ProgramService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode.INVALID_REQUEST_CAREER_TAG;
import static com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode.INVALID_REQUEST_PROGRAM_TYPE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ProgramController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class ProgramControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProgramService programService;

    @DisplayName("프로그램 리스트를 조회한다.")
    @Test
    void getProgramList() throws Exception {
        //given
        List<String> careerTags = List.of("DOCUMENT_PREPARE");
        List<String> programTypes = List.of("CHALLENGE");

        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("careerTags", careerTags.toArray(new String[0]))
                        .param("programTypes", programTypes.toArray(new String[0]))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("프로그램 리스트 조회 시 커리어 태그는 필수값이다.")
    @Test
    void getProgramListWithoutCareerTag() throws Exception {
        //given
        List<String> programTypes = List.of("CHALLENGE");

        //when,then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("programTypes", programTypes.toArray(new String[0]))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @DisplayName("프로그램 리스트 조회 시 프로그램 타입은 필수값이다.")
    @Test
    void getProgramListWithoutType() throws Exception {
        //given
        List<String> careerTags = List.of("DOCUMENT_PREPARE");

        //when,then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("careerTags", careerTags.toArray(new String[0]))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @DisplayName("프로그램 리스트 조회 시 프로그램 타입은 챌린지와 클래스뿐이다.")
    @Test
    void getProgramListWithInvalidType() throws Exception {
        List<String> careerTags = List.of("DOCUMENT_PREPARE");
        List<String> programTypes = List.of("CHALL");

        //when,then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("careerTags", careerTags.toArray(new String[0]))
                        .param("programTypes", programTypes.toArray(new String[0]))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(String.valueOf(INVALID_REQUEST_PROGRAM_TYPE.getCode())))
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.message").value(INVALID_REQUEST_PROGRAM_TYPE.getMessage()));
    }

    @DisplayName("프로그램 리스트 조회 시 커리어타입은 서류 준비, 면접 준비, 커리어 탐색뿐이다.")
    @Test
    void getProgramListWithInvalidCareerTag() throws Exception {
        //given
        List<String> careerTags = List.of("DOCUMENT");
        List<String> programTypes = List.of("CHALL");

        //when,then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("careerTags", careerTags.toArray(new String[0]))
                        .param("programTypes", programTypes.toArray(new String[0]))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(String.valueOf(INVALID_REQUEST_CAREER_TAG.getCode())))
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.message").value(INVALID_REQUEST_CAREER_TAG.getMessage()));
    }
}