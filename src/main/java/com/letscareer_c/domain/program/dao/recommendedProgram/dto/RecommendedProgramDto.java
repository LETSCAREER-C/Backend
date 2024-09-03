package com.letscareer_c.domain.program.dao.recommendedProgram.dto;

import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendedProgramDto {
    private Long programId;
    private CareerTagEnum tag;
    private String title;
    private String intro;
    private String thumbnail;
    private LocalDate recruitEndDate;
    private LocalDate programStartDate;
    private LocalDate programEndDate;
}