package com.project.dto;

public class OrderDTO {
	private int order_Id;
    private String customer_name;
    private int customer_id;
	private String product_name;
	private int product_quantity;
	private float totalbill;

	public OrderDTO() {
		super();
	}

	public OrderDTO(String customer_name, int customer_id,String product_name, int product_quantity, float totalbill) {
		super();
		this.customer_name = customer_name;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
		this.totalbill = totalbill;
		this.customer_id=customer_id;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public float getTotalbill() {
		return totalbill;
	}

	public void setTotalbill(float totalbill) {
		this.totalbill = totalbill;
	}

	@Override
	public String toString() {
		return "OrderDTO [order_Id=" + order_Id + ", customer_name=" + customer_name + ", customer_id=" + customer_id
				+ ", product_name=" + product_name + ", product_quantity=" + product_quantity + ", totalbill="
				+ totalbill + "]";
	}

	
}
