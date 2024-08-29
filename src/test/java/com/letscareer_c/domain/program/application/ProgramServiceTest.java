package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ProgramServiceTest {
    @Autowired
    private ProgramService programService;

    @DisplayName("챌린지 타입 조회 조건을 받아 응답을 생성한다.")
    @Test
    void getChallengeList(){
        //when
        List<ProgramListResponse> response = programService.getProgramList(
                List.of(CareerTagEnum.DOCUMENT_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE)
        );

        //then
        assertThat(response).hasSize(3)
                .extracting("programId","title")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(4L,"Challenge 1"),
                        Tuple.tuple(5L,"Challenge 2"),
                        Tuple.tuple(7L,"Challenge 4")
                );
    }

    @DisplayName("클래스 타입 조회 조건을 받아 응답을 생성한다.")
    @Test
    void getLiveclassList(){
        //when
        List<ProgramListResponse> response = programService.getProgramList(
                List.of(CareerTagEnum.DOCUMENT_PREPARE),
                List.of(ProgramTypeEnum.LIVECLASS));

        //then
        assertThat(response).hasSize(2)
                .extracting("programId","title")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(1L,"Liveclass 1"),
                        Tuple.tuple(2L,"Liveclass 2")
                );
    }

    @DisplayName("모든 타입 조회 조건을 받아 응답을 생성한다.")
    @Test
    void getAllProgramList(){
        //when
        List<ProgramListResponse> response = programService.getProgramList(
                List.of(CareerTagEnum.DOCUMENT_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE, ProgramTypeEnum.LIVECLASS)
        );

        //then
        assertThat(response).hasSize(5)
                .extracting("programId","title")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(1L,"Liveclass 1"),
                        Tuple.tuple(2L,"Liveclass 2"),
                        Tuple.tuple(4L,"Challenge 1"),
                        Tuple.tuple(5L,"Challenge 2"),
                        Tuple.tuple(7L,"Challenge 4")
                );
    }
}