package com.letscareer_c.domain.program.api.request;

import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import lombok.Data;

import java.util.List;

@Data
public class ProgramListRequest {
    List<CareerTagEnum> careerTags;
    List<ProgramTypeEnum> programTypes;

    public ProgramListRequest(List<CareerTagEnum> careerTags, List<ProgramTypeEnum> programTypes) {
        this.careerTags = careerTags;
        this.programTypes = programTypes;
    }
}
