package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.api.request.ProgramListRequest;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(locations = "classpath:application.yml")
@SpringBootTest
class ProgramRepositoryTest {
    @Autowired
    private ProgramRepository programRepository;
    @Test
    @DisplayName("모든 태그, 모든 타입에 해당하는 프로그램들을 조회한다.")
    void findAllPrograms() {
        ProgramListRequest request = new ProgramListRequest(
                List.of(CareerTagEnum.CAREER_EXPLORE,CareerTagEnum.DOCUMENT_PREPARE,CareerTagEnum.INTERVIEW_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE,ProgramTypeEnum.LIVECLASS)
        );
        List<Program> programs = programRepository.findByCondition(request);
        assertEquals(7, programs.size());
    }

    @Test
    @DisplayName("서류 준비 태그, 챌린지 타입에 해당하는 프로그램들을 조회한다.")
    void findDocumentPrepareTagAndChallengeTypePrograms() {
        ProgramListRequest request = new ProgramListRequest(
                List.of(CareerTagEnum.DOCUMENT_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE)
        );
        List<Program> programs = programRepository.findByCondition(request);
        assertEquals(3, programs.size());
    }

    @Test
    @DisplayName("서류 준비 태그 또는 면접 준비 태그, 그리고 챌린지 타입에 해당하는 프로그램들을 조회한다.")
    void findDocumentPrepareInterViewPrepareTagsAndChallengeTypePrograms() {
        ProgramListRequest request = new ProgramListRequest(
                List.of(CareerTagEnum.DOCUMENT_PREPARE,CareerTagEnum.INTERVIEW_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE)
        );
        List<Program> programs = programRepository.findByCondition(request);
        assertEquals(3, programs.size());
    }

    @Test
    @DisplayName("서류 준비 태그 또는 면접 준비 태그,그리고 챌린지 타입 또는 클래스 타입에 해당하는 프로그램들을 조회한다.")
    void findDocumentPrepareInterViewPrepareTagsAndChallengeClassTypePrograms() {
        ProgramListRequest request = new ProgramListRequest(
                List.of(CareerTagEnum.DOCUMENT_PREPARE,CareerTagEnum.INTERVIEW_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE,ProgramTypeEnum.LIVECLASS)
        );
        List<Program> programs = programRepository.findByCondition(request);
        assertEquals(5, programs.size());
    }
}