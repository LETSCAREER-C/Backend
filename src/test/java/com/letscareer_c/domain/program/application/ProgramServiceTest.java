package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramDetailResponse;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.exception.ProgramException;
import com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
class ProgramServiceTest {
    @Autowired
    private ProgramService programService;

    @DisplayName("커리어 태그에 이상한 값이 들어오면 예외가 발생한다.")
    @Test
    void getWierdCareerTag(){
        //given
        String careerTag = "WEIRD";
        List<String> programTypes = List.of("LIVECLASS");
        int page = 0;
        //when & then
        assertThatThrownBy(()->programService.getProgramList(careerTag,programTypes,page))
                .isInstanceOf(ProgramException.class)
                .hasMessage(ProgramExceptionErrorCode.INVALID_REQUEST_CAREER_TAG.getMessage());
    }

    @DisplayName("프로그램 타입에 이상한 값이 들어오면 예외가 발생한다.")
    @Test
    void getWierdProgramType(){
        //given
        String careerTag = "DOCUMENT_PREPARE";
        List<String> programTypes = List.of("WEIRD");
        int page = 0;
        //when & then
        assertThatThrownBy(()->programService.getProgramList(careerTag,programTypes,page))
                .isInstanceOf(ProgramException.class)
                .hasMessage(ProgramExceptionErrorCode.INVALID_REQUEST_PROGRAM_TYPE.getMessage());
    }

    @DisplayName("ProgramId에 해당하는 프로그램의 상세 정보를 조회한다.")
    @Test
    void getProgramDetail() {
        // given
        Long programId = 1L;
        CareerTagEnum tag = CareerTagEnum.CAREER_EXPLORE;
        ProgramTypeEnum programType = ProgramTypeEnum.LIVECLASS;
        // when
        ProgramDetailResponse response = programService.getProgramDetail(programId);

        // then
        AssertionsForClassTypes.assertThat(response).isNotNull();
        AssertionsForClassTypes.assertThat(response.getTitle()).isEqualTo("Liveclass 1");
        AssertionsForClassTypes.assertThat(response.getStepType()).isEqualTo(tag);
        AssertionsForClassTypes.assertThat(response.getProgramType()).isEqualTo(programType);

        AssertionsForClassTypes.assertThat(response.getRecruitEndDate()).isNotNull();
        AssertionsForClassTypes.assertThat(response.getRecruitEndDate()).isInstanceOf(LocalDateTime.class);

        AssertionsForClassTypes.assertThat(response.getPcMainImageUrl()).isNotNull();

        AssertionsForClassTypes.assertThat(response.getMobileMainImageUrl()).isNotNull();

        AssertionsForClassTypes.assertThat(response.getHooking()).isNotNull();
        AssertionsForClassTypes.assertThat(response.getHooking().size()).isEqualTo(5);

        AssertionsForClassTypes.assertThat(response.getDescription()).isNotNull();
        AssertionsForClassTypes.assertThat(response.getDescription().size()).isEqualTo(6);

        AssertionsForClassTypes.assertThat(response.getLecturer()).isNotNull();

        AssertionsForClassTypes.assertThat(response.getCurriculum()).isNotNull();
        AssertionsForClassTypes.assertThat(response.getCurriculum().size()).isEqualTo(6);

        AssertionsForClassTypes.assertThat(response.getRecommendedPrograms()).isNotNull();
        AssertionsForClassTypes.assertThat(response.getRecommendedPrograms().size()).isEqualTo(0);

        AssertionsForClassTypes.assertThat(response.getFaq()).isNotNull();
        AssertionsForClassTypes.assertThat(response.getFaq().size()).isEqualTo(7);
    }

    @DisplayName("ProgramId에 해당하는 프로그램이 없는 경우 EntityNotFoundException 예외를 반환한다.")
    @Test
    void getProgramDetailWithNotExistProgram() {
        // given
        Long programId = 100L;


        // when & then
        // 프로그램을 조회할 때 EntityNotFoundException이 발생하는지 확인합니다.
        assertThatThrownBy(() -> programService.getProgramDetail(programId))
                .isInstanceOf(ProgramException.class);
    }

}