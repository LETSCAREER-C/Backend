package com.letscareer_c.domain.program.dao.hooking.converter;


import com.letscareer_c.domain.program.dao.hooking.dto.HookingImageDto;
import com.letscareer_c.domain.program.dao.hooking.dto.HookingTypeImageDto;
import com.letscareer_c.domain.program.domain.HookingImage;

public class HookingImageConverter {
    public static HookingImageDto toHookingImageDto(HookingImage hookingImage) {
        return HookingImageDto.builder()
                .imageUrl(hookingImage.getImageUrl())
                .pcImageUrl(hookingImage.getPcImageUrl())
                .order(hookingImage.getOrderNumber())
                .build();
    }
}
