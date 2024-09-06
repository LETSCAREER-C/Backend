package com.letscareer_c.domain.program.application.response;

import com.letscareer_c.domain.program.dao.curriculum.dto.CurriculumDto;
import com.letscareer_c.domain.program.dao.faq.dto.FaqDto;
import com.letscareer_c.domain.program.dao.lecturer.dto.LecturerDto;
import com.letscareer_c.domain.program.dao.recommendedProgram.dto.RecommendedProgramDto;
import com.letscareer_c.domain.review.dao.review.dto.ReviewDto;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ProgramDetailResponse {
    private String title;
    private CareerTagEnum stepType;
    private ProgramTypeEnum programType;
    private LocalDateTime recruitEndDate;
    private String pcMainImageUrl;
    private String mobileMainImageUrl;
    // programDetail 넣어야함
    private List<Object> hooking;
    private List<Object> description;
    private LecturerDto lecturer;
    private List<CurriculumDto> curriculum;
    private List<ReviewDto> latestReviews;
    private List<ReviewDto> bestReviews;
    private List<RecommendedProgramDto> recommendedPrograms;
    private List<FaqDto> faq;
}
