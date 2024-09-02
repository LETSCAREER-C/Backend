package com.letscareer_c.domain.program.api;

import com.letscareer_c.domain.program.application.ProgramService;
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController()
@RequestMapping("/program")
public class ProgramController {
    private final ProgramService programService;

    /**
     * 프로그램 리스트 조회 API
     */

    @GetMapping("/list")
    public BaseResponse<ProgramListResponse> getProgramList( @RequestParam String careerTag,
                                                                   @RequestParam List<String> programTypes,
                                                                   @RequestParam int page) {
        ProgramListResponse response = programService.getProgramList(careerTag,programTypes,page);
        return new BaseResponse<>(response);
    }
}
