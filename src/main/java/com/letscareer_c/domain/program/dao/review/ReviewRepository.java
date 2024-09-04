package com.letscareer_c.domain.program.dao.review;

import com.letscareer_c.domain.program.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 특정 프로그램의 모든 리뷰 가져오기
    List<Review> findByProgramId(Long programId);

    // 특정 프로그램에 해당하는 리뷰 중 최신순 3개 가쟈오기
    List<Review> findTop3ByProgramIdOrderByCreatedAtDesc(Long programId);

    // 특정 프로그램에 해당하는 리뷰 중 grade 순 3개 가져오기
    List<Review> findTop3ByProgramIdOrderByGradeDesc(Long programId);
}