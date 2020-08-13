package edu.miu.shop.eshopreport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor

public class CartItem {
	
	private String productId;
    private int quantity;
    private double unitCost;
    private String vendorId;
    private String userName;

}
