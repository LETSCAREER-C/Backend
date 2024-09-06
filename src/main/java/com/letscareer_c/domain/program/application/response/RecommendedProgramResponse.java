package com.letscareer_c.domain.program.application.response;

import com.letscareer_c.domain.program.dao.recommendedProgram.dto.RecommendedProgramDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class RecommendedProgramResponse {
    private List<RecommendedProgramDto> recommendedPrograms;
}
