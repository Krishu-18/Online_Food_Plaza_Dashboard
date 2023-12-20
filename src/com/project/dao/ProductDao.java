package com.project.dao;

import java.util.List;

import com.project.dto.ProductDTO;

public interface ProductDao {
	boolean saveProduct(ProductDTO product);
	boolean updateProduct(ProductDTO product);
	boolean deleteProduct(String product_name);
	ProductDTO searchProduct(ProductDTO product_name);
	List<ProductDTO> showAllProduct();
}
