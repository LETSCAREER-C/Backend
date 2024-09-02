package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramDetailResponse;
import com.letscareer_c.domain.program.dao.ProgramRepository;
import com.letscareer_c.domain.program.dao.curriculum.CurriculumRepository;
import com.letscareer_c.domain.program.dao.curriculum.converter.CurriculumConverter;
import com.letscareer_c.domain.program.dao.curriculum.dto.CurriculumDto;
import com.letscareer_c.domain.program.dao.description.DescriptionRepository;
import com.letscareer_c.domain.program.dao.description.converter.DescriptionConverter;
import com.letscareer_c.domain.program.dao.faq.FaqRepository;
import com.letscareer_c.domain.program.dao.faq.converter.FaqConverter;
import com.letscareer_c.domain.program.dao.faq.dto.FaqDto;
import com.letscareer_c.domain.program.dao.hooking.HookingRepository;
import com.letscareer_c.domain.program.dao.hooking.converter.HookingConverter;
import com.letscareer_c.domain.program.dao.lecturer.LecturerRepository;
import com.letscareer_c.domain.program.dao.lecturer.converter.LecturerConverter;
import com.letscareer_c.domain.program.dao.lecturer.dto.LecturerDto;
import com.letscareer_c.domain.program.dao.recommendedProgram.RecommendedRepository;
import com.letscareer_c.domain.program.dao.recommendedProgram.converter.RecommendedProgramConverter;
import com.letscareer_c.domain.program.dao.recommendedProgram.dto.RecommendedProgramDto;
import com.letscareer_c.domain.program.dao.review.ReviewRepository;
import com.letscareer_c.domain.program.dao.review.converter.ReviewConverter;
import com.letscareer_c.domain.program.dao.review.dto.ReviewDto;
import com.letscareer_c.domain.program.domain.Program;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramDetailService {
    private final ProgramRepository programRepository;
    private final ReviewRepository reviewRepository;
    private final LecturerRepository lecturerRepository;
    private final FaqRepository faqRepository;
    private final DescriptionRepository descriptionRepository;
    private final HookingRepository hookingRepository;
    private final RecommendedRepository recommendedRepository;
    private final RecommendedProgramConverter recommendedProgramConverter;
    private final CurriculumRepository curriculumRepository;

    @Transactional
    public ProgramDetailResponse getProgramDetail(Long programId) {

        Program program = programRepository.findById(programId)
                .orElseThrow(() -> new EntityNotFoundException("programId에 해당하는 프로그램이 존재하지 않습니다."));

        // 최신순 리뷰 3개
        List<ReviewDto> latestReviews = reviewRepository.findTop3ByProgramIdOrderByCreatedAtDesc(programId)
                .stream()
                .map(ReviewConverter::toReviewDto)
                .toList();

        // 평점순 리뷰 3개
        List<ReviewDto> bestReviews = reviewRepository.findTop3ByProgramIdOrderByGradeDesc(programId)
                .stream()
                .map(ReviewConverter::toReviewDto)
                .toList();

        // 연사 정보
        LecturerDto lecturerDto = LecturerConverter.toLecturerDto(lecturerRepository.findById(programId)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로그램에 연결된 연사가 존재하지 않습니다.")));

        // 커리큘럼 리스트
        List<CurriculumDto> curriculumList = curriculumRepository.findByProgramId(programId)
                .stream()
                .map(CurriculumConverter::toCurriculumDto)
                .toList();

        // FAQ 리스트
        List<FaqDto> faqList = faqRepository.findByProgramId(programId)
                .stream()
                .map(FaqConverter::toFaqDto)
                .toList();

        // 추천 강좌
        List<RecommendedProgramDto> recommendedPrograms = recommendedRepository.findByProgramId(programId)
                .stream()
                .map(recommendedProgramConverter::toRecommendedProgramDto)
                .toList();

        // 프로그램 상세 정보 (후킹)
        List<Object> hooking = hookingRepository.findByProgramId(programId)
                .stream()
                .map(HookingConverter::toHookingDto)
                .toList();

        // 프로그램 상세 정보 (디테일)
        List<Object> description = descriptionRepository.findByProgramId(programId)
                .stream()
                .map(DescriptionConverter::toDescriptionDto)
                .toList();


        return ProgramDetailResponse.builder()
                .title(program.getTitle())
                .recruitEndDate(program.getRecruitEndDate())
                .tag(program.getTag().name())
                .pcMainImageUrl(program.getPcMainImageUrl())
                .mobileMainImageUrl(program.getMobileMainImageUrl())
                .description(description)
                .hooking(hooking)
                .lecturer(lecturerDto)
                .curriculum(curriculumList)
                .latestReviews(latestReviews)
                .bestReviews(bestReviews)
                .recommendedPrograms(recommendedPrograms)
                .faq(faqList)
                .build();
    }
}
