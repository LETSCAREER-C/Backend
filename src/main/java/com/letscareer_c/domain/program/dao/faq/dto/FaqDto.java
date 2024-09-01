package com.letscareer_c.domain.program.dao.faq.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FaqDto {
    private int order;
    private String question;
    private String answer;
}