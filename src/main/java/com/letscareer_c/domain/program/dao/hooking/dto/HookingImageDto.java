package com.letscareer_c.domain.program.dao.hooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HookingImageDto {
    private String imageUrl;
    private int order;
}
