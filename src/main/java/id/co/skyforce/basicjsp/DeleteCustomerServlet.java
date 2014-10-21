package id.co.skyforce.basicjsp;

import id.co.skyforce.basicjsp.domain.Address;
import id.co.skyforce.basicjsp.domain.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class DeleteCustomerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String idCustomer = req.getParameter("idCustomer");
		
		Session session = (Session) HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, Long.parseLong(idCustomer));
		
		Address address = (Address) session.get(Address.class, customer.getAddress().getId());
		
		session.delete(customer);
		session.delete(address);
		
		trx.commit();
		session.close();
	}

	
}
