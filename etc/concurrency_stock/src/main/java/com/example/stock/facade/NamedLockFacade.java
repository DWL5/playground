package com.example.stock.facade;

import com.example.stock.repository.LockRepository;
import com.example.stock.service.StockService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NamedLockFacade {

    private final LockRepository lockRepository;
    private final StockService stockService;

    public NamedLockFacade(LockRepository lockRepository, StockService service) {
        this.lockRepository = lockRepository;
        this.stockService = service;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        try {
            lockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);
        } finally {
            lockRepository.releaseLock(id.toString());
        }
    }
}
