package com.mtc.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtc.app.entity.Product;

@Repository
public class ProductDAO implements IProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//@Transactional(propagation=Propagation.REQUIRED,timeout=60)
	public void addProduct(Product product) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(product);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
			session.save(product);
		transaction.commit();
	session.close();
	}

	public Product getproductById(int id) {
		Session session = sessionFactory.openSession();
		Product product = (Product)session.get(Product.class, id);
		return product;
	}

	public List<Product> getproducts() {
		Session session = sessionFactory.openSession();
		Query query =session.createQuery("from Product");
		//List<Product> products = query.list();
		return query.list();
	}

	public Float getMaxPrice() {
		Session session = sessionFactory.openSession();
		Query query =session.createQuery("select max(p.price) from Product");
		Float maxPrice=(Float)query.uniqueResult();
		return maxPrice;
	}

	public void addProducts(List<Product> products) {
		// TODO Auto-generated method stub
		
	}

}
