package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.dao.curriculum.CurriculumRepository;
import com.letscareer_c.domain.program.dao.description.DescriptionRepository;
import com.letscareer_c.domain.program.dao.faq.FaqRepository;
import com.letscareer_c.domain.program.dao.hooking.HookingRepository;
import com.letscareer_c.domain.program.dao.lecturer.LecturerRepository;
import com.letscareer_c.domain.program.dao.recommendedProgram.RecommendedRepository;
import com.letscareer_c.domain.program.dao.review.ReviewRepository;
import com.letscareer_c.domain.program.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private FaqRepository faqRepository;
    @Autowired
    private CurriculumRepository curriculumRepository;
    @Autowired
    private HookingRepository hookingRepository;
    @Autowired
    private DescriptionRepository descriptionRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private RecommendedRepository recommendedRepository;

    // Hooking 조회 테스트
    @Test
    @DisplayName("프로그램 아이디에 해당하는 모든 Hooking을 조회한다.")
    void findHookingByProgramId() {
        // GIVEN

        // WHEN
        List<Hooking> hookings = hookingRepository.findByProgramId(1L);

        // THEN
        assertThat(hookings).isNotNull();
        assertThat(hookings.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("프로그램 아이디에 해당하는 모든 Description을 조회한다.")
    void findDescriptionByProgramId() {
        // GIVEN

        // WHEN
        List<com.letscareer_c.domain.program.domain.Description> descriptions = descriptionRepository.findByProgramId(1L);

        // THEN
        assertThat(descriptions).isNotNull();
        assertThat(descriptions.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("프로그램 아이디에 해당하는 연사를 조회한다.")
    void findLecturerByProgramId() {
        // GIVEN

        // WHEN
        Lecturer lecturer = lecturerRepository.findByProgramId(1L);

        // THEN
        assertThat(lecturer).isNotNull();
        assertThat(lecturer.getName()).isEqualTo("Lecturer 1");
    }

    // 커리큘럼 조회 테스트
    @Test
    @DisplayName("프로그램 아이디에 해당하는 모든 커리큘럼을 조회한다.")
    void findCurriculumByProgramId() {
        // GIVEN

        // WHEN
        List<Curriculum> curriculums = curriculumRepository.findByProgramId(1L);

        // THEN
        assertThat(curriculums).isNotNull();
        assertThat(curriculums.size()).isEqualTo(6);

    }

    // Review 조회 테스트
    @Test
    @DisplayName("프로그램 아이디에 해당하는 모든 Review를 조회한다.")
    void findReviewByProgramId() {
        // GIVEN

        // WHEN
        List<Review> allReviews = reviewRepository.findByProgramId(1L);

        // THEN
        assertThat(allReviews).isNotNull();
        assertThat(allReviews.size()).isEqualTo(3);
    }

    // FAQ 조회 테스트
    @Test
    @DisplayName("프로그램 아이디에 해당하는 모든 FAQ를 조회한다.")
    void findFaqByProgramId() {
        // GIVEN

        // WHEN
        List<Faq> faqs = faqRepository.findByProgramId(1L);

        // THEN
        assertThat(faqs).isNotNull();
        assertThat(faqs.size()).isEqualTo(7);
    }

    @Test
    @DisplayName("프로그램에 연결되어 있는 추천강좌를 조회한다.")
    void findRecommendedProgramByProgramId() {
        // GIVEN

        // WHEN
        List<RecommendedProgram> recommendedPrograms = recommendedRepository.findByProgramId(1L);

        // THEN
        assertThat(recommendedPrograms).isNotNull();
        assertThat(recommendedPrograms.size()).isEqualTo(2);
    }
}
