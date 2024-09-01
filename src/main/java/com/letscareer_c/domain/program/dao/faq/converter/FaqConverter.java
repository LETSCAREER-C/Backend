package com.letscareer_c.domain.program.dao.faq.converter;

import com.letscareer_c.domain.program.dao.faq.dto.FaqDto;
import com.letscareer_c.domain.program.domain.Faq;

public class FaqConverter {
    public static FaqDto toFaqDto(Faq faq) {
        return FaqDto.builder()
                .order(faq.getOrderNumber())
                .question(faq.getQuestion())
                .answer(faq.getAnswer())
                .build();
    }
}
