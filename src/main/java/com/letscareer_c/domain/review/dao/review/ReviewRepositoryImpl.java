package com.letscareer_c.domain.review.dao.review;

import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.review.domain.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static com.letscareer_c.domain.review.domain.QReview.review;

import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public ReviewRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Review> findByProgram_Tag(CareerTagEnum tag) {
        return jpaQueryFactory.selectFrom(review)
                .where(review.program.tag.eq(tag))
                .fetch();
    }
}
