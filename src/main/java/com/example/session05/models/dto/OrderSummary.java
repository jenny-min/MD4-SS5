package com.example.session05.models.dto;

public class OrderSummary {
    private String orderCode;
    private String customerName;
    private double totalPrice;

    public OrderSummary() {
    }

    public OrderSummary(String orderCode, String customerName, double totalPrice) {
        this.orderCode = orderCode;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
