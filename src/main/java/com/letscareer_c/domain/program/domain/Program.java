package com.letscareer_c.domain.program.domain;

import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @NotNull
    @Column(name = "dtype", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ProgramTypeEnum dtype;
    @NotNull
    @Column(name="PROGRAM_TITLE")
    private String title;
    @NotNull
    @Column(name="PROGRAM_INTRO")
    private String intro;
    @NotNull
    @Column(name = "PROGRAM_THUMBNAIL")
    private String thumbnail;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RecruitStatus recruitStatus;

    //다대다 관계를 중간 테이블 없이 간단하게 처리하기 위해(조인 X) 값타입 컬렉션 이용
    @NotNull
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="PROGRAM_CAREER_TAG",joinColumns = @JoinColumn(name="PROGRAM_ID"))
    @Column(name = "CAREER_TAG")
    private List<CareerTagEnum> tags = new ArrayList<>();
    @NotNull
    private LocalDateTime recruitStartDate;
    @NotNull
    private LocalDateTime recruitEndDate;
    @NotNull
    private LocalDateTime programStartDate;
    @NotNull
    private LocalDateTime programEndDate;
    @NotNull
    private int total;
    @NotNull
    private boolean isOnline;
    private String openChatting;
    private String openChattingPassword;
    private int price;
    private int priceType;
    private int discountAmount;

    //TODO: 후기, FAQ, 상세설명 필드 추가 시, LAZY로 설정하여 프로그램 리스팅에서 성능 최적화
}
