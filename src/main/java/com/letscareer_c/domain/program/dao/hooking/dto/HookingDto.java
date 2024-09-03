package com.letscareer_c.domain.program.dao.hooking.dto;

import com.letscareer_c.domain.program.domain.Hooking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HookingDto {
    private String title;
    private String content;
    private int order;
    private String templateType;
    // 다중 이미지
    private List<HookingImageDto> hookingImageList;
}
