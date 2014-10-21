package id.co.skyforce.basicjsp.controller;

import id.co.skyforce.basicjsp.HibernateUtil;
import id.co.skyforce.basicjsp.domain.Category;
import id.co.skyforce.basicjsp.domain.Product;
import id.co.skyforce.basicjsp.domain.Supplier;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class ProductManagementController {

	private String description;
	private String name;
	private BigDecimal price;
	private int stok;
	private long productId;
	private long categoryId;
	private long suplierId;

	public long getSuplierId() {
		return suplierId;
	}

	public void setSuplierId(long suplierId) {
		this.suplierId = suplierId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}
	
	public ProductManagementController(){
		
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		
		if(id != null){
			productId = Long.valueOf(id);
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			
			Product product = (Product) session.get(Product.class, productId);
			productId = product.getId();
			description = product.getDescription();
			name = product.getName();
			price = product.getPrice();
			stok = product.getStock();
			
			trx.commit();
			session.close();
		}
	}

	
	public String save(){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		Product product = new Product();
		
		Category category = (Category) session.get(Category.class, categoryId);
		Supplier supplier = (Supplier) session.get(Supplier.class, suplierId);
		
		product.setDescription(description);
		product.setName(name);
		product.setPrice(price);
		product.setStock(stok);
		
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		
		session.saveOrUpdate(product);
		
		trx.commit();
		session.close();
		
		return "listProductService";
	}

}
