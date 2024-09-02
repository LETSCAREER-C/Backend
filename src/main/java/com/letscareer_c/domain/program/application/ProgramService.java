package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramDto;
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.dao.ProgramRepository;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.exception.ProgramException;
import com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

    public ProgramListResponse getProgramList(String careerTag, List<String> programTypes, int page) {
        PageRequest pageRequest = PageRequest.of(page,8);
        List<ProgramTypeEnum> programTypeEnums = returnProgramTypeEnums(programTypes);
        Page<Program> programs;
        if(careerTag.equals("ALL")){
            programs = programRepository.findByCondition(null,programTypeEnums,pageRequest);
        }else{
            CareerTagEnum careerTagEnum = returnCareerTagEnum(careerTag);
            programs = programRepository.findByCondition(careerTagEnum, programTypeEnums,pageRequest);
        }

        //response 생성 후 반환
        return makeResponseWithPageResult(programs);
    }

    public List<ProgramTypeEnum> returnProgramTypeEnums(List<String> programTypes) {
        //ProgramTypeEnum으로 변환(변환 불가 시 필터링)
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

    public CareerTagEnum returnCareerTagEnum(String careerTag) {
        //CareerTagEnum으로 변환(변환 불가 시 필터링)
        try {
            return CareerTagEnum.valueOf(careerTag.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ProgramException(ProgramExceptionErrorCode.INVALID_REQUEST_CAREER_TAG);
        }
    }

    private ProgramListResponse makeResponseWithPageResult(Page<Program> programs) {
        List<Program> content = programs.getContent();
        int totalPages = programs.getTotalPages();

        List<ProgramDto> programDtos = content.stream()
                .map(p -> {
                    //챌린지 타입인 경우에는 OT 일시 설정
//                    LocalDate otDate = null;
//                    if (p.getDtype().equals(ProgramTypeEnum.CHALLENGE)) {
//                        otDate = p.getOtDate(); // Assuming getOtDate() is a method in Challenge class
//                    }

                    return new ProgramDto(
                            p.getDtype(),
                            p.getId(),
                            p.getTitle(),
                            p.getIntro(),
                            p.getThumbnail(),
                            p.getRecruitStatus(),
                            p.getTag(),
                            p.getRecruitStartDate(),
                            p.getRecruitEndDate(),
                            p.getProgramStartDate(),
                            p.getProgramEndDate(),
                            ChronoUnit.DAYS.between(LocalDateTime.now().toLocalDate(), p.getRecruitEndDate().toLocalDate())
                    );
                })
                .collect(Collectors.toList());
        return new ProgramListResponse(programDtos,totalPages);
    }
}
