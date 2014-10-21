package id.co.skyforce.basicjsp;

import id.co.skyforce.basicjsp.domain.Address;
import id.co.skyforce.basicjsp.domain.Customer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class CustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("add")){
        	Session session = (Session) HibernateUtil.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		
    		String birthDate = req.getParameter("birthDate");
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
    		
    		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    		try {
    		  Date date = format.parse(birthDate);
    		  customer.setBirthDate(date);
    		} catch (ParseException e) {
    		  e.printStackTrace();
    		}
    		
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
        else if(action.equals("update")){
        	Session session = (Session) HibernateUtil.openSession();
    		Transaction trx = session.beginTransaction();
    		
    		
    		String idCustomer = req.getParameter("id");
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("param");
		if(param != null){
				if (param.equals("upt")) {
					String idCustomer = req.getParameter("user");
					Session session = HibernateUtil.openSession();
					Customer customer = (Customer) session.get(Customer.class, Long.parseLong(idCustomer));
					req.setAttribute("customer", customer);
					
					session.close();

					RequestDispatcher r = req.getRequestDispatcher("update.jsp");
					r.forward(req, resp); 
					
				}
				else if(param.equals("dlt")){
					String idCustomer = req.getParameter("user");
					
					Session session = HibernateUtil.openSession();
					Transaction tr = session.beginTransaction();
					
					Customer customer = (Customer) session.get(Customer.class, Long.parseLong(idCustomer));
					session.delete(customer);
					tr.commit();
					
					Query query = session.createQuery("from Customer");
					List<Customer> listCustomer = query.list();
					req.setAttribute("listCustomer", listCustomer);

					session.close();
					
					RequestDispatcher r = req.getRequestDispatcher("view.jsp");
					r.forward(req, resp); 
//					req.getRequestDispatcher("view.jsp").forward(req, resp);
					
					
				}
		}
		else{
		Session session = HibernateUtil.openSession();
				
		Query query = session.createQuery("from Customer");
		List<Customer> listCustomer = query.list();
		
		req.setAttribute("listCustomer", listCustomer);
//		req.getRequestDispatcher("listCustomer.jsp").forward(req, resp);
		
		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
		rd.forward(req, resp);
		session.close();	
		}
    }
}
