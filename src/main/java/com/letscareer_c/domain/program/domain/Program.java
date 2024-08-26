package com.letscareer_c.domain.program.domain;

import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DiscriminatorColumn(name="dtype")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Entity
public abstract class Program {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PROGRAM_ID")
    private Long id;
    @Column(name = "dtype", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ProgramTypeEnum dtype;
    @Column(name="PROGRAM_TITLE")
    private String title;
    @Column(name="PROGRAM_INTRO")
    private String intro;
    @Enumerated(EnumType.STRING)
    private RecruitStatus recruitStatus;

    //다대다 관계를 중간 테이블 없이 간단하게 처리하기 위해(조인 X) 값타입 컬렉션 이용
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="PROGRAM_CAREER_TAG",joinColumns = @JoinColumn(name="PROGRAM_ID"))
    @Column(name = "CAREER_TAG")
    private List<CareerTagEnum> tags = new ArrayList<>();
    private LocalDate recruitStartDate;
    private LocalDate recruitEndDate;
    private LocalDate programStartDate;
    private LocalDate programEndDate;

    //TODO: 후기, FAQ, 상세설명 필드 추가 시, LAZY로 설정하여 프로그램 리스팅에서 성능 최적화
}
