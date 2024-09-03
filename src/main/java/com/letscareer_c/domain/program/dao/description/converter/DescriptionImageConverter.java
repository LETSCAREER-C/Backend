package com.letscareer_c.domain.program.dao.description.converter;

import com.letscareer_c.domain.program.dao.description.dto.DescriptionImageDto;
import com.letscareer_c.domain.program.domain.DescriptionImage;

public class DescriptionImageConverter {
    public static DescriptionImageDto toDescriptionImageDto(DescriptionImage descriptionImage) {
        return DescriptionImageDto.builder()
                .imageUrl(descriptionImage.getImageUrl())
                .order(descriptionImage.getOrderNumber())
                .build();
    }
}
