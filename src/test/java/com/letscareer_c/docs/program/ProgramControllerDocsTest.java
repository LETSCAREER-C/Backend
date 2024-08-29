package com.letscareer_c.docs.program;

import com.letscareer_c.docs.RestDocsSupport;
import com.letscareer_c.domain.program.api.ProgramController;
import com.letscareer_c.domain.program.application.ProgramService;
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
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


    @DisplayName("서류 준비 태그와 챌린지 타입을 필터링한 프로그램 리스트 조회 API")
    @Test
    void getProgramList() throws Exception {
        List<String> careerTags = List.of("DOCUMENT_PREPARE");
        List<String> programTypes = List.of("CHALLENGE");

        List<CareerTagEnum> careerTagEnums = List.of(CareerTagEnum.DOCUMENT_PREPARE);
        List<ProgramTypeEnum> programTypeEnums = List.of(ProgramTypeEnum.CHALLENGE);

        //mock 객체(Service)의 특정 메서드가 호출될 때 어떤 동작을 해야 하는지를 미리 정의
        given(programService.getProgramList(careerTagEnums,programTypeEnums))
                .willReturn(List.of(ProgramListResponse.builder()
                        .programId(4L)
                        .programEndDate(LocalDateTime.now().plusDays(20))
                        .programStartDate(LocalDateTime.now().plusDays(5))
                        .intro("Intro to Challenge 1")
                        .title("Challenge 1")
                        .dtype(ProgramTypeEnum.CHALLENGE)
                        .recruitStatus(RecruitStatus.RECRUITING)
                        .recruitEndDate(LocalDateTime.now().plusDays(15))
                        .recruitStartDate(LocalDateTime.now().plusDays(5))
                        .tags(List.of(CareerTagEnum.DOCUMENT_PREPARE, CareerTagEnum.INTERVIEW_PREPARE))
                                        .price(80000)
                        .build(),
                        ProgramListResponse.builder()
                                .programId(5L)
                                .programEndDate(LocalDateTime.now().plusDays(20))
                                .programStartDate(LocalDateTime.now().plusDays(5))
                                .intro("Intro to Challenge 2")
                                .title("Challenge 2")
                                .dtype(ProgramTypeEnum.CHALLENGE)
                                .recruitStatus(RecruitStatus.RECRUITING)
                                .recruitEndDate(LocalDateTime.now().plusDays(15))
                                .recruitStartDate(LocalDateTime.now().plusDays(5))
                                .tags(List.of(CareerTagEnum.DOCUMENT_PREPARE))
                                .price(90000)
                                .build(),
                        ProgramListResponse.builder()
                                .programId(7L)
                                .programEndDate(LocalDateTime.now().plusDays(20))
                                .programStartDate(LocalDateTime.now().plusDays(5))
                                .intro("Intro to Challenge 4")
                                .title("Challenge 4")
                                .dtype(ProgramTypeEnum.CHALLENGE)
                                .recruitStatus(RecruitStatus.RECRUITING)
                                .recruitEndDate(LocalDateTime.now().plusDays(15))
                                .recruitStartDate(LocalDateTime.now().plusDays(5))
                                .tags(List.of(CareerTagEnum.DOCUMENT_PREPARE, CareerTagEnum.INTERVIEW_PREPARE))
                                .price(110000)
                                .build()
                        )
                );

        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/list")
                        .param("careerTags", careerTags.toArray(new String[0]))
                        .param("programTypes", programTypes.toArray(new String[0]))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("get-program-list",
                        // JSON이 ENTER가 포함된 모습으로 나오도록
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        queryParameters(
                                parameterWithName("careerTags").description("프로그램을 필터링하기 위한 커리어 태그 값(1개 이상/ CAREER_EXPLORE, DOCUMENT_PREPARE, INTERVIEW_PREPARE)"),
                                parameterWithName("programTypes").description("프로그램을 필터링하기 위한 프로그램 타입 값(1개 이상/ CHALLENGE,LIVECLASS)")
                        ),
                        responseFields(
                                fieldWithPath("code").type(JsonFieldType.NUMBER)
                                        .description("코드"),
                                fieldWithPath("status").type(JsonFieldType.NUMBER)
                                        .description("상태"),
                                fieldWithPath("message").type(JsonFieldType.STRING)
                                        .description("메시지"),
                                fieldWithPath("result").type(JsonFieldType.ARRAY)
                                        .description("응답 데이터"),
                                fieldWithPath("result[].dtype").description("프로그램 타입(CHALLENGE 혹은 LIVECLASS)"),
                                fieldWithPath("result[].programId").description("프로그램 식별 ID"),
                                fieldWithPath("result[].title").description("프로그램 제목"),
                                fieldWithPath("result[].intro").description("프로그램 한 줄 소개"),
                                fieldWithPath("result[].recruitStatus").description("프로그램 모집상태(UPCOMING,RECRUITING,ENDED 중 하나)"),
                                fieldWithPath("result[].tags").description("프로그램 태그들(CAREER_EXPLORE,DOCUMENT_PREPARE,INTERVICE_PREPARE 중 1개 이상"),
                                fieldWithPath("result[].recruitStartDate").description("모집 시작날"),
                                fieldWithPath("result[].recruitEndDate").description("모집 마감날"),
                                fieldWithPath("result[].programStartDate").description("프로그램 진행 시작날"),
                                fieldWithPath("result[].programEndDate").description("프로그램 진행 끝나는 날"),
                                fieldWithPath("result[].price").description("프로그램 가격")
                        )
                ));
    }
}
