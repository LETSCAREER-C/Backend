package com.letscareer_c.domain.review.application;

import com.letscareer_c.domain.review.application.response.ReviewListResponse;
import com.letscareer_c.domain.review.dao.review.ReviewRepository;
import com.letscareer_c.domain.review.dao.review.converter.ReviewConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.letscareer_c.domain.program.application.ProgramService.returnCareerTagEnum;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewListResponse getReviewListByCareerTag(String careerTag) {
        return new ReviewListResponse(reviewRepository.findByProgram_Tag(
                returnCareerTagEnum(careerTag)
                ).stream()
                .map(ReviewConverter::toReviewDto)
                .toList());
    }
}
