package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.api.request.ProgramListRequest;
import com.letscareer_c.domain.program.domain.Program;

import java.util.List;

public interface ProgramRepositoryCustom {
    List<Program> findByCondition(ProgramListRequest request);
}
