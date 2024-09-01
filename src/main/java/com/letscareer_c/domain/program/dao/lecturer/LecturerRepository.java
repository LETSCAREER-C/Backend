package com.letscareer_c.domain.program.dao.lecturer;

import com.letscareer_c.domain.program.domain.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    Lecturer findByProgramId(Long programId);
}
