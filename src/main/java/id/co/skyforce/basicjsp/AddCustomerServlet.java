package id.co.skyforce.basicjsp;

import id.co.skyforce.basicjsp.domain.Address;
import id.co.skyforce.basicjsp.domain.Customer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class AddCustomerServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		Session session = (Session) HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
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
	
		
		Address address = new Address();
		address.setCity(city);
		address.setPostalCode(postalCode);
		address.setStreet(street);
		
		session.save(address);
		
		address = (Address) session.get(Address.class, address.getId());
		
		Customer customer = new Customer();
		customer.setAddress(address);
		
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
