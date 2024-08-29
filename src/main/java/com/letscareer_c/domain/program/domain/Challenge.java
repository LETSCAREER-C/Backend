package com.letscareer_c.domain.program.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDate;

@DiscriminatorValue("CHALLENGE")
@Getter
@Entity
public class Challenge extends Program{
    private LocalDate otDate;
}
