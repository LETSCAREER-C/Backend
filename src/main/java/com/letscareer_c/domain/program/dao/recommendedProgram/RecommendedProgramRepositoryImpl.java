package com.letscareer_c.domain.program.dao.recommendedProgram;

import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.RecommendedProgram;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import static com.letscareer_c.domain.program.domain.QRecommendedProgram.recommendedProgram;

public class RecommendedProgramRepositoryImpl implements RecommendedProgramRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public RecommendedProgramRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<RecommendedProgram> findByProgramIdAndCareerTag(Long programId, CareerTagEnum careerTag) {

        /**
         * RecommendedProgram이 가지고 있는거
         * private Long id;
         * private Program program; // 연관 프로그램
         * private String recommendedProgramId; // 추천 프로그램 ID
         */

        return jpaQueryFactory
                .selectFrom(recommendedProgram)
                .where(recommendedProgram.program.id.eq(programId),
                        recommendedProgram.program.tag.eq(careerTag))
                .fetch();
    }
}
