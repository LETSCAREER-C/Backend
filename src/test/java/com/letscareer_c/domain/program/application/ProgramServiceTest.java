package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.exception.ProgramException;
import com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
class ProgramServiceTest {
    @Autowired
    private ProgramService programService;

    @DisplayName("전체보기 커리어 태그, 챌린지 타입 조회 조건을 받아 응답을 생성한다.")
    @Test
    void getChallengeList(){
        //given
        String careerTag = "ALL";
        List<String> programTypes = List.of("CHALLENGE");
        int page = 0;
        //when
        ProgramListResponse response = programService.getProgramList(careerTag,programTypes,page);
        //then
        assertThat(response.getProgramDtos()).hasSize(8)
                .extracting("programId","title")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(4L,"Challenge 1"),
                        Tuple.tuple(5L,"Challenge 2"),
                        Tuple.tuple(6L,"Challenge 3"),
                        Tuple.tuple(7L,"Challenge 4"),
                        Tuple.tuple(11L,"Challenge 5"),
                        Tuple.tuple(12L,"Challenge 6"),
                        Tuple.tuple(13L,"Challenge 7"),
                        Tuple.tuple(14L,"Challenge 8")
                );
    }

    @DisplayName("서류 준비 커리어 태그, 클래스 타입 조회 조건을 받아 응답을 생성한다.")
    @Test
    void getLiveclassList(){
        //given
        String careerTag = "DOCUMENT_PREPARE";
        List<String> programTypes = List.of("LIVECLASS");
        int page = 0;
        //when
        ProgramListResponse response = programService.getProgramList(careerTag,programTypes,page);
        //then
        assertThat(response.getProgramDtos()).hasSize(2)
                .extracting("programId","title")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(2L,"Liveclass 2"),
                        Tuple.tuple(9L,"Liveclass 5")
                );
    }

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
}