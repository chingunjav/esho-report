package edu.miu.shop.eshopreport.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter

public class Product {
	
    private String productId;
    //@Indexed(unique=true) // make it unique username
    private String productName;
    private double price;
    private String description;
    private String manufacturer;
    private  int currentQuantity;
    private ArrayList<ProductDetail> productDetails = new ArrayList<>();
    private String vendorId;
    private String  categoryName;
    private String  categoryId;
    private List<String> imageList;
    private ProductStatus status ;
}
