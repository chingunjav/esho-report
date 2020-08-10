package edu.miu.shop.eshopreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemoUser {
	private int id;
	private String name;
	private int age;
	private String city;
	private String email;
}
