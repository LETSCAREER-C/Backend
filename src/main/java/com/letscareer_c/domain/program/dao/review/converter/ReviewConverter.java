package com.letscareer_c.domain.program.dao.review.converter;

import com.letscareer_c.domain.program.dao.review.dto.ReviewDto;
import com.letscareer_c.domain.program.domain.Review;

public class ReviewConverter {
    public static ReviewDto toReviewDto(Review review) {
        return ReviewDto.builder()
                .userName(review.getMember().getName())
                .content(review.getContent())
                .grade(review.getGrade())
                .build();
    }
}
