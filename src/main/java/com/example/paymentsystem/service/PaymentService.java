package com.example.paymentsystem.service;

import com.example.paymentsystem.model.Payment;

import java.util.List;

public interface PaymentService {

    Payment getById(Long id);

    void save(Payment payment);

    void delete(Long id);

    List<Payment> getAll();
}
