package com.EcommerceApp.Service;

import java.util.List;

import com.EcommerceApp.Models.Product;

public interface ProductService {
	public List<Product> findProductDetail();

	public void postProduct(Product prd);

	public void putProduct(int id, float price);

	public void deleteProductByPrice(float price);
}
