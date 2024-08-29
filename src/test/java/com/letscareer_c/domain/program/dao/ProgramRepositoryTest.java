package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.dao.dto.ProgramDto;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProgramRepositoryTest {
    @Autowired
    private ProgramRepository programRepository;
    @Test
    @DisplayName("모든 태그, 모든 타입에 해당하는 프로그램들을 조회한다.")
    void findAllPrograms() {
        List<Program> programs = programRepository.findByCondition(
                List.of(CareerTagEnum.CAREER_EXPLORE,CareerTagEnum.DOCUMENT_PREPARE,CareerTagEnum.INTERVIEW_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE,ProgramTypeEnum.LIVECLASS)
        );
        assertEquals(7, programs.size());
    }

    @Test
    @DisplayName("서류 준비 태그, 챌린지 타입에 해당하는 프로그램들을 조회한다.")
    void findDocumentPrepareTagAndChallengeTypePrograms() {
        List<Program> programs = programRepository.findByCondition(
                List.of(CareerTagEnum.DOCUMENT_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE)
        );
        assertEquals(3, programs.size());
    }

    @Test
    @DisplayName("서류 준비 태그 또는 면접 준비 태그, 그리고 챌린지 타입에 해당하는 프로그램들을 조회한다.")
    void findDocumentPrepareInterViewPrepareTagsAndChallengeTypePrograms() {
        List<Program> programs = programRepository.findByCondition(
                List.of(CareerTagEnum.DOCUMENT_PREPARE,CareerTagEnum.INTERVIEW_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE)
        );
        assertEquals(3, programs.size());
    }

    @Test
    @DisplayName("서류 준비 태그 또는 면접 준비 태그,그리고 챌린지 타입 또는 클래스 타입에 해당하는 프로그램들을 조회한다.")
    void findDocumentPrepareInterViewPrepareTagsAndChallengeClassTypePrograms() {
        List<Program> programs = programRepository.findByCondition(
                List.of(CareerTagEnum.DOCUMENT_PREPARE,CareerTagEnum.INTERVIEW_PREPARE),
                List.of(ProgramTypeEnum.CHALLENGE,ProgramTypeEnum.LIVECLASS)
        );
        assertEquals(5, programs.size());
    }
}