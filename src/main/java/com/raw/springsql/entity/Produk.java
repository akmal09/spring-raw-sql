package com.raw.springsql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produks")
public class Produk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String nama;
    private String produk;
    private int harga;
}
