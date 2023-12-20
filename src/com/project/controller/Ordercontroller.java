package com.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.project.dto.CartDTO;
import com.project.dto.OrderDTO;
import com.project.service.OrderService;
import com.project.service.impl.OrderServiceImpl;

public class Ordercontroller {
	private int optionOrder = 0;
	Scanner s = new Scanner(System.in);
	OrderService orderService = new OrderServiceImpl();

	// instance block
	{
		do {
			System.out.println("1. Select 1 to Book an Order\n2. Select 2 to Cancel an Order\n3. Select 3 for Exit\"");
			optionOrder = s.nextInt();
			switch (optionOrder) {
			case 1:
				bookOrder();
				break;
			case 2:
				cancelOrder();
				break;
			case 3:
				System.out.println("Exited from Order Section Successfully...");
				break;
			}
		} while (optionOrder != 3);
	}

	private void bookOrder() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter Customer name");
			String customer_name = br.readLine();
			System.out.println("Enter Customer Id");
			Integer customer_id = Integer.parseInt(br.readLine());
			System.out.println("Enter Product name");
			String product_name = br.readLine();
			System.out.println("Enter No Of Product");
			Integer product_quantity = Integer.parseInt(br.readLine());
			System.out.println("Enter totall bill");
			Float totalbill = Float.parseFloat(br.readLine());

			OrderDTO order = new OrderDTO(customer_name, customer_id, product_name,product_quantity,totalbill);
			boolean isOrderSaved = orderService.bookOrder(order);// orderserive is the object declared above
			if (isOrderSaved) {
				System.out.println("Data has been saved successfully...");
				System.out.println("Customer name= " + customer_name + "," + " Customer id= " + customer_id + ","
						+ " Product name= " + product_name + "," + " Product Quantity= " + product_quantity + ","
						+    "," + "totallbill="+totalbill );
			} else {
				System.out.println("Something went wrong to save data..");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	private void cancelOrder() {
		System.out.println("Enter Customer Name to cancel order");
		String customer_name = s.next();
		boolean isorderCancelled = orderService.cancelOrder(customer_name);
		if (isorderCancelled) {
			System.out.println("Order has been Cancelled  successfully...");
		} else {
			System.out.println("Something went wrong to cancel data..");

		}

	}
}
