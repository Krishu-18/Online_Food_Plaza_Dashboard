package com.project.dto;

public class CartDTO {
	private Integer cart_id;
	private String customer_name;
	private Integer product_id;
	private String product_name;
	private Integer product_price;
	private Integer product_quantity;
	
	public CartDTO() {
		super();
	}

	public CartDTO(String customer_name, Integer product_id, String product_name, Integer product_price,
			Integer product_quantity) {
		super();

		this.customer_name = customer_name;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
	}

	

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", customer_name=" + customer_name + ", product_id=" + product_id
				+ ", product_name=" + product_name + ", product_price=" + product_price + ", product_quantity="
				+ product_quantity + "]";
	}
}
