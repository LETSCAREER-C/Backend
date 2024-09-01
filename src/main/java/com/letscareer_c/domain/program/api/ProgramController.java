package com.letscareer_c.domain.program.api;

import com.letscareer_c.domain.program.application.ProgramDetailService;
import com.letscareer_c.domain.program.application.ProgramService;
import com.letscareer_c.domain.program.application.response.ProgramDetailResponse;
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
    private final ProgramDetailService programDetailService;

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
<<<<<<< HEAD
=======

    public List<ProgramTypeEnum> returnProgramTypeEnums(List<String> programTypes) {
        if (programTypes == null || programTypes.isEmpty()) {
            throw new ProgramException(ProgramExceptionErrorCode.INVALID_REQUEST_PROGRAM_TYPE);
        }

        List<ProgramTypeEnum> programTypeEnums = programTypes.stream()
                .map(tag -> {
                    try {
                        return ProgramTypeEnum.valueOf(tag.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new ProgramException(ProgramExceptionErrorCode.INVALID_REQUEST_PROGRAM_TYPE);
                    }
                })
                .collect(Collectors.toList());

        return programTypeEnums;
    }

    public List<CareerTagEnum> returnCareerTagEnums(List<String> careerTags) {
        if (careerTags == null || careerTags.isEmpty()) {
            throw new ProgramException(ProgramExceptionErrorCode.INVALID_REQUEST_CAREER_TAG);
        }

        List<CareerTagEnum> careerTagEnums = careerTags.stream()
                .map(tag -> {
                    try {
                        return CareerTagEnum.valueOf(tag.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new ProgramException(ProgramExceptionErrorCode.INVALID_REQUEST_CAREER_TAG);
                    }
                })
                .collect(Collectors.toList());

        return careerTagEnums;
    }

    /**
     * 프로그램 상세 조회 API
     */

    @GetMapping("/{programId}")
    public BaseResponse<ProgramDetailResponse> getChallengeProgramDetail(@PathVariable Long programId){
        try {
            ProgramDetailResponse response = programDetailService.getProgramDetail(programId);
            return new BaseResponse<>(response);
        } catch (Exception e) {
            log.error("프로그램 상세 조회 중 오류 발생", e);
            throw new ProgramException(ProgramExceptionErrorCode.NOT_FOUND_PROGRAM);
        }

    }
>>>>>>> c64573d (feat: get program detail information by program id)
}
