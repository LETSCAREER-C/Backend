package com.letscareer_c.domain.review.api;

import com.letscareer_c.domain.review.application.ReviewService;
import com.letscareer_c.domain.review.application.response.ReviewListResponse;
import com.letscareer_c.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * 커리어 단계에 관한 리뷰 리스트 조회 API
     */
    @GetMapping("/{careerTag}")
    public BaseResponse<ReviewListResponse> getReviewList(@PathVariable String careerTag) {
        ReviewListResponse response = reviewService.getReviewListByCareerTag(careerTag);
        return new BaseResponse<>(response);
    }
}
