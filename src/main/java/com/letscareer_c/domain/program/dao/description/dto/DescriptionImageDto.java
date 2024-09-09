package com.letscareer_c.domain.program.dao.description.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DescriptionImageDto {
    private String imageUrl;
    private String pcImageUrl;
    private int order;
}
