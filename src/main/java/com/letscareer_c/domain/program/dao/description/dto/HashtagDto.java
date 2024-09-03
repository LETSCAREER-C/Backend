package com.letscareer_c.domain.program.dao.description.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HashtagDto {
    private String hashtag;
    private int order;
}
