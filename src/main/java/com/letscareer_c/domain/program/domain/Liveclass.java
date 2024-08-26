package com.letscareer_c.domain.program.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@DiscriminatorValue("LIVECLASS")
@Getter
@Entity
public class Liveclass extends Program{
}
