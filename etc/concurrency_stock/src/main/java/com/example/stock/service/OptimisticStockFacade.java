package com.example.stock.service;

import org.springframework.stereotype.Service;

@Service
public class OptimisticStockFacade {

    private final OptimisticStockService optimisticStockService;

    public OptimisticStockFacade(OptimisticStockService optimisticStockService) {
        this.optimisticStockService = optimisticStockService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (true) {
            try {
                optimisticStockService.decrease(id, quantity);
                break;
            } catch (Exception e) {
                Thread.sleep(50);
            }
        }
    }
}
