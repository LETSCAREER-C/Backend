package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProgramRepositoryCustom {
    Page<Program> findByCondition(CareerTagEnum careerTagEnums, List<ProgramTypeEnum> programTypeEnums, Pageable pageable);
}
