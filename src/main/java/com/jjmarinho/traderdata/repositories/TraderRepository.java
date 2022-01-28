package com.jjmarinho.traderdata.repositories;

import com.jjmarinho.traderdata.models.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, Long> {
}