<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
		<center><H3>TAMBAH DATA CUSTOMER</H3>
		<table border="3">
			<tr>
				<td>Nama Depan : </td> <td><input type="text" name="firstName">
				</td>
			</tr>
			<tr>
				<td>Nama Belakang : </td> <td><input type="text"
					name="lastName">
				</td>
			</tr>
				<tr>
				<td>Birth Date (dd-MM-yyyy) : </td> <td><input type="text" name="birthDate">
				</td>
			</tr>
			<tr>
				<td>Email : </td> <td><input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td>Home Phone : </td> <td><input type="text" name="homePhone">
				</td>
			</tr>
			<tr>
				<td>Mobile Phone : </td> <td><input type="text"
					name="mobileNo">
				</td>
			</tr>
			<tr>
				<td>Password : </td> <td><input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td>Kota : </td> <td><input type="text" name="city">
				</td>
			</tr>
			<tr>
				<td>Kode Pos : </td> <td><input type="text" name="postalCode"></td>
				
			</tr>
			<tr>
				<td>Jalan : </td> <td><input type="text" name="street">
				</td>
			</tr>
		<td>
			<a href="view"><input type="submit" value="save"></a>
		</td>
		</table>
		</center>
		<input type="hidden" name="action" value="add" />
	</form>
	
</body>
</html>