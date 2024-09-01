package com.letscareer_c.domain.program.dao.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private String userName;
    private String content;
    private int grade;
}