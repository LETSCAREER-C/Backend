package com.letscareer_c.domain.program.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ProgramListResponse {
    List<ProgramDto> programDtos;
    private int totalPageCount;
}
