package com.letscareer_c.domain.program.dao.recommendedProgram.converter;

import com.letscareer_c.domain.program.dao.ProgramRepository;
import com.letscareer_c.domain.program.dao.recommendedProgram.dto.RecommendedProgramDto;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.RecommendedProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class RecommendedProgramConverter {

    private static ProgramRepository programRepository;

    @Autowired
    public RecommendedProgramConverter(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public RecommendedProgramDto toRecommendedProgramDto(RecommendedProgram recommendedProgram) {
        Optional<Program> program = programRepository.findById(recommendedProgram.getRecommendedProgramId());
        if (program.isEmpty()) {
            throw new IllegalArgumentException("해당 프로그램이 존재하지 않습니다.");
        }
        return RecommendedProgramDto.builder()
                .programId(recommendedProgram.getId())
                .title(program.get().getTitle())
                .tag(program.get().getTag())
                .thumbnail(program.get().getThumbnail())
                .intro(program.get().getIntro())
                .recruitEndDate(program.get().getRecruitEndDate().toLocalDate())
                .programStartDate(program.get().getProgramStartDate().toLocalDate())
                .programEndDate(program.get().getProgramEndDate().toLocalDate())
                .build();
    }
}
