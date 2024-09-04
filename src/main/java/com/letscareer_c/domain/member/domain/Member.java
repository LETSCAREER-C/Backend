package com.letscareer_c.domain.member.domain;

import com.letscareer_c.domain.program.domain.Review;
import com.letscareer_c.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String dreamCompany; // 희망 회사

    @NotNull
    private String dreamWorkField; // 희망 직종

    @NotNull
    private int year; // 학년

    @NotNull
    private String major; // 전공

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> review = new ArrayList<>(); // 후기 정보


}
