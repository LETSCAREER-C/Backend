package com.letscareer_c.domain.program.domain;

import com.letscareer_c.domain.program.domain.tag.CareerTagEnum;
import com.letscareer_c.domain.program.domain.tag.RecruitStatus;
import com.letscareer_c.domain.review.domain.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DiscriminatorColumn(name="dtype")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략 사용 , dtype 컬럼으로 구분 , 상속받은 클래스들이 하나의 테이블에 저장
@Getter
@Entity
public abstract class Program {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PROGRAM_ID")
    private Long id;
    @NotNull
    @Column(name = "dtype", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING) // Enum 타입을 문자열로 변환하여 저장 , 챌린지, LIVE 클래스 구분
    private ProgramTypeEnum dtype;
    @NotNull
    @Column(name="PROGRAM_TITLE") // 프로그램 제목
    private String title;
    @NotNull
    @Column(name="PROGRAM_INTRO") // 짧은 설명
    private String intro;
    @NotNull
    @Column(name = "PROGRAM_THUMBNAIL") // 썸네일 이미지
    private String thumbnail;
    @NotNull
    @Enumerated(EnumType.STRING) // Enum 타입을 문자열로 변환하여 저장
    private RecruitStatus recruitStatus; // 모집 상태 ( UPCOMING, RECRUITING, ENDED )

    //다대다 관계를 중간 테이블 없이 간단하게 처리하기 위해(조인 X) 값타입 컬렉션 이용
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CAREER_TAG")
    private CareerTagEnum tag;
    @NotNull
    private LocalDateTime recruitStartDate; // 모집 시작일
    @NotNull
    private LocalDateTime recruitEndDate; // 모집 종료일
    @NotNull
    private LocalDateTime programStartDate; // 프로그램 시작일
    @NotNull
    private LocalDateTime programEndDate; // 프로그램 종료일
    @NotNull
    private int total; // 총 모집 인원
    @NotNull
    private boolean isOnline; // 온라인 여부
    private String openChatting; // 오픈 채팅방 링크
    private String openChattingPassword; // 오픈 채팅방 비밀번호
    private int price; // 가격
    private int priceType;  // 가격 타입 ( 0: 무료, 1: 유료 )
    private int discountAmount; // 할인 금액
    private String pcMainImageUrl; // PC 메인 이미지
    private String mobileMainImageUrl; // 모바일 메인 이미지
    private int passedNum; //합격자 수
    private int failedNum; //불합격자 수

    @OneToOne(mappedBy = "program")
    private Lecturer lecturer; // 강사 정보

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hooking> hooking = new ArrayList<>(); // 프로그램 후킹 정보

    @NotNull
    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Description> description = new ArrayList<>(); // 프로그램 상세 정보

    @NotNull
    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curriculum>  curriculum = new ArrayList<>(); // 커리큘럼 정보

    @NotNull
    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Faq> faq = new ArrayList<>(); // FAQ 정보

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> review = new ArrayList<>(); // 후기 정보

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecommendedProgram> recommendedPrograms = new ArrayList<>(); // 추천 강좌

}
