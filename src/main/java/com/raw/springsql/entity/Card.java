package com.raw.springsql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String jenis;

    private Integer saldo;
}
