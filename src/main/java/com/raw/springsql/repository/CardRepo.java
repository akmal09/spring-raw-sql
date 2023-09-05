package com.raw.springsql.repository;

import com.raw.springsql.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Integer> {}