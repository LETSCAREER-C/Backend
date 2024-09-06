package com.letscareer_c.domain.review.dao.review.converter;

import com.letscareer_c.domain.review.dao.review.dto.ReviewDto;
import com.letscareer_c.domain.review.domain.Review;

public class ReviewConverter {
    public static ReviewDto toReviewDto(Review review) {
        return ReviewDto.builder()
                .userName(review.getMember().getName())
                .title(review.getTitle())
                .content(review.getContent())
                .major(review.getMember().getMajor())
                .dreamWorkField(review.getMember().getDreamWorkField())
                .year(review.getMember().getAcademicYear())
                .grade(review.getGrade())
                .status(review.getStatus())
                .date(review.getCreatedAt().toLocalDate())
                .build();
    }
}
