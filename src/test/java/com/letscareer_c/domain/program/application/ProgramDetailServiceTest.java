package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramDetailResponse;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
public class ProgramDetailServiceTest {
    @Autowired
    private ProgramDetailService programDetailService;

    @DisplayName("ProgramId에 해당하는 프로그램의 상세 정보를 조회한다.")
    @Test
    void getProgramDetail() {
        // given
        Long programId = 1L;
        String tag = CareerTagEnum.CAREER_EXPLORE.name();
        // when
        ProgramDetailResponse response = programDetailService.getProgramDetail(programId);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo("Liveclass 1");
        assertThat(response.getTag()).isEqualTo(tag);

        assertThat(response.getRecruitEndDate()).isNotNull();
        assertThat(response.getRecruitEndDate()).isInstanceOf(LocalDateTime.class);

        assertThat(response.getPcMainImageUrl()).isNotNull();

        assertThat(response.getMobileMainImageUrl()).isNotNull();

        assertThat(response.getHooking()).isNotNull();
        assertThat(response.getHooking().size()).isEqualTo(5);

        assertThat(response.getDescription()).isNotNull();
        assertThat(response.getDescription().size()).isEqualTo(6);

        assertThat(response.getLecturer()).isNotNull();

        assertThat(response.getCurriculum()).isNotNull();
        assertThat(response.getCurriculum().size()).isEqualTo(6);

        assertThat(response.getRecommendedPrograms()).isNotNull();
        assertThat(response.getRecommendedPrograms().size()).isEqualTo(2);

        assertThat(response.getFaq()).isNotNull();
        assertThat(response.getFaq().size()).isEqualTo(7);
    }

    @DisplayName("ProgramId에 해당하는 프로그램이 없는 경우 EntityNotFoundException 예외를 반환한다.")
    @Test
    void getProgramDetailWithNotExistProgram() {
        // given
        Long programId = 100L;

        // when
        // then
        assertThatThrownBy(() -> programDetailService.getProgramDetail(programId))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("programId에 해당하는 프로그램이 존재하지 않습니다.");
    }
}
