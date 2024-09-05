package com.letscareer_c.domain.program.application.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramListResponse {
    List<ProgramDto> programDtos;
    private int totalPageCount;
}
