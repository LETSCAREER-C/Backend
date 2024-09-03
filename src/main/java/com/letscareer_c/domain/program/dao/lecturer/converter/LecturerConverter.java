package com.letscareer_c.domain.program.dao.lecturer.converter;

import com.letscareer_c.domain.program.dao.lecturer.dto.LecturerDto;
import com.letscareer_c.domain.program.domain.Lecturer;

public class LecturerConverter {
    public static LecturerDto toLecturerDto(Lecturer lecturer) {
        return LecturerDto.builder()
                .name(lecturer.getName())
                .career(lecturer.getCareer())
                .profileImage(lecturer.getImageUrl())
                .templateType(lecturer.getTemplateType())
                .build();
    }
}
