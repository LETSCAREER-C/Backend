package com.letscareer_c.docs.program;

import com.letscareer_c.docs.RestDocsSupport;
import com.letscareer_c.domain.program.api.ProgramController;
import com.letscareer_c.domain.program.application.ProgramService;
import com.letscareer_c.domain.program.application.response.ProgramDto;
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.queryParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProgramControllerDocsTest extends RestDocsSupport{
    private final ProgramService programService = mock(ProgramService.class);

    @Override
    protected Object initController() {
        return new ProgramController(programService);
    }


    @DisplayName("서류 준비 커리어 태그와 챌린지 타입을 필터링한 프로그램 0페이지 리스트 조회 API")
    @Test
    void getProgramList() throws Exception {
        String careerTag = "DOCUMENT_PREPARE";
        List<String> programTypes = List.of("CHALLENGE");
        int page = 0;
        //mock 객체(Service)의 특정 메서드가 호출될 때 어떤 동작을 해야 하는지를 미리 정의
        given(programService.getProgramList(careerTag,programTypes,page))
                .willReturn(ProgramListResponse.builder().programDtos(List.of(
                        ProgramDto.builder().programId(5L)
                                .programEndDate(LocalDateTime.now().plusDays(20))
                                .programStartDate(LocalDateTime.now().plusDays(5))
                                .intro("Intro to Challenge 2")
                                .title("Challenge 2")
                                .thumbnail("https://image_url")
                                .dtype(ProgramTypeEnum.CHALLENGE)
                                .recruitStatus(RecruitStatus.RECRUITING)
                                .recruitEndDate(LocalDateTime.now().plusDays(5))
                                .recruitStartDate(LocalDateTime.now().minusDays(15))
                                .tag(CareerTagEnum.DOCUMENT_PREPARE)
                                .deadline(3)
                                .build(),
                                        ProgramDto.builder()
                                                .programId(6L)
                                                .programEndDate(LocalDateTime.now().plusDays(20))
                                                .programStartDate(LocalDateTime.now().plusDays(5))
                                                .intro("Intro to Challenge 3")
                                                .title("Challenge 3")
                                                .thumbnail("https://image_url")
                                                .dtype(ProgramTypeEnum.CHALLENGE)
                                                .recruitStatus(RecruitStatus.RECRUITING)
                                                .recruitEndDate(LocalDateTime.now().plusDays(5))
                                                .recruitStartDate(LocalDateTime.now().minusDays(15))
                                                .tag(CareerTagEnum.DOCUMENT_PREPARE)
                                                .deadline(2)
                                                .build(),
                        ProgramDto.builder()
                                .programId(12L)
                                .programEndDate(LocalDateTime.now().plusDays(21))
                                .programStartDate(LocalDateTime.now().plusDays(7))
                                .intro("Intro to Challenge 6")
                                .title("Challenge 6")
                                .thumbnail("https://image_url")
                                .dtype(ProgramTypeEnum.CHALLENGE)
                                .recruitStatus(RecruitStatus.RECRUITING)
                                .recruitEndDate(LocalDateTime.now().plusDays(2))
                                .recruitStartDate(LocalDateTime.now().plusDays(20))
                                .tag(CareerTagEnum.DOCUMENT_PREPARE)
                                .deadline(2)
                                .build())
                        ).totalPageCount(1)
                        .build());

        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("careerTag", careerTag)
                        .param("programTypes", programTypes.toArray(new String[0]))
                        .param("page",String.valueOf(page))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("get-program-list",
                        // JSON이 ENTER가 포함된 모습으로 나오도록
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        queryParameters(
                                parameterWithName("careerTag").description("프로그램을 필터링하기 위한 커리어 태그 값(ALL 혹은 특정 1개/ CAREER_EXPLORE, DOCUMENT_PREPARE, INTERVIEW_PREPARE)"),
                                parameterWithName("programTypes").description("프로그램을 필터링하기 위한 프로그램 타입 값(1개 이상/ CHALLENGE,LIVECLASS)"),
                                parameterWithName("page").description("페이지 수(0부터 시작)")
                        ),
                        responseFields(
                                fieldWithPath("code").type(JsonFieldType.NUMBER).description("코드"),
                                fieldWithPath("status").type(JsonFieldType.NUMBER).description("상태"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("result").type(JsonFieldType.OBJECT).description("응답 데이터(프로그램 리스트와 전체 페이지 수)"),
                                fieldWithPath("result.programDtos[].dtype").type(JsonFieldType.STRING).description("프로그램 타입 (CHALLENGE 혹은 LIVECLASS)"), //응답 순서도 맞춰야함
                                fieldWithPath("result.programDtos[].programId").type(JsonFieldType.NUMBER).description("프로그램 식별 ID"),
                                fieldWithPath("result.programDtos[].title").type(JsonFieldType.STRING).description("프로그램 제목"),
                                fieldWithPath("result.programDtos[].intro").type(JsonFieldType.STRING).description("프로그램 한 줄 소개"),
                                fieldWithPath("result.programDtos[].recruitStatus").type(JsonFieldType.STRING).description("프로그램 모집 상태 (UPCOMING, RECRUITING, ENDED 중 하나)"),
                                fieldWithPath("result.programDtos[].thumbnail").type(JsonFieldType.STRING).description("프로그램 썸네일"),
                                fieldWithPath("result.programDtos[].tag").type(JsonFieldType.STRING).description("프로그램 태그 (CAREER_EXPLORE, DOCUMENT_PREPARE, INTERVIEW_PREPARE 중 1개)"),
                                fieldWithPath("result.programDtos[].recruitStartDate").type(JsonFieldType.ARRAY).description("모집 시작 날짜"),
                                fieldWithPath("result.programDtos[].recruitEndDate").type(JsonFieldType.ARRAY).description("모집 마감 날짜"),
                                fieldWithPath("result.programDtos[].programStartDate").type(JsonFieldType.ARRAY).description("프로그램 진행 시작 날짜"),
                                fieldWithPath("result.programDtos[].programEndDate").type(JsonFieldType.ARRAY).description("프로그램 진행 끝나는 날짜"),
                                fieldWithPath("result.programDtos[].deadline").type(JsonFieldType.NUMBER).description("모집 마감 D-Day"),
                                fieldWithPath("result.totalPageCount").type(JsonFieldType.NUMBER).description("전체 페이지 수")
                        )
                ));
    }
}
