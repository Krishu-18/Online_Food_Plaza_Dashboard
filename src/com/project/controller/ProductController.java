package com.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.project.dto.ProductDTO;
import com.project.dto.UserDTO;
import com.project.service.ProductService;
import com.project.service.UserService;
import com.project.service.impl.ProductServiceImpl;
import com.project.service.impl.UserServiceImpl;

public class ProductController {
	private int optionProduct = 0;
	Scanner s = new Scanner(System.in);
	ProductService productService = new ProductServiceImpl();
	// instance Block
	{
		do {
			System.out.println("1. Select 1 Add Product\n2. Select 2 Delete Product\n3. Select 3 Update Product"
					+ "\n4. Select 4 to Show All Product\n5. Select 5 to Show Any Product\n6. Select 6 for Exit");
			optionProduct = s.nextInt();
			switch (optionProduct) {
			case 1:
				addProduct();
				break;
			case 2:
				deleteproduct();
				break;
			case 3:
				updateQuantity();
				break;
			case 4:
				showAllProduct();
				break;
			case 5:
				searchAnyProduct();
				break;
			case 6:
				System.out.println("Exited from User Section Successfully...");
				break;
			}
		} while (optionProduct != 6);
	}// end of instance block

	private void addProduct() {

		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter name of the product ");
			String name = br.readLine();
			System.out.println("Enter price of the product");
			int price = Integer.parseInt(br.readLine());
			System.out.println("Enter Quantity of the product");
			int quantity = Integer.parseInt(br.readLine());

			ProductDTO product = new ProductDTO(name,price,quantity);
			boolean isProductSaved = productService.saveProduct(product);
			if (isProductSaved) {
				System.out.println("Data has been saved successfully...");
			} else {
				System.out.println("Something went wrong to save data..");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String updateQuantity() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter Product Id: ");
			int id = s.nextInt();
			System.out.println("EnterProduct name: ");
			String name = br.readLine();
			System.out.println("Enter new Product price: ");
			int price = Integer.parseInt(br.readLine());
			System.out.println("Enter new Product quantity: ");
			int quantity  = Integer.parseInt(br.readLine());
			ProductDTO product = new ProductDTO(id, name, price, quantity);
			boolean isProductUpdated = productService.updateProduct(product);

			if (isProductUpdated) {
				System.out.println("Product updated successfully.");
			} else {
				System.out.println("Something went wrong!\nFailed to update product.");
			}

		} catch (Exception e) {

		}
		return null;
	}

	private void deleteproduct() {
		System.out.println("Enter Product Name to delete record");
		String name = s.next();
		boolean isProductDeleted = productService.deleteProduct(name);
		if (isProductDeleted) {
			System.out.println("Data has been deleted successfully...");
		} else {
			System.out.println("Something went wrong to delete data..");

		}
		
	}

	private String showAllProduct() {
		List<ProductDTO> products = productService.showAllProduct();
		System.out.println("------------------Products Records are------------------");
		for (ProductDTO product : products) {
			System.out.println(product);
		}
		return null;

	}

	private String searchAnyProduct() {
		try {
			System.out.println("Enter Product name: ");
			String name = s.next();
			ProductDTO product = new ProductDTO(null, name, null, null);
			ProductDTO isSearched = productService.searchProduct(product);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
