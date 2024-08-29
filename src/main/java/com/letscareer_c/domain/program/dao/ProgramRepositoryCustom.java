package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.dao.dto.ProgramDto;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;

import java.util.List;

public interface ProgramRepositoryCustom {
    List<Program> findByCondition(List<CareerTagEnum> careerTagEnums, List<ProgramTypeEnum> programTypeEnums);
}
