package com.example.mobile;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mobile {
	@Id
	Integer price;
	Integer speed;

	public Mobile(Integer price, Integer speed) {
		super();
		this.price = price;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Mobile [price=" + price + ", speed=" + speed + "]";
	}

}
