package com.letscareer_c.domain.review.dao.review;

import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.review.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    // 프로그램 태그에 해당하는 모든 리뷰 가져오기
    List<Review> findByProgram_Tag(CareerTagEnum tag);
}
