package com.letscareer_c.domain.review.dao.review;

import com.letscareer_c.domain.review.domain.Review;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    // 특정 프로그램의 모든 리뷰 가져오기
    List<Review> findByProgramId(Long programId);

    // 특정 프로그램에 해당하는 리뷰 중 최신순 3개 가쟈오기
    List<Review> findTop3ByProgramIdOrderByCreatedAtDesc(Long programId);

    // 특정 프로그램에 해당하는 리뷰 중 grade 순 3개 가져오기
    List<Review> findTop3ByProgramIdOrderByGradeDesc(Long programId);


    @Query("SELECT AVG(r.grade) FROM Review r WHERE r.program.id = :programId")
    Optional<Double> findAverageGradeByProgramId(Long programId);


    long countByProgramId(Long programId);
}
