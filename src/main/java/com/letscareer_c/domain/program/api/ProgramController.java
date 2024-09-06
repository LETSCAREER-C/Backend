package com.letscareer_c.domain.program.api;

import com.letscareer_c.domain.program.application.ProgramService;
import com.letscareer_c.domain.program.application.response.ProgramDetailResponse;
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.application.response.RecommendedProgramResponse;
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

    /**
     * 프로그램 상세 조회 API
     */
    @GetMapping("/{programId}")
    public BaseResponse<ProgramDetailResponse> getChallengeProgramDetail(@PathVariable Long programId){
            ProgramDetailResponse response = programService.getProgramDetail(programId);
            return new BaseResponse<>(response);
    }

    /**
     * 프로그램 상세 페이지에서 추천강좌 태그 선택시 추천강좌 리스트 조회 API
     * 커리어태그 기본값 설정하기 .
     */
//    @GetMapping("/{programId}/recommended/{careerTag}")
//    public BaseResponse<RecommendedProgramResponse> getRecommendedProgramsByCareerTag(@PathVariable Long programId , @PathVariable String careerTag) {
//        RecommendedProgramResponse response = programService.getRecommendedProgramsByCareerTag(programId, careerTag);
//        return new BaseResponse<>(response);
//    }

}
