package edu.miu.shop.eshopreport.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class ProductDetail {
	 	private String specName;
	    private String specValue;

	    public ProductDetail(String specName, String specValue) {
	        this.specName = specName;
	        this.specValue = specValue;
	    }
}
