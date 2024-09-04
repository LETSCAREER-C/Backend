package com.letscareer_c.domain.program.domain;

import com.letscareer_c.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Description extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String imageUrl;

    @NotNull
    private String templateType; // 나중에 enum으로 변경

    @NotNull
    private int orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROGRAM_ID")
    private Program program;

    @OneToMany(mappedBy = "description", fetch = FetchType.LAZY)
    private List<DescriptionImage> descriptionImages;

    @OneToMany(mappedBy = "description", fetch = FetchType.LAZY)
    private List<Hashtag> hashtags;
}
