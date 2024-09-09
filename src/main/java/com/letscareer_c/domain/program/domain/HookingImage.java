package com.letscareer_c.domain.program.domain;


import com.letscareer_c.global.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class HookingImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String pcImageUrl;

    private int orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOOKING_ID")
    private Hooking hooking;

}
