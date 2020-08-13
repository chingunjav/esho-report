package edu.miu.shop.eshopreport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendorRevenue {
	
	private String vID;
	private int day;
	private double amount;
}
