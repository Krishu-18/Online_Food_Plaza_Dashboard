package com.project.dto;

public class ProductDTO {
	private Integer Product_Id;
	private String Product_Name;
	private Integer Product_Price;
	private Integer Product_Quantity;

	public ProductDTO() {
		super();
	}
//to fetch data 
	public ProductDTO(Integer product_Id, String product_Name, Integer product_Price, Integer product_Quantity) {
		super();
		Product_Id = product_Id;
		Product_Name = product_Name;
		Product_Price = product_Price;
		Product_Quantity = product_Quantity;
	}
//to insert or update data
	public ProductDTO(String product_Name, Integer product_Price, Integer product_Quantity) {
		super();
		Product_Name = product_Name;
		Product_Price = product_Price;
		Product_Quantity = product_Quantity;
	}

	public Integer getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(Integer product_Id) {
		Product_Id = product_Id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public Integer getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(Integer product_Price) {
		Product_Price = product_Price;
	}

	public Integer getProduct_Quantity() {
		return Product_Quantity;
	}

	public void setProduct_Quantity(Integer product_Quantity) {
		Product_Quantity = product_Quantity;
	}

	@Override
	public String toString() {
		return "ProductDTO [Product_Id=" + Product_Id + ", Product_Name=" + Product_Name + ", Product_Price="
				+ Product_Price + ", Product_Quantity=" + Product_Quantity + "]";
	}

}
