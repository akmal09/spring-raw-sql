package com.raw.springsql.repository;

import com.raw.springsql.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepo extends JpaRepository<Produk, Integer> {
}
