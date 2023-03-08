package com.example.paymentsystem.rest;


import com.example.paymentsystem.model.Payment;
import com.example.paymentsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "{paymentId}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getPayment(@PathVariable(name = "paymentId") Long paymentId) {
        Payment payment = paymentService.getById(paymentId);
        return payment != null
                ? new ResponseEntity<>(payment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        paymentService.save(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{paymentId}", method = RequestMethod.DELETE)
    public ResponseEntity<Payment> deletePayment(@PathVariable(name = "paymentId") Long paymentId) {
        paymentService.delete(paymentId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payments = paymentService.getAll();

        return payments != null && !payments.isEmpty()
                ? new ResponseEntity<>(payments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
