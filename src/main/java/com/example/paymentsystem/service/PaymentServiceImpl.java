package com.example.paymentsystem.service;

import com.example.paymentsystem.model.Payment;
import com.example.paymentsystem.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getById(Long id) {
        log.info("IN AccountServiceImpl getById {}", id);
        return paymentRepository.findOne(id);
    }

    @Override
    public void save(Payment payment) {
        log.info("IN AccountServiceImpl save {}", payment);
        paymentRepository.save(payment);
    }

    @Override
    public void delete(Long id) {
        log.info("IN AccountServiceImpl delete {}", id);
        paymentRepository.delete(id);
    }

    @Override
    public List<Payment> getAll() {
        log.info("IN AccountServiceImpl findAll");
        return paymentRepository.findAll();
    }
}
