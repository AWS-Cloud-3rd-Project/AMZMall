package com.amzmall.project.stock.application.port.out;

import com.amzmall.project.stock.adapter.out.StockJpaEntity;
import com.amzmall.project.stock.domain.Stock;
import org.springframework.stereotype.Component;

@Component
public interface RegisterStockPort {

    StockJpaEntity save(Stock stock);

    void decreaseStock(String stockId, int quantity);
}
