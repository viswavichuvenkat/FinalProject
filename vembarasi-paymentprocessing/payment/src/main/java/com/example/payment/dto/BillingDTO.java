// BillingDTO.java
package com.example.payment.dto;

public class BillingDTO {
    private Long id;
    private Long customerId;
    private Double amount;
    private String status;

    public BillingDTO(Long id, Long customerId, Double amount, String status) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
    }

    public BillingDTO() {
    }

    @Override
    public String toString() {
        return "BillingDTO [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", status=" + status
                + "]";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
