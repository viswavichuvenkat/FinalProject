// PaymentService.java
package com.example.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.payment.dto.BillingDTO;
import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, RestTemplate restTemplate) {
        this.paymentRepository = paymentRepository;
        this.restTemplate = restTemplate;
    }

    // Process payment by communicating with Billing microservice
    public Payment processPayment(Long billingId, Payment payment) {
        BillingDTO billingDTO = restTemplate.getForObject("http://localhost:9393/api/billings/" + billingId, BillingDTO.class);

        if (billingDTO == null) {
            throw new RuntimeException("BillingRecord not found");
        }

        // Set Payment details from BillingDTO
        payment.setCustomerId(billingDTO.getCustomerId());
        payment.setAmount(billingDTO.getAmount());

        // Save the payment
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get a specific payment by ID
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}
