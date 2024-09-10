package com.letscareer_c.domain.program.dao.recommendedProgram.dto;

import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
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
    private ProgramTypeEnum dtype;
    private Long recommendedProgramId;
    private String title;
    private String intro;
    private String thumbnail;
    private RecruitStatus recruitStatus;
    private CareerTagEnum tag;
    private LocalDate recruitStartDate;
    private LocalDate recruitEndDate;
    private LocalDate programStartDate;
    private LocalDate programEndDate;
    private long deadline;
}