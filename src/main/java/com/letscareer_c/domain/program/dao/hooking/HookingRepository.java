package com.letscareer_c.domain.program.dao.hooking;

import com.letscareer_c.domain.program.domain.Hooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HookingRepository extends JpaRepository<Hooking, Long> {
    List<Hooking> findByProgramId(Long programId);
}
