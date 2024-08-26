package com.letscareer_c.domain.program.application.response;

import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ProgramListResponse {
    private String dtype;
    private String title;
    private String intro;
    private RecruitStatus recruitStatus;
    private List<CareerTagEnum> tags;
    private LocalDate recruitStartDate;
    private LocalDate recruitEndDate;
    private LocalDate programStartDate;
    private LocalDate programEndDate;
    private LocalDate otDate;
}
