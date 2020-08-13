package edu.miu.shop.eshopreport.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class Order {

    private String id;

    private String orderNumber;

    private LocalDateTime orderDate;
    private double totalCost;
    private List<CartItem> cartItem; // use design pattern
    private String userName;
    private String customerId;
    private  List<CartItem> orderItems = new ArrayList<>();

    public void addOrderItem(CartItem cartItem){
        orderItems.add(cartItem);
    }
    public Order(String orderNumber, LocalDateTime orderDate, List<CartItem> cartItem, String orderedBy) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.cartItem = cartItem;
        this.userName = orderedBy;
    }
}
