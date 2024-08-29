package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.dao.dto.ProgramDto;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import static com.letscareer_c.domain.program.domain.QProgram.program;

public class ProgramRepositoryImpl implements ProgramRepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public ProgramRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    //TODO: Challenge인 경우, otDate를 가져올 수 있는 방법 고려 필요(부모인 Program에는 otDate 필드가 없으므로)
    //TODO: Repository 테스트 시 태그 관련 중복으로 데이터가 읽어와져서 그냥 Program 자체를 읽어옴. 근본적인 해결책이 필요.
    @Override
    public List<Program> findByCondition(List<CareerTagEnum> careerTagEnums, List<ProgramTypeEnum> programTypeEnums) {
        List<Program> programs = jpaQueryFactory
                .selectFrom(program)
                .where(programTypeEq(programTypeEnums), programCareerTagEq(careerTagEnums))
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
