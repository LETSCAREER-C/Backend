package com.letscareer_c.domain.program.dao.description;

import com.letscareer_c.domain.program.domain.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DescriptionRepository extends JpaRepository<Description, Long> {
    List<Description> findByProgramId(Long programId);
}
