package id.co.skyforce.basicjsp.domain;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import com.codequ.domain.Category;
//import com.codequ.domain.Order;
//import com.codequ.domain.OrderDetail;
//import com.codequ.domain.Product;
//import com.codequ.domain.Supplier;
//import com.codequ.util.HibernateUtil;
//
//public class CrudPenjualan {
//
//	public void insertItem() throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Session session = HibernateUtil.openSession();
//		Transaction trx = session.beginTransaction();
//
//		OrderDetail orderDetail = new OrderDetail();
//		Boolean cekIdProdct = false;
//
//		System.out.println("Input Id Produk   : ");
//		long idp = Long.parseLong(br.readLine());
//		System.out.println("Jumlah Item  : ");
//		int jumlah = Integer.parseInt(br.readLine());
//
//		Product produk = (Product)session.get(Product.class, idp);
//		Order order = new Order();
//		try {
//			Query query = session.createQuery("from OrderDetail");
//			List<OrderDetail> listOD = query.list();
//
//			for (OrderDetail oDetail : listOD) {
//				if (oDetail.getProduct().getId() == idp) {
//
//					cekIdProdct = true;
//					orderDetail = oDetail; 
//					break;
//				}
//			}
//
//			if (cekIdProdct) {
//				orderDetail.setQuantity(orderDetail.getQuantity() + jumlah);
//			}else{
//				System.out.print("Harga Produk     : ");
//				double hrg = Double.parseDouble(br.readLine());
//				BigDecimal harga = BigDecimal.valueOf(hrg);
//				
//				//order.setTotalAmount(new BigDecimal(produk.getStock().doubleValue() * produk.getPrice().doubleValue()));
//				orderDetail.setQuantity(jumlah);
//				orderDetail.setPrice(harga);
//				orderDetail.setProduct(produk);
//			}
////			session.save(order);
////			session.save(produk);
//			session.save(orderDetail);
//			trx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trx.rollback();
//		}
//
//		session.close();
//	}
//	
//	public void deleteItem() throws NumberFormatException, IOException{
//		Session session = HibernateUtil.openSession();
//		Transaction trx = session.beginTransaction();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Boolean dataIdProdct = false;
//		try {
//			System.out.println("----------------------------");
//			System.out.print("-- Delete Id Product : ");
//			long idp = Long.parseLong(br.readLine());
//			System.out.println("\n----------------------------");
//			
//		    Query query = session.createQuery("from OrderDetail");
//		    List<OrderDetail> listDetail = query.list();
//		     OrderDetail orDetail = new OrderDetail();
//		    for (OrderDetail orderDetail : listDetail) {
//				if (orderDetail.getProduct().getId() == idp) {
//					orDetail = orderDetail;
//					dataIdProdct = true;
//					System.out.println("Data dengan id product "+orderDetail.getProduct().getId()+" dihapus");
//					break;
//				}
//			}
//		    
//		    if (dataIdProdct) {
//				session.delete(orDetail);
//			}else{
//				System.out.println("data id product "+idp+" tidak ditemukan");
//			}
//		    
//			trx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trx.rollback();
//		}
//			
//		session.close();
//	}
//	
//	public void listItem(){
//		Session session = HibernateUtil.openSession();
//		Transaction trx = session.beginTransaction();
//		double totalHarga =0;
//		try {
//			Query query = session.createQuery("from OrderDetail");
//			List<OrderDetail> viewDetail = query.list();
//			
//			System.out.println("id product ||nama produk|| harga ||jumlah||subtotal ");
//			for (OrderDetail OD : viewDetail) {
//				double subTotal =0; 
//				subTotal = OD.getProduct().getPrice().doubleValue() * OD.getQuantity().doubleValue();
//				
//				totalHarga = totalHarga + subTotal;
//				BigDecimal sum = BigDecimal.valueOf(subTotal);
//				BigDecimal sumHarga = BigDecimal.valueOf(totalHarga);
//				
//				System.out.println("     "+OD.getProduct().getId()+ " || "+OD.getProduct().getName()+"||"+OD.getProduct().getPrice()+"||"+OD.getQuantity()+"||"+sum);
//			}
//				System.out.println("Total Harga  : "+totalHarga);
//			trx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trx.rollback();
//		}
//		
//		session.close();
//	}
//
//}
