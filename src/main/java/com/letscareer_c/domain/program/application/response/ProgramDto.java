package com.letscareer_c.domain.program.application.response;

import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {
    private ProgramTypeEnum dtype;
    private Long programId;
    private String title;
    private String intro;
    private String thumbnail;
    private RecruitStatus recruitStatus;
    private CareerTagEnum tag;
    private LocalDateTime recruitStartDate;
    private LocalDateTime recruitEndDate;
    private LocalDateTime programStartDate;
    private LocalDateTime programEndDate;
    private long deadline;
    //private LocalDateTime otDate;
}
