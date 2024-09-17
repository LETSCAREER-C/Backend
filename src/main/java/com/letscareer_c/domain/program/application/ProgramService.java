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
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.exception.ProgramException;
import com.letscareer_c.domain.program.exception.errorcode.ProgramExceptionErrorCode;
import com.letscareer_c.domain.review.application.response.ReviewListResponse;
import com.letscareer_c.domain.review.dao.review.ReviewRepository;
import com.letscareer_c.domain.review.dao.review.converter.ReviewConverter;
import com.letscareer_c.domain.review.dao.review.dto.ReviewDto;
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
            Program program = getProgramByProgramId(programId);

            List<ReviewDto> latestReviews = getLatestReviews(programId);
            List<ReviewDto> bestReviews = getBestReviews(programId);

            double gradeAverage = getGradeAverage(programId);
            long reviewCount = getReviewCount(programId);

            LecturerDto lecturerDto = getLecturerDto(program, programId);
            List<CurriculumDto> curriculumList = getCurriculumList(programId);
            List<FaqDto> faqList = getFaqList(programId);

            List<RecommendedProgramDto> recommendedPrograms = getRecommendedProgramsDtosByCareerTag(programId, program.getTag().name());

            List<Object> hooking = getHookingDetails(programId);
            List<Object> description = getDescriptionDetails(programId);

            Long passedRate = calculatePassedRate(program);

            return craeteProgramDetailResponse(program,
                    hooking,
                    description,
                    lecturerDto,
                    curriculumList,
                    latestReviews,
                    bestReviews,
                    recommendedPrograms,
                    faqList,
                    passedRate,
                    gradeAverage,
                    (int) reviewCount);
        } catch (ProgramException e) {
            log.error("프로그램 상세 조회 중 오류 발생: {}", e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("서버 에러 발생", e);
            throw new ProgramException(ProgramExceptionErrorCode.SERVER_ERROR);
        }
    }

    private ProgramDetailResponse craeteProgramDetailResponse(Program program,
                                                              List<Object> hooking,
                                                              List<Object> description,
                                                              LecturerDto lecturerDto,
                                                              List<CurriculumDto> curriculumList,
                                                              List<ReviewDto> latestReviews,
                                                              List<ReviewDto> bestReviews,
                                                              List<RecommendedProgramDto> recommendedPrograms,
                                                              List<FaqDto> faqList,
                                                              Long passedRate,
                                                              double gradeAverage,
                                                              int reviewCount) {
        return new ProgramDetailResponse(
                program.getTitle(),
                program.getTag(),
                program.getDtype(),
                program.getRecruitEndDate(),
                program.getPcMainImageUrl(),
                program.getMobileMainImageUrl(),
                hooking,
                description,
                lecturerDto,
                curriculumList,
                latestReviews,
                bestReviews,
                recommendedPrograms,
                faqList,
                passedRate,
                gradeAverage,
                reviewCount
        );
    }

    private Program getProgramByProgramId(Long programId) {
        try {
            return programRepository.findById(programId)
                    .orElseThrow(() -> new ProgramException(ProgramExceptionErrorCode.PROGRAM_NOT_FOUND));
        } catch (ProgramException e) {
            log.error("프로그램 정보 조회 중 오류 발생: {}", e.getMessage(), e);
            throw e;
        }
    }

    private List<ReviewDto> getLatestReviews(Long programId) {
        return reviewRepository.findTop3ByProgramIdOrderByCreatedAtDesc(programId)
                .stream()
                .map(ReviewConverter::toReviewDto)
                .toList();
    }

    private List<ReviewDto> getBestReviews(Long programId) {
        return reviewRepository.findTop3ByProgramIdOrderByGradeDesc(programId)
                .stream()
                .map(ReviewConverter::toReviewDto)
                .toList();
    }

    private double getGradeAverage(Long programId) {
        Optional<Double> optionalGradeAverage = reviewRepository.findAverageGradeByProgramId(programId);
        double gradeAverage = optionalGradeAverage.orElse(0.0);
        return Math.round(gradeAverage * 100.0) / 100.0;
    }

    private long getReviewCount(Long programId) {
        return reviewRepository.countByProgramId(programId);
    }

    private LecturerDto getLecturerDto(Program program, Long programId) {
        // 프로그램 타입이 챌린지인 경우 Lecture가 없음.
        if(program.getDtype().toString().equals("CHALLENGE")) {
            return null;
        } else {
            try {
                return LecturerConverter.toLecturerDto(
                        lecturerRepository.findById(programId)
                                .orElseThrow(() -> new ProgramException(ProgramExceptionErrorCode.LECTURER_NOT_FOUND))
                );
            } catch (ProgramException e) {
                log.error("programId = {} 에 해당하는 프로그램의 강사 정보 조회 중 오류 발생: {}", programId, e.getMessage(), e);
                throw e;
            }
        }
    }

    private List<CurriculumDto> getCurriculumList(Long programId) {

        List<CurriculumDto> curriculumDtoList = curriculumRepository.findByProgramId(programId)
                .stream()
                .map(CurriculumConverter::toCurriculumDto)
                .toList();
        if(curriculumDtoList.isEmpty()) {
            log.error("programId = {} 에 해당하는 프로그램의 커리큘럼을 가져오는데 문제가 발생했습니다.", programId);
            throw new ProgramException(ProgramExceptionErrorCode.CURRICULUM_NOT_FOUND);
        } else {
            return curriculumDtoList;
        }
    }

    private List<FaqDto> getFaqList(Long programId) {
        List<FaqDto> faqDtos = faqRepository.findByProgramId(programId)
                    .stream()
                    .map(FaqConverter::toFaqDto)
                    .toList();

        if(faqDtos.isEmpty()) {
            log.error("programId = {} 에 해당하는 프로그램의 FAQ를 가져오는데 문제가 발생했습니다.", programId);
            throw new ProgramException(ProgramExceptionErrorCode.FAQ_NOT_FOUND);
        } else {
            return faqDtos;
        }
    }

    private List<Object> getHookingDetails(Long programId) {
        return hookingRepository.findByProgramId(programId)
                .stream()
                .map(HookingConverter::toHookingDto)
                .toList();
    }

    private List<Object> getDescriptionDetails(Long programId) {
        List<Object> programDescriptionDetails =  descriptionRepository.findByProgramId(programId)
                .stream()
                .map(DescriptionConverter::toDescriptionDto)
                .toList();
        if(programDescriptionDetails.isEmpty()) {
            log.error("programId = {} 에 해당하는 프로그램의 상세소개를 가져오는데 문제가 발생했습니다.", programId);
            throw new ProgramException(ProgramExceptionErrorCode.PROGRAM_DESCRIPTION_NOT_FOUND);
        } else {
            return programDescriptionDetails;
        }
    }

    private Long calculatePassedRate(Program program) {
        return (long) (((double) program.getPassedNum() / (program.getPassedNum() + program.getFailedNum())) * 100);
    }


    private List<RecommendedProgramDto> getRecommendedProgramsDtosByCareerTag(Long programId, String careerTag) {
        CareerTagEnum careerTagEnum = returnCareerTagEnum(careerTag);
        return recommendedRepository.findByProgramId(programId)
                .stream()
                .map(recommendedProgramConverter::toRecommendedProgramDto)
                .filter(recommendedProgramDto -> recommendedProgramDto.getTag() == careerTagEnum)
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
