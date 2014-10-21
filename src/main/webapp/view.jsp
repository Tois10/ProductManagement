<%@page import="javax.management.Query"%>
<%@page import="id.co.skyforce.basicjsp.domain.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="view" method="get">
		<center><table border="4">
		<h3>Tampilan Customer</h3>
			<tr>
				<td><center>	ID Customer	</center></td>
				<td><center>	Nama 	</center></td>
				<td><center>	Email	</center></td>
				<td><center>	Birth Day		</center></td>
<!-- 				<td><center>	Nama Belakang</center></td> -->
<!-- 				<td><center>	Home Phone	</center></td> -->
<!-- 				<td><center>	Mobile Phone</center></td> -->
<!-- 				<td><center>	Passowrd	</center></td> -->
<!-- 				<td><center>	Kota		</center></td> -->
<!-- 				<td><center>	Kode Pos	</center></td> -->
<!-- 				<td><center>	Jalan		</center></td> -->
				<td><center>	Action		</center></td>
			</tr>
			
	<%
				List<Customer> listCust = (List<Customer>) request.getAttribute("listCustomer");
				for(Customer c : listCust){
			%><tr align="center">
			
					<td> <% out.print(c.getId()); %></td>
					<td> <% out.print(c.getFirstName()+" "+c.getLastName()); %></td>
					<td> <% out.print(c.getEmail()); %></td>
					<td> <% out.print(c.getBirthDate()); %></td>
					<%-- 					<td> <% out.print(c.getLastName()); %></td> --%>
<%-- 					<td> <% out.print(c.getHomePhone()); %></td> --%>
<%-- 					<td> <% out.print(c.getMobileNo()); %></td> --%>
					
<%-- 					<td> <% out.print(c.getPassword()); %></td> --%>
<%-- 					<td> <% out.print(c.getAddress().getStreet()); %></td> --%>
<%-- 					<td> <% out.print(c.getAddress().getCity()); %></td> --%>
<%-- 					<td> <% out.print(c.getAddress().getPostalCode()); %></td> --%>

<% out.print("<td> <a href=\"http://localhost:8080/basicjsp1/view?param=upt&user="+c.getId()+"\">Edit</a>" + "</td>") ;%>
<% out.print("<td> <a href=\"http://localhost:8080/basicjsp1/view?param=dlt&user="+c.getId()+"\">Hapus</a>" + "</td>");%>
					
			</tr><% 
			}
			%>
			
		</table></center>
		
		<h4><center><a href="add.jsp">New Customer</a></center></h4>
	</form>
</body>
</html>