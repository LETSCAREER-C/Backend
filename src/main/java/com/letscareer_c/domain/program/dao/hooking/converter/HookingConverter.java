package com.letscareer_c.domain.program.dao.hooking.converter;

import com.letscareer_c.domain.program.dao.hooking.dto.HookingDto;
import com.letscareer_c.domain.program.dao.hooking.dto.HookingTypeImageDto;
import com.letscareer_c.domain.program.domain.Hooking;

import java.util.stream.Collectors;

public class HookingConverter {
    public static Object toHookingDto(Hooking hooking) {
        if(hooking.getTemplateType().equals("image")) {
            return HookingTypeImageDto.builder()
                    .templateType(hooking.getTemplateType())
                    .imageTypeImageUrl(hooking.getImageTypeImageUrl())
                    .build();
        } else { // templateType이 image가 아닌 경우, imageUrl, title, content 모두 보내주기
            return HookingDto.builder()
                    .title(hooking.getTitle())
                    .content(hooking.getContent())
                    .order(hooking.getOrderNumber())
                    .templateType(hooking.getTemplateType())
                    .hookingImageList(hooking.getHookingImages().stream().map(HookingImageConverter::toHookingImageDto).collect(Collectors.toList()))
                    .build();
        }
    }
}
