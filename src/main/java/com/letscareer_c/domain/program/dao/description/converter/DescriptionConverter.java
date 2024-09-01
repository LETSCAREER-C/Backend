package com.letscareer_c.domain.program.dao.description.converter;

import com.letscareer_c.domain.program.dao.description.dto.DescriptionDto;
import com.letscareer_c.domain.program.dao.description.dto.DescriptionTypeImageDto;
import com.letscareer_c.domain.program.domain.Description;

import java.util.stream.Collectors;

public class DescriptionConverter {
    // template_type이 image인 경우에는 DescriptionImageConverter를 사용하고, 그 외에는 DescriptionConverter를 사용한다.
    public static Object toDescriptionDto(Description description) {
            if(description.getTemplateType().equals("image")) {
            // templateType이 image인 경우,  imageUrl만 보내주기
                return DescriptionTypeImageDto.builder()
                        .templateType(description.getTemplateType())
                        .imageTypeImageUrl(description.getImageTypeImageUrl())
                        .build();
            } else {
            // templateType이 image가 아닌 경우, imageUrl, title, content 모두 보내주기
                return DescriptionDto.builder()
                        .title(description.getTitle())
                        .content(description.getContent())
                        .order(description.getOrderNumber())
                        .templateType(description.getTemplateType())
                        .descriptionImages(description.getDescriptionImages().stream().map(DescriptionImageConverter::toDescriptionImageDto).collect(Collectors.toList()))
                        .build();
            }

    }
}

