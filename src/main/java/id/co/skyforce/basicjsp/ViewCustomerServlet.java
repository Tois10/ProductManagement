package id.co.skyforce.basicjsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;


import id.co.skyforce.basicjsp.domain.*;
import id.co.skyforce.basicjsp.*;

public class ViewCustomerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
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
