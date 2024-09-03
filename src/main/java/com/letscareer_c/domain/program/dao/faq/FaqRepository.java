package com.letscareer_c.domain.program.dao.faq;

import com.letscareer_c.domain.program.domain.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {
    List<Faq> findByProgramId(Long programId);
}
