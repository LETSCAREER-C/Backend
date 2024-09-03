package com.letscareer_c.domain.program.dao.curriculum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurriculumDto {
    private String order;
    private String title;
    private String content;
}
