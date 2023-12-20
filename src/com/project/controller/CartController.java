package com.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.project.dto.CartDTO;
import com.project.service.CartService;

import com.project.service.impl.CartServiceImpl;

public class CartController {
	private int optionCart = 0;
	Scanner s = new Scanner(System.in);
	CartService cartService = new CartServiceImpl();
	// instance block
	{
		do {
			System.out.println("1. Select 1 Add to Cart\n2. Select 2 Delete From Cart\n3. Select 3 for Exit\"");
			optionCart = s.nextInt();
			switch (optionCart) {

			case 1:
				addToProduct();
				break;

			
			case 2: deleteToProduct(); break;
			 
			case 3:
				System.out.println("Exited from Cart Section Successfully...");
				break;
			}
		} while (optionCart != 3);
	}

	private void deleteToProduct() {
		System.out.println("Enter Product Name to delete record");
		String product_name = s.next();
		boolean isProductDeleted = cartService.deleteCart(product_name);
		if (isProductDeleted) {
			System.out.println("Data has been deleted successfully...");
		} else {
			System.out.println("Something went wrong to delete data..");

		}

	}

	private void addToProduct() {

		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter Customer name");
			String customer_name = br.readLine();
			System.out.println("Enter Product Id");
			Integer product_id = Integer.parseInt(br.readLine());
			System.out.println("Enter Product name");
			String product_name = br.readLine();
			System.out.println("Enter Product price");
			Integer product_price = Integer.parseInt(br.readLine());
			System.out.println("Enter Product Quantity");
			Integer product_quantity = Integer.parseInt(br.readLine());

			CartDTO cart = new CartDTO(customer_name, product_id, product_name, product_price, product_quantity);
			boolean isCartProductSaved = cartService.addCart(cart);// cartserive is the object declared above
			if (isCartProductSaved) {
				System.out.println("Data has been saved successfully...");
				System.out.println("Customer name= " + customer_name + "," + " Product id= " + product_id + ","
						+ " Product name= " + product_name + "," + " Product Price= " + product_price + ","
						+ " Product Quantity = " + product_quantity);
			} else {
				System.out.println("Something went wrong to save data..");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
