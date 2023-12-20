package com.project.service.impl;

import java.util.List;

import com.project.dao.ProductDao;
import com.project.dao.UserDao;
import com.project.dao.impl.ProductDaoImplUsingJdbc;
import com.project.dao.impl.UserDaoImplUsingJdbc;
import com.project.dto.ProductDTO;
import com.project.service.ProductService;

public class ProductServiceImpl  implements ProductService{
	private ProductDao productDao = new ProductDaoImplUsingJdbc();//downcasting
	@Override
	public boolean saveProduct(ProductDTO product) {
		
		boolean isProductSaved = productDao.saveProduct(product);
		return isProductSaved;
	}

	@Override
	public boolean updateProduct(ProductDTO product) {
		boolean isProductUpdate = productDao.updateProduct(product);
		return isProductUpdate;
	}

	@Override
	public boolean deleteProduct(String product_name) {
		return productDao.deleteProduct(product_name);
	}

	@Override
	public ProductDTO searchProduct(ProductDTO Product_Name) {
		 return productDao.searchProduct(Product_Name);
		
	}

	@Override
	public List<ProductDTO> showAllProduct() {
		return productDao.showAllProduct();
	}

}
