package com.letscareer_c.docs.program;

import com.letscareer_c.docs.RestDocsSupport;
import com.letscareer_c.domain.program.api.ProgramController;
import com.letscareer_c.domain.program.application.ProgramDetailService;
import com.letscareer_c.domain.program.application.ProgramService;
<<<<<<< HEAD
import com.letscareer_c.domain.program.application.response.ProgramDto;
=======
import com.letscareer_c.domain.program.application.response.ProgramDetailResponse;
>>>>>>> c64573d (feat: get program detail information by program id)
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.dao.curriculum.dto.CurriculumDto;
import com.letscareer_c.domain.program.dao.description.dto.DescriptionDto;
import com.letscareer_c.domain.program.dao.description.dto.DescriptionImageDto;
import com.letscareer_c.domain.program.dao.faq.dto.FaqDto;
import com.letscareer_c.domain.program.dao.hooking.dto.HookingDto;
import com.letscareer_c.domain.program.dao.hooking.dto.HookingImageDto;
import com.letscareer_c.domain.program.dao.lecturer.dto.LecturerDto;
import com.letscareer_c.domain.program.dao.recommendedProgram.dto.RecommendedProgramDto;
import com.letscareer_c.domain.program.dao.review.dto.ReviewDto;
import com.letscareer_c.domain.program.domain.Curriculum;
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
    private final ProgramDetailService programDetailService = mock(ProgramDetailService.class);
    @Override
    protected Object initController() {
        return new ProgramController(programService, programDetailService);
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

    @DisplayName("특정 programId에 해당하는 프로그램 상세 조회 API")
    @Test
    void getProgramDetailInfoByProgramId() throws Exception {
        Long programId = 1L;

        List<CurriculumDto> curriculumDtoList = List.of(
                CurriculumDto.builder()
                        .title("Curriculum 1")
                        .content("Curriculum 1 Content")
                        .order("1")
                        .build(),
                CurriculumDto.builder()
                        .title("Curriculum 2")
                        .content("Curriculum 2 Content")
                        .order("2")
                        .build(),
                CurriculumDto.builder()
                        .title("Curriculum 3")
                        .content("Curriculum 3 Content")
                        .order("3")
                        .build(),
                CurriculumDto.builder()
                        .title("Curriculum 4")
                        .content("Curriculum 4 Content")
                        .order("4")
                        .build(),
                CurriculumDto.builder()
                        .title("Curriculum 5")
                        .content("Curriculum 5 Content")
                        .order("5")
                        .build()
        );

        List<FaqDto> faqDtoList = List.of(
                FaqDto.builder()
                        .order(1)
                        .question("Q1")
                        .answer("A1")
                        .build(),
                FaqDto.builder()
                        .order(2)
                        .question("Q2")
                        .answer("A2")
                        .build(),
                FaqDto.builder()
                        .order(3)
                        .question("Q3")
                        .answer("A3")
                        .build(),
                FaqDto.builder()
                        .order(4)
                        .question("Q4")
                        .answer("A4")
                        .build(),
                FaqDto.builder()
                        .order(5)
                        .question("Q5")
                        .answer("A5")
                        .build()
        );

        List<RecommendedProgramDto> recommendedProgramDtoList = List.of(
                RecommendedProgramDto.builder()
                        .programId(1L)
                        .title("Recommended Program 1")
                        .tag(CareerTagEnum.DOCUMENT_PREPARE)
                        .thumbnail("Recommended Program 1 Thumbnail")
                        .intro("Recommended Program 1 Intro")
                        .recruitEndDate(LocalDate.now())
                        .programStartDate(LocalDate.now())
                        .programEndDate(LocalDate.now())
                        .build(),
                RecommendedProgramDto.builder()
                        .programId(1L)
                        .title("Recommended Program 2")
                        .tag(CareerTagEnum.DOCUMENT_PREPARE)
                        .thumbnail("Recommended Program 2 Thumbnail")
                        .intro("Recommended Program 2 Intro")
                        .recruitEndDate(LocalDate.now())
                        .programStartDate(LocalDate.now())
                        .programEndDate(LocalDate.now())
                        .build()

        );
        List<Object> hookingDtoList = List.of(
                HookingDto.builder()
                        .order(1)
                        .title("Hooking 1")
                        .content("Hooking 1 Content")
                        .order(1)
                        .templateType("blue")
                        .hookingImageList(List.of(
                                HookingImageDto.builder()
                                        .imageUrl("Hooking 1 Image 1")
                                        .order(1)
                                        .build(),
                                HookingImageDto.builder()
                                        .imageUrl("Hooking 1 Image 2")
                                        .order(2)
                                        .build(),
                                HookingImageDto.builder()
                                        .imageUrl("Hooking 1 Image 3")
                                        .order(3)
                                        .build()
                        ))
                        .build()
        );
        List<Object> descriptionDtoList = List.of(
                DescriptionDto.builder()
                        .title("Description 1")
                        .content("Description 1 Content")
                        .order(1)
                        .templateType("blue")
                        .descriptionImages(List.of(
                                DescriptionImageDto.builder()
                                        .imageUrl("Description 1 Image 1")
                                        .order(1)
                                        .build(),
                                DescriptionImageDto.builder()
                                        .imageUrl("Description 1 Image 2")
                                        .order(2)
                                        .build(),
                                DescriptionImageDto.builder()
                                        .imageUrl("Description 1 Image 3")
                                        .order(3)
                                        .build()
                        ))
                        .build(),
                DescriptionDto.builder()
                        .title("Description 2")
                        .content("Description 2 Content")
                        .order(2)
                        .templateType("blue")
                        .descriptionImages(List.of(
                                DescriptionImageDto.builder()
                                        .imageUrl("Description 2 Image 1")
                                        .order(1)
                                        .build(),
                                DescriptionImageDto.builder()
                                        .imageUrl("Description 2 Image 2")
                                        .order(2)
                                        .build(),
                                DescriptionImageDto.builder()
                                        .imageUrl("Description 2 Image 3")
                                        .order(3)
                                        .build()
                        ))
                        .build()
        );
        LecturerDto lecturerDto = LecturerDto.builder()
                .name("Lecturer 1")
                .career("Lecturer 1 Career")
                .profileImage("https://profile-image.com")
                .templateType("blue")
                .build();
        List<ReviewDto> latestReviews = List.of(
                ReviewDto.builder()
                        .content("Review 1 Content")
                        .grade(4)
                        .userName("Review 1 User")
                        .build(),
                ReviewDto.builder()
                        .content("Review 2 Content")
                        .grade(4)
                        .userName("Review 2 Nickname")
                        .build(),
                ReviewDto.builder()
                        .content("Review 3 Content")
                        .grade(3)
                        .userName("Review 3 Nickname")
                        .build()
        );

        List<ReviewDto> bestReviews = List.of(
                ReviewDto.builder()
                        .content("Review 1 Content")
                        .grade(5)
                        .userName("Review 1 User")
                        .build(),
                ReviewDto.builder()
                        .content("Review 2 Content")
                        .grade(5)
                        .userName("Review 2 Nickname")
                        .build(),
                ReviewDto.builder()
                        .content("Review 3 Content")
                        .grade(4)
                        .userName("Review 3 Nickname")
                        .build()
        );

        given(programDetailService.getProgramDetail(programId))
                .willReturn(ProgramDetailResponse.builder()
                        .title("Program 1")
                        .recruitEndDate(LocalDateTime.now().plusDays(15))
                        .tag(CareerTagEnum.DOCUMENT_PREPARE.name())
                        .pcMainImageUrl("https://main-image.com")
                        .mobileMainImageUrl("https://main-image.com")
                        .description(descriptionDtoList)
                        .hooking(hookingDtoList)
                        .lecturer(lecturerDto)
                        .curriculum(curriculumDtoList)
                        .latestReviews(latestReviews)
                        .bestReviews(bestReviews)
                        .recommendedPrograms(recommendedProgramDtoList)
                        .faq(faqDtoList)
                        .build()
                );

        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/program/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("get-program-detail",
                        // JSON이 ENTER가 포함된 모습으로 나오도록
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("code").type(JsonFieldType.NUMBER).description("코드"),
                                fieldWithPath("status").type(JsonFieldType.NUMBER).description("상태"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
                                fieldWithPath("result").type(JsonFieldType.OBJECT).description("응답 데이터"),
                                fieldWithPath("result.title").type(JsonFieldType.STRING).description("프로그램 제목"),
                                fieldWithPath("result.tag").type(JsonFieldType.STRING).description("프로그램 태그"),
                                fieldWithPath("result.recruitEndDate").type(JsonFieldType.ARRAY).description("모집 마감 날짜"),
                                fieldWithPath("result.pcMainImageUrl").type(JsonFieldType.STRING).description("PC 메인 이미지 URL"),
                                fieldWithPath("result.mobileMainImageUrl").type(JsonFieldType.STRING).description("Mobile 메인 이미지 URL"),
                                fieldWithPath("result.description").type(JsonFieldType.ARRAY).description("프로그램 상세 정보(Description)"),
                                fieldWithPath("result.hooking").type(JsonFieldType.ARRAY).description("프로그램 상세 정보(Hooking)"),
                                fieldWithPath("result.lecturer").type(JsonFieldType.OBJECT).description("프로그램 상세 정보(연사 정보)"),
                                fieldWithPath("result.curriculum").type(JsonFieldType.ARRAY).description("프로그램 상세 정보(커리큘럼)"),
                                fieldWithPath("result.latestReviews").type(JsonFieldType.ARRAY).description("프로그램 상세 정보(최신 리뷰)"),
                                fieldWithPath("result.bestReviews").type(JsonFieldType.ARRAY).description("프로그램 상세 정보(평점순 리뷰)"),
                                fieldWithPath("result.recommendedPrograms").type(JsonFieldType.ARRAY).description("프로그램 상세 정보(추천 강좌)"),
                                fieldWithPath("result.faq").type(JsonFieldType.ARRAY).description("프로그램 상세 정보(FAQ)"),

                                fieldWithPath("result.hooking[].title").type(JsonFieldType.STRING).description("Hooking 제목"),
                                fieldWithPath("result.hooking[].content").type(JsonFieldType.STRING).description("Hooking 내용"),
                                fieldWithPath("result.hooking[].order").type(JsonFieldType.NUMBER).description("Hooking 순서"),
                                fieldWithPath("result.hooking[].templateType").type(JsonFieldType.STRING).description("Hooking 템플릿 타입"),
                                fieldWithPath("result.hooking[].hookingImageList[].imageUrl").type(JsonFieldType.STRING).description("Hooking 이미지 URL"),
                                fieldWithPath("result.hooking[].hookingImageList[].order").type(JsonFieldType.NUMBER).description("Hooking 이미지 순서"),

                                fieldWithPath("result.description[].title").type(JsonFieldType.STRING).description("Description 제목"),
                                fieldWithPath("result.description[].content").type(JsonFieldType.STRING).description("Description 내용"),
                                fieldWithPath("result.description[].order").type(JsonFieldType.NUMBER).description("Description 순서"),
                                fieldWithPath("result.description[].templateType").type(JsonFieldType.STRING).description("Description 템플릿 타입"),
                                fieldWithPath("result.description[].descriptionImages[].imageUrl").type(JsonFieldType.STRING).description("Description 이미지 URL"),
                                fieldWithPath("result.description[].descriptionImages[].order").type(JsonFieldType.NUMBER).description("Description 이미지 순서"),

                                fieldWithPath("result.lecturer.name").type(JsonFieldType.STRING).description("연사 이름"),
                                fieldWithPath("result.lecturer.career").type(JsonFieldType.STRING).description("연사 경력"),
                                fieldWithPath("result.lecturer.profileImage").type(JsonFieldType.STRING).description("연사 프로필 이미지 URL"),
                                fieldWithPath("result.lecturer.templateType").type(JsonFieldType.STRING).description("연사 템플릿 타입"),

                                fieldWithPath("result.curriculum[].order").type(JsonFieldType.STRING).description("커리큘럼 순서"),
                                fieldWithPath("result.curriculum[].title").type(JsonFieldType.STRING).description("커리큘럼 제목"),
                                fieldWithPath("result.curriculum[].content").type(JsonFieldType.STRING).description("커리큘럼 내용"),

                                fieldWithPath("result.latestReviews[].userName").type(JsonFieldType.STRING).description("리뷰 작성자"),
                                fieldWithPath("result.latestReviews[].content").type(JsonFieldType.STRING).description("리뷰 내용"),
                                fieldWithPath("result.latestReviews[].grade").type(JsonFieldType.NUMBER).description("리뷰 점수"),

                                fieldWithPath("result.bestReviews[].userName").type(JsonFieldType.STRING).description("리뷰 작성자"),
                                fieldWithPath("result.bestReviews[].content").type(JsonFieldType.STRING).description("리뷰 내용"),
                                fieldWithPath("result.bestReviews[].grade").type(JsonFieldType.NUMBER).description("리뷰 점수"),

                                fieldWithPath("result.recommendedPrograms[].programId").type(JsonFieldType.NUMBER).description("추천 프로그램 ID"),
                                fieldWithPath("result.recommendedPrograms[].tag").type(JsonFieldType.STRING).description("추천 프로그램 태그"),
                                fieldWithPath("result.recommendedPrograms[].title").type(JsonFieldType.STRING).description("추천 프로그램 제목"),
                                fieldWithPath("result.recommendedPrograms[].intro").type(JsonFieldType.STRING).description("추천 프로그램 소개"),
                                fieldWithPath("result.recommendedPrograms[].thumbnail").type(JsonFieldType.STRING).description("추천 프로그램 썸네일"),
                                fieldWithPath("result.recommendedPrograms[].recruitEndDate").type(JsonFieldType.ARRAY).description("추천 프로그램 모집 종료 날짜"),
                                fieldWithPath("result.recommendedPrograms[].programStartDate").type(JsonFieldType.ARRAY).description("추천 프로그램 시작 날짜"),
                                fieldWithPath("result.recommendedPrograms[].programEndDate").type(JsonFieldType.ARRAY).description("추천 프로그램 종료 날짜"),

                                fieldWithPath("result.faq[].order").type(JsonFieldType.NUMBER).description("FAQ 순서"),
                                fieldWithPath("result.faq[].question").type(JsonFieldType.STRING).description("FAQ 질문"),
                                fieldWithPath("result.faq[].answer").type(JsonFieldType.STRING).description("FAQ 답변")
                        )
                ));
    }
}
