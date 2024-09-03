package com.letscareer_c.domain.program.dao.recommendedProgram;

import com.letscareer_c.domain.program.domain.RecommendedProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RecommendedRepository extends JpaRepository<RecommendedProgram, Long> {
    // 추천 프로그램 가져오기
    List<RecommendedProgram> findByProgramId(Long programId);
}
