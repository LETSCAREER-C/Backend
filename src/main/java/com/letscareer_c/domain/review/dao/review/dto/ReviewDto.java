package com.letscareer_c.domain.review.dao.review.dto;

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
    private Long id;
    private String programName;
    private String userName;
    public String title;
    private String content;
    private String dreamWorkField;
    private String major;
    private int year;
    private EmploymentStatusEnum status;
    private LocalDate date;
    private int grade;
}