package edu.miu.shop.eshopreport.service;

import java.util.List;

import edu.miu.shop.eshopreport.domain.Order;
import edu.miu.shop.eshopreport.domain.VendorRevenue;

public interface OrderService {
	
	List<Order> listOrder();
	
	List<VendorRevenue> listRevenueByDay(String vID); 
}
