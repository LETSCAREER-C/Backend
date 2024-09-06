package com.letscareer_c.domain.review.domain;

import com.letscareer_c.domain.member.domain.Member;
import com.letscareer_c.domain.program.domain.Program;
import com.letscareer_c.domain.program.domain.tag.EmploymentStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private int orderNumber;

    @NotNull
    private int grade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private EmploymentStatusEnum status;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROGRAM_ID")
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

}
