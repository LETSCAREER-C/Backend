package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProgramRepositoryTest {
    @Autowired
    private ProgramRepository programRepository;
    @Test
    @DisplayName("모든 태그, 모든 타입에 해당하는 0페이지 프로그램들을 조회한다.")
    void findAllPrograms() {
        //given
        CareerTagEnum careerTagEnum = null;
        List<ProgramTypeEnum> programTypes = List.of(ProgramTypeEnum.CHALLENGE, ProgramTypeEnum.LIVECLASS);
        PageRequest pageRequest = PageRequest.of(0,8);
        //when
        Page<Program> programs = programRepository.findByCondition(careerTagEnum, programTypes,pageRequest);
        //then
        assertEquals(8, programs.getContent().size());
    }

    @Test
    @DisplayName("서류 준비 태그, 챌린지 타입에 해당하는 0페이지 프로그램들을 조회한다.")
    void findDocumentPrepareTagAndChallengeTypePrograms() {
        //given
        CareerTagEnum careerTagEnum = CareerTagEnum.DOCUMENT_PREPARE;
        List<ProgramTypeEnum> programTypes = List.of(ProgramTypeEnum.CHALLENGE);
        PageRequest pageRequest = PageRequest.of(0,8);
        //when
        Page<Program> programs = programRepository.findByCondition(careerTagEnum, programTypes,pageRequest);
        //then
        assertEquals(3, programs.getContent().size());
    }

    @Test
    @DisplayName("전체보기 커리어 태그, 그리고 챌린지 타입에 해당하는 0페이지 프로그램들을 조회한다.")
    void findDocumentPrepareInterViewPrepareTagsAndChallengeTypePrograms() {
        //given
        CareerTagEnum careerTagEnum = null;
        List<ProgramTypeEnum> programTypes = List.of(ProgramTypeEnum.CHALLENGE);
        PageRequest pageRequest = PageRequest.of(0,8);
        //when
        Page<Program> programs = programRepository.findByCondition(careerTagEnum, programTypes,pageRequest);
        //then
        assertEquals(8, programs.getContent().size());
    }

    @Test
    @DisplayName("서류 준비 태그, 그리고 모든 타입에 해당하는 0페이지 프로그램들을 조회한다.")
    void findDocumentPrepareInterViewPrepareTagsAndChallengeClassTypePrograms() {
        //given
        CareerTagEnum careerTagEnum = CareerTagEnum.DOCUMENT_PREPARE;
        List<ProgramTypeEnum> programTypes = List.of(ProgramTypeEnum.CHALLENGE, ProgramTypeEnum.LIVECLASS);
        PageRequest pageRequest = PageRequest.of(0,8);
        //when
        Page<Program> programs = programRepository.findByCondition(careerTagEnum, programTypes,pageRequest);
        //then
        assertEquals(5, programs.getContent().size());
    }
}