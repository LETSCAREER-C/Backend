package com.letscareer_c.domain.program.application.response;

import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ProgramListResponse {
    private ProgramTypeEnum dtype;
    private Long programId;
    private String title;
    private String intro;
    private RecruitStatus recruitStatus;
    private List<CareerTagEnum> tags;
    private LocalDateTime recruitStartDate;
    private LocalDateTime recruitEndDate;
    private LocalDateTime programStartDate;
    private LocalDateTime programEndDate;
    private int price;
    //private LocalDateTime otDate;
}
