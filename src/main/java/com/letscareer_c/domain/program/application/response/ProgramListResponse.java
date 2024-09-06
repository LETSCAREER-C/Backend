package com.letscareer_c.domain.program.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramListResponse {
    List<ProgramDto> programDtos;
    private int totalPageCount;
}
