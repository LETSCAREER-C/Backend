package com.letscareer_c.domain.program.dao.recommendedProgram.converter;

import com.letscareer_c.domain.program.dao.ProgramRepository;
import com.letscareer_c.domain.program.dao.recommendedProgram.dto.RecommendedProgramDto;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.RecommendedProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
        long deadline = ChronoUnit.DAYS.between(LocalDateTime.now().toLocalDate(), program.get().getRecruitEndDate().toLocalDate());

        if (deadline == 0L) {
            deadline = 1L;
        }


        return RecommendedProgramDto.builder()
                .dtype(program.get().getDtype())
                .recommendedProgramId(recommendedProgram.getRecommendedProgramId())
                .title(program.get().getTitle())
                .tag(program.get().getTag())
                .recruitStatus(program.get().getRecruitStatus())
                .thumbnail(program.get().getThumbnail())
                .intro(program.get().getIntro())
                .recruitStartDate(program.get().getRecruitStartDate().toLocalDate())
                .recruitEndDate(program.get().getRecruitEndDate().toLocalDate())
                .programStartDate(program.get().getProgramStartDate().toLocalDate())
                .programEndDate(program.get().getProgramEndDate().toLocalDate())
                .deadline(deadline)
                .build();
    }
}
