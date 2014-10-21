package id.co.skyforce.basicjsp.controller;

import id.co.skyforce.basicjsp.HibernateUtil;
import id.co.skyforce.basicjsp.domain.Product;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class ListProductManagement {
	private List<Product> product;

public ListProductManagement(){
	Session session = HibernateUtil.openSession();
	Transaction trx = session.beginTransaction();

	product = session.createQuery("from Product").list();

	trx.commit();
	session.close();
}

public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}


	
}
