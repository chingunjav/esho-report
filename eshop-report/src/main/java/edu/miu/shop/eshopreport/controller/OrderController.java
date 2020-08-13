package edu.miu.shop.eshopreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.shop.eshopreport.domain.Order;
import edu.miu.shop.eshopreport.domain.VendorRevenue;
import edu.miu.shop.eshopreport.service.OrderService;

@RestController
@RequestMapping("")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/{vID}/revenue")
	public List<VendorRevenue> listOrders(@PathVariable String vID)
	{
		//parameterVariable // ?id=1
		//PathVariable // /1
         
		return  orderService.listRevenueByDay(vID);
	}
	
	
}
