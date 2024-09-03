package com.letscareer_c.domain.program.dao.lecturer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturerDto {
    private String name;
    private String career;
    private String profileImage;
    private String templateType;
}
