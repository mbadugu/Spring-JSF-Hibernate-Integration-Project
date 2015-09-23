package com.mtc.app.dao;

import java.util.List;

import com.mtc.app.entity.Product;

public interface IProductDAO {
public void addProduct(Product product);
public Product getproductById(int id);
public List<Product> getproducts();
public Float getMaxPrice();
void addProducts(List<Product> products);

}
