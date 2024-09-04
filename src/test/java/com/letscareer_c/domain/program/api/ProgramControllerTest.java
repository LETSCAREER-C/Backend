package com.letscareer_c.domain.program.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letscareer_c.domain.program.application.ProgramService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ProgramController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class ProgramControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProgramService programService;

    @DisplayName("서류 준비 커리어 태그, 챌린티 타입의 0 페이지 프로그램 리스트를 조회한다.")
    @Test
    void getProgramList() throws Exception {
        //given
        String careerTag = "DOCUMENT_PREPARE";
        List<String> programTypes = List.of("CHALLENGE");
        int page = 0;

        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("careerTag", careerTag)
                        //?programTypes=CHALLENGE&programTypes=LIVECLASS 같이 요청받음
                        .param("programTypes", programTypes.toArray(new String[programTypes.size()]))
                        .param("page", String.valueOf(page))
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

    @DisplayName("프로그램 상세 조회 성공")
    @Test
    void getProgramDetail() throws Exception {
        //given
        Long programId = 1L;
        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/{programId}", programId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}