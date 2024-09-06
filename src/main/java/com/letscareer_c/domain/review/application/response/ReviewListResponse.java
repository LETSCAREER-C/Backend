package com.letscareer_c.domain.review.application.response;

import com.letscareer_c.domain.review.dao.review.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListResponse {
    List<ReviewDto> reviews;
}
