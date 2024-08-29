package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.dao.ProgramRepository;
import com.letscareer_c.domain.program.dao.dto.ProgramDto;
import com.letscareer_c.domain.program.domain.Challenge;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

    public List<ProgramListResponse> getProgramList(List<CareerTagEnum> careerTagEnums, List<ProgramTypeEnum> programTypeEnums) {
        List<Program> programs = programRepository.findByCondition(careerTagEnums, programTypeEnums);

        //response 생성 후 반환
        return programs.stream()
                .map(p -> {
                    //챌린지 타입인 경우에는 OT 일시 설정
//                    LocalDate otDate = null;
//                    if (p.getDtype().equals(ProgramTypeEnum.CHALLENGE)) {
//                        otDate = p.getOtDate(); // Assuming getOtDate() is a method in Challenge class
//                    }

                    return new ProgramListResponse(
                            p.getDtype(),
                            p.getId(),
                            p.getTitle(),
                            p.getIntro(),
                            p.getRecruitStatus(),
                            p.getTags(),
                            p.getRecruitStartDate(),
                            p.getRecruitEndDate(),
                            p.getProgramStartDate(),
                            p.getProgramEndDate(),
                            p.getPrice()
                    );
                })
                .collect(Collectors.toList());
    }
}
