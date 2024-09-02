package com.letscareer_c.domain.program.dao;

import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.ProgramTypeEnum;
import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.letscareer_c.domain.program.domain.QProgram.program;

public class ProgramRepositoryImpl implements ProgramRepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public ProgramRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Program> findByCondition(CareerTagEnum careerTagEnum, List<ProgramTypeEnum> programTypeEnums,
                                         Pageable pageable) {
        //TODO: Challenge인 경우, otDate를 가져올 수 있는 방법 고려 필요(부모인 Program에는 otDate 필드가 없으므로)
        //TODO: Repository 테스트 시 태그 관련 중복으로 데이터가 읽어와져서 그냥 Program 자체를 읽어옴. 추후에 ProgramDto 로 변경 필요
        List<Program> content = jpaQueryFactory
                .selectFrom(program)
                .where(programTypeEq(programTypeEnums),
                        programCareerTagEq(careerTagEnum)) //동적쿼리로 태그 전체보기 혹은 하나만 선택 해결
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = jpaQueryFactory
                .select(program.count())
                .from(program)
                .where(programTypeEq(programTypeEnums),
                        programCareerTagEq(careerTagEnum));

        return PageableExecutionUtils.getPage(content,pageable,()->countQuery.fetchOne());
    }

    private BooleanExpression programCareerTagEq(CareerTagEnum careerTagEnum) {
        if(careerTagEnum==null) return null;
        return program.tag.eq(careerTagEnum);
    }

    private BooleanExpression programTypeEq(List<ProgramTypeEnum> programTypes) {
        //항상 필터링 조건이 들어오므로 null 조건 생략
        return program.dtype.in(programTypes);
    }
}
