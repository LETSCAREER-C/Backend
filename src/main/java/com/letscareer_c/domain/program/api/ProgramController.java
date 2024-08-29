package com.letscareer_c.domain.program.api;

import com.letscareer_c.domain.program.application.ProgramService;
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.exception.ProgramException;
import com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode;
import com.letscareer_c.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public BaseResponse<List<ProgramListResponse>> getProgramList( @RequestParam List<String> careerTags,
                                                                   @RequestParam List<String> programTypes) {
        List<CareerTagEnum> careerTagEnums = returnCareerTagEnums(careerTags);
        List<ProgramTypeEnum> programTypeEnums = returnProgramTypeEnums(programTypes);
        List<ProgramListResponse> response = programService.getProgramList(careerTagEnums,programTypeEnums);

        return new BaseResponse<>(response);
    }

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
}
