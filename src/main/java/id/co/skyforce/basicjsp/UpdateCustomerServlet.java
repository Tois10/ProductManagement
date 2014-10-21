package id.co.skyforce.basicjsp;


import id.co.skyforce.basicjsp.domain.Customer;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import id.co.skyforce.basicjsp.domain.*;
import id.co.skyforce.basicjsp.*;

public class UpdateCustomerServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Session session = (Session) HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		
		String idCustomer = req.getParameter("idCustomer");
		Date now = new Date();
		String mobilePhone = req.getParameter("mobileNo");
		String homePhone = req.getParameter("homePhone");
		String email = req.getParameter("email");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String password = req.getParameter("password");
		
		String city = req.getParameter("city");
		String postalCode = req.getParameter("postalCode");
		String street = req.getParameter("street");
		

		Customer customer = (Customer) session.get(Customer.class,Long.parseLong(idCustomer));
		
		customer.getAddress().setCity(city);
		customer.getAddress().setPostalCode(postalCode);
		customer.getAddress().setStreet(street);
		
		
		customer.setBirthDate(now);
		customer.setEmail(email);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setHomePhone(homePhone);
		customer.setMobileNo(mobilePhone);
		customer.setPassword(password);
		
		
		session.save(customer);
		
		trx.commit();
		session.close();
	}
	
	
	
	
	

}
