package com.letscareer_c.domain.program.domain;

import com.letscareer_c.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class DescriptionImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String pcImageUrl;

    @NotNull
    private int orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="DESCRIPTION_ID")
    private Description description;
}


