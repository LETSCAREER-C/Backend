package com.letscareer_c.domain.program.dao.curriculum;

import com.letscareer_c.domain.program.domain.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
    List<Curriculum> findByProgramId(Long programId);
}
