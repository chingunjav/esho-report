package edu.miu.shop.eshopreport.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.shop.eshopreport.domain.CartItem;
import edu.miu.shop.eshopreport.domain.Order;
import edu.miu.shop.eshopreport.domain.Product;
import edu.miu.shop.eshopreport.domain.VendorRevenue;
import edu.miu.shop.eshopreport.repository.OrderRepository;
import edu.miu.shop.eshopreport.repository.ProductRepository;
import edu.miu.shop.eshopreport.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductRepository productRepo;

	public List<Order> listOrder() {
	return orderRepo.findAll(); 
	}
	
	public List<Order> filteredOrder(List<Order> list, int day){
		 List<Order> result = list.stream()
				 .filter(p ->p.getOrderDate().getDayOfMonth() == day)
				 .collect(Collectors.toList());
		 
		return result;
	}
	
	
	public List<VendorRevenue> listRevenueByDay(String vID){
		
		List<VendorRevenue> result = new ArrayList<VendorRevenue>();
		List<CartItem> orderItem = new ArrayList<CartItem>();
		double Total =0.0;
		List<Order> orderList;
		List<Order> allList = orderRepo.findAll();
		
		int tmpday = LocalDate.now().getDayOfMonth();
	for(int day =0; day<12; day++)
	{ 
		
		orderList = filteredOrder(allList,LocalDate.now().getDayOfMonth()-day);
		Total = 0.0;
		if(orderList.size()>0) {
				for(int i=0; i<orderList.size(); i++)
				{
					orderItem = orderList.get(i).getOrderItems();
					//System.out.println(orderList.get(i).getOrderItems().get(1).getVendorId());
					
					List<CartItem> t = 
					orderItem.stream()
					.filter(p->p.getVendorId()==vID)					
					.collect(Collectors.toList());
					
					//System.out.println(orderList.get(i).getOrderItems().get(0).getVendorId());
				
					for(int to=0; to<t.size(); to++)
					{
						Total += t.get(to).getQuantity()*t.get(to).getUnitCost();
					}
				
				
				}
				
			}
	
		result.add(new VendorRevenue(vID,day+1,Total));
			
	}
		return result;
	}
}
