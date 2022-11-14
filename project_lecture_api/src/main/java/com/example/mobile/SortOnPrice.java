package com.example.mobile;

import java.util.Comparator;

public class SortOnPrice implements Comparator<Mobile> {
	public int compare(Mobile mobile1, Mobile mobile2) {
		Integer price1 = mobile1.price;
		Integer price2 = mobile2.price;
		if (price1.equals(price2)) {
			return -mobile1.speed.compareTo(mobile2.speed);
		}

		return price1.compareTo(price2);
	}

}
