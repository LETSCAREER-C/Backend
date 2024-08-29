package com.letscareer_c.domain.program.dao.dto;

import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {
    private Long programId;
    private ProgramTypeEnum dtype;
    private String title;
    private String intro;
    private String thumbnail;
    private RecruitStatus recruitStatus;
    private List<CareerTagEnum> tags;
    private LocalDateTime recruitStartDate;
    private LocalDateTime recruitEndDate;
    private LocalDateTime programStartDate;
    private LocalDateTime programEndDate;
    private boolean isOnline;
}
