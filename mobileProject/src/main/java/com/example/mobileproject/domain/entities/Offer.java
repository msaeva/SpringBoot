package com.example.mobileproject.domain.entities;

import com.example.mobileproject.domain.enums.Engine;
import com.example.mobileproject.domain.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "offers")
@Entity
public class Offer extends BaseEntity {

    @Column
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Engine engine;

    @Column(name = "image-irl")
    private String imageIrl;

    @Column
    private Double mileage;

    @Column
    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;

    @Column
    private Integer year;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne
    private Model models;

    @ManyToOne
    private User seller;
}
