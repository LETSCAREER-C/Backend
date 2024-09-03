package com.letscareer_c.domain.program.dao.curriculum.converter;

import com.letscareer_c.domain.program.dao.curriculum.dto.CurriculumDto;
import com.letscareer_c.domain.program.domain.Curriculum;

public class CurriculumConverter {
    public static CurriculumDto toCurriculumDto(Curriculum curriculum) {
        return CurriculumDto.builder()
                .title(curriculum.getTitle())
                .content(curriculum.getContent())
                .order(curriculum.getOrderNumber())
                .build();
    }
}
