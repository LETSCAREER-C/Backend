package com.letscareer_c.domain.program.dao.description.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DescriptionDto {
    private String title;
    private String content;
    private int order;
    private List<HashtagDto> hashtags;
    private String templateType;
    private List<DescriptionImageDto> descriptionImages;
}