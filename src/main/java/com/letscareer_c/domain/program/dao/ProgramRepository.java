package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long>, ProgramRepositoryCustom {
}
