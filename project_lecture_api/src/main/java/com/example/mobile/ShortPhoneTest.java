package com.example.mobile;

import java.util.ArrayList;
import java.util.TreeSet;

public class ShortPhoneTest {

	public static void main(String[] args) {
		System.out.println("welcom");
		ArrayList<Mobile> mobilelist = new ArrayList<>();
		mobilelist.add(new Mobile(10, 8));
		mobilelist.add(new Mobile(23, 10));
		mobilelist.add(new Mobile(23, 25));
		mobilelist.add(new Mobile(25, 65));

		TreeSet<Mobile> mobiletree = new TreeSet<>(new SortOnPrice());
		for (Mobile mobile : mobilelist) {

			if (mobile.price >= 15 && mobile.price <= 30) {

				mobiletree.add(mobile);
				System.err.println(mobile);
			}
		}

	}

}
