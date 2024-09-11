package com.letscareer_c.domain.program.application;

import com.letscareer_c.domain.program.application.response.ProgramDetailResponse;
import com.letscareer_c.domain.program.application.response.ProgramDto;
import com.letscareer_c.domain.program.application.response.ProgramListResponse;
import com.letscareer_c.domain.program.application.response.RecommendedProgramResponse;
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
import com.letscareer_c.domain.program.dao.recommendedProgram.RecommendedProgramRepository;
import com.letscareer_c.domain.program.dao.recommendedProgram.converter.RecommendedProgramConverter;
import com.letscareer_c.domain.program.dao.recommendedProgram.dto.RecommendedProgramDto;
import com.letscareer_c.domain.program.domain.RecommendedProgram;
import com.letscareer_c.domain.review.application.response.ReviewListResponse;
import com.letscareer_c.domain.review.dao.review.ReviewRepository;
import com.letscareer_c.domain.review.dao.review.converter.ReviewConverter;
import com.letscareer_c.domain.review.dao.review.dto.ReviewDto;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.exception.ProgramException;
import com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;
    private final ReviewRepository reviewRepository;
    private final LecturerRepository lecturerRepository;
    private final FaqRepository faqRepository;
    private final DescriptionRepository descriptionRepository;
    private final HookingRepository hookingRepository;
    private final RecommendedProgramRepository recommendedRepository;
    private final RecommendedProgramConverter recommendedProgramConverter;
    private final CurriculumRepository curriculumRepository;

    @Cacheable(cacheNames = "getProgramList", key = "'programList:careerTag:' + #careerTag + ':programTypes:' + #programTypes + ':page:' + #page")
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

    public static CareerTagEnum returnCareerTagEnum(String careerTag) {
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
                    long deadline = ChronoUnit.DAYS.between(LocalDateTime.now().toLocalDate(), p.getRecruitEndDate().toLocalDate());

                    if (deadline == 0L) {
                        deadline = 1L;
                    }

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
                            deadline
                    );
                })
                .collect(Collectors.toList());
        return new ProgramListResponse(programDtos,totalPages);
    }

    @Transactional
    public ProgramDetailResponse getProgramDetail(Long programId) {

        try {
            Program program = programRepository.findById(programId)
                    .orElseThrow(() -> new EntityNotFoundException("programId에 해당하는 프로그램이 존재하지 않습니다."));

            // detail 정보 가져오는거 따로 빼기 (메서드)

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

            // 리뷰 총 개수와 평균
            Optional<Double> optionalGradeAverage = reviewRepository.findAverageGradeByProgramId(programId);

            double gradeAverage = optionalGradeAverage.orElse(0.0);
            gradeAverage = Math.round(gradeAverage * 100.0) / 100.0;
            gradeAverage = Math.round(gradeAverage * 100.0) / 100.0;
            long reviewCount = reviewRepository.countByProgramId(programId);

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
            List<RecommendedProgramDto> recommendedPrograms = getRecommendedProgramsDtosByCareerTag(programId, program.getTag().name());

            // 프로그램 상세 정보 (후킹)
            List<Object> hooking = hookingRepository.findByProgramId(programId)
                    .stream()
                    .map(HookingConverter::toHookingDto) // 오타
                    .toList();

            // 프로그램 상세 정보 (디테일)
            List<Object> description = descriptionRepository.findByProgramId(programId)
                    .stream()
                    .map(DescriptionConverter::toDescriptionDto)
                    .toList();
            //합격률
            Long passedRate = (long) (((double) program.getPassedNum() / (program.getPassedNum() + program.getFailedNum())) * 100);

            // 컨버터로 바꾸기!
            // 굳이..
            // 생성자로 써도 될듯
            // 잘 모름
            return ProgramDetailResponse.builder()
                    .title(program.getTitle())
                    .recruitEndDate(program.getRecruitEndDate())
                    .stepType(program.getTag())
                    .programType(program.getDtype())
                    .pcMainImageUrl(program.getPcMainImageUrl())
                    .mobileMainImageUrl(program.getMobileMainImageUrl())
                    .description(description)
                    .hooking(hooking)
                    .lecturer(lecturerDto)
                    .curriculum(curriculumList)
                    .latestReviews(latestReviews)
                    .passedRate(passedRate)
                    .gradeCount((int)reviewCount)
                    .gradeAverage(gradeAverage)
                    .bestReviews(bestReviews)
                    .recommendedPrograms(recommendedPrograms)
                    .faq(faqList)
                    .build();
        } catch (Exception e) {
            log.error("프로그램 상세 조회 중 오류 발생", e);
            // 에러를 좀 더 광범위하게 해야함
            // 디테일 업슴 이런 느낌~
            throw new ProgramException(ProgramExceptionErrorCode.PROGRAM_NOT_FOUND);
        }
    }

    private List<RecommendedProgramDto> getRecommendedProgramsDtosByCareerTag(Long programId, String careerTag) {
        return recommendedRepository.findByProgramId(programId)
                .stream()
                .map(recommendedProgramConverter::toRecommendedProgramDto)
                .filter(recommendedProgramDto -> recommendedProgramDto.getTag() == CareerTagEnum.valueOf(careerTag.toUpperCase()))
                .toList();
    }

    public RecommendedProgramResponse getRecommendedProgramsByCareerTag(Long programId, String careerTag) {
        List<RecommendedProgramDto> recommendedPrograms = getRecommendedProgramsDtosByCareerTag(programId, careerTag);
        return new RecommendedProgramResponse(recommendedPrograms);
    }

    public ReviewListResponse getReviewList(Long programId) {
        List<ReviewDto> reviewDtos = reviewRepository.findByProgramId(programId)
                .stream()
                .map(ReviewConverter::toReviewDto)
                .toList();
        return new ReviewListResponse(reviewDtos);
    }

}
