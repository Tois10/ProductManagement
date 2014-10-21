<%@page import="id.co.skyforce.basicjsp.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="update" method="post">
	<%
		Customer customer = (Customer) request.getAttribute("customer");
	%>
	<input type="hidden" name="id" value=<%=customer.getId()%> />
		<center>
			<H3>UBAH DATA CUSTOMER</H3>
			<table border="3">
				<tr>
					<td>Nama Depan :</td>
					<td><input type="text" name="firstName"
						value="<%out.print(customer.getFirstName());%>"></td>
				</tr>
				<tr>
					<td>Nama Belakang :</td>
					<td><input type="text" name="lastName"
						value="<%out.print(customer.getLastName());%>"></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"
						value="<%out.print(customer.getEmail());%>"></td>
				</tr>
				<tr>
					<td>Home Phone :</td>
					<td><input type="text" name="homePhone"
						value="<%out.print(customer.getHomePhone());%>"></td>
				</tr>
				<tr>
					<td>Mobile Phone :</td>
					<td><input type="text" name="mobileNo"
						value="<%out.print(customer.getMobileNo());%>"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"
						value="<%out.print(customer.getPassword());%>"></td>
				</tr>
				<tr>
					<td>Kota :</td>
					<td><input type="text" name="city"
						value="<%out.print(customer.getAddress().getCity());%>"></td>
				</tr>
				<tr>
					<td>Kode Pos :</td>
					<td><input type="text" name="postalCode"
						value="<%out.print(customer.getAddress().getPostalCode());%>"></td>

				</tr>
				<tr>
					<td>Jalan :</td>
					<td><input type="text" name="street" value="<%out.print(customer.getAddress().getStreet());%>"></td>
				</tr>
				<tr>
				<td><input type="submit" value="save"></td>
				</tr>
			</table>
		</center>
		<input type="hidden" name="action" value="update" />
	</form>

</body>
</html>