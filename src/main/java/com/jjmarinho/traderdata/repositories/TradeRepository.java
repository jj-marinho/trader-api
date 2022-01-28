package com.jjmarinho.traderdata.repositories;

import com.jjmarinho.traderdata.models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
