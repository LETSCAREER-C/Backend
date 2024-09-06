package com.letscareer_c.domain.program.dao.recommendedProgram;

import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.RecommendedProgram;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;

import java.util.List;

public interface RecommendedProgramRepositoryCustom {
    List<RecommendedProgram> findByProgramIdAndCareerTag(Long programId, CareerTagEnum careerTag);
}
