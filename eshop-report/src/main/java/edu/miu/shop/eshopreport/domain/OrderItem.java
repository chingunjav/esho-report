package edu.miu.shop.eshopreport.domain;

public class OrderItem {
    public String id;
    private String productId;
    private double price;
    private int quantity;

    public OrderItem(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}
