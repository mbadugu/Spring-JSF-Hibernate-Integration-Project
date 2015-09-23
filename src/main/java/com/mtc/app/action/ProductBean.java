package com.mtc.app.action;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.dao.ProductDAO;
import com.mtc.app.entity.Product;

@Component
@ManagedBean
@Scope("session")
public class ProductBean {

	private int id;
	private String name;
	private String description;
	private float price;
	private String date;
	
	@Autowired
	@Qualifier("productDAO")
	private IProductDAO productDAO ;
	private List<Product> productsList;
	
	@PostConstruct
	public void initProductBean() {
		productsList=fetchAllProduct();
		
	}
	public List<Product> fetchAllProduct(){
		System.out.println("********fetchAllProduct()*******");
		productsList=productDAO.getproducts();
		return productsList;
	}
	
	public void addProduct(){
		Product product = new Product(id,name,description,price);
		productDAO.addProduct(product);
		productsList=fetchAllProduct();
	}
	
   public List<Product> getProductsList() {
		return productsList;
	}
  
   public void date(){
	   
   }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
