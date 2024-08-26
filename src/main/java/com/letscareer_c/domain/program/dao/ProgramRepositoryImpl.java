package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.api.request.ProgramListRequest;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.letscareer_c.domain.program.domain.QProgram.program;

@Slf4j
public class ProgramRepositoryImpl implements ProgramRepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public ProgramRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Program> findByCondition(ProgramListRequest request) {
        List<Program> programs = jpaQueryFactory.selectFrom(program)
                .where(programTypeEq(request.getProgramTypes()), programCareerTagEq(request.getCareerTags()))
                .fetch();
        return programs;
    }

    private BooleanExpression programTypeEq(List<ProgramTypeEnum> programTypes) {
        //항상 필터링 조건이 들어오므로 null 조건 생략
        return program.dtype.in(programTypes);
    }

    private BooleanExpression programCareerTagEq(List<CareerTagEnum> careerTags) {
        BooleanExpression predicate = program.tags.any().eq(careerTags.get(0));

        for (int i = 1; i < careerTags.size(); i++) {
            predicate = predicate.or(program.tags.any().eq(careerTags.get(i)));
        }

        return predicate;
    }
}
