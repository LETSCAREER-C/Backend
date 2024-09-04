package com.letscareer_c.domain.program.dao.review.dto;

import com.letscareer_c.domain.program.domain.tag.EmploymentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private String userName;
    private String content;
    private EmploymentStatusEnum status;
    private LocalDate date;
    private int grade;
}