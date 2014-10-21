package id.co.skyforce.basicjsp.controller;

import id.co.skyforce.basicjsp.HibernateUtil;
import id.co.skyforce.basicjsp.domain.Address;
import id.co.skyforce.basicjsp.domain.Customer;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String mobileNo;
	private String homePhone;
	private String street;
	private String city;
	private String postalCode;
	private String salutation;
	private char gender;
	private Long customerId;
	private Long addressId;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public CustomerController() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");

		if (id != null) {
			customerId = Long.valueOf(id);

			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();

			Customer customer = (Customer) session.get(Customer.class,
					customerId);

			addressId = customer.getAddress().getId();
			firstName = customer.getFirstName();
			lastName = customer.getLastName();
			gender = customer.getGender();
			salutation = customer.getSalutation();
			email = customer.getEmail();
			birthDate = customer.getBirthDate();
			homePhone = customer.getHomePhone();
			mobileNo = customer.getMobileNo();
			city = customer.getAddress().getCity();
			postalCode = customer.getAddress().getPostalCode();
			street = customer.getAddress().getStreet();

			trx.commit();
			session.close();
		}

	}

	public String save() {
		Session session = id.co.skyforce.basicjsp.HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();

		Address address = new Address();
		address.setCity(city);
		address.setPostalCode(postalCode);
		address.setStreet(street);

		session.saveOrUpdate(address);

		address = (Address) session.get(Address.class, address.getId());
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setAddress(address);

		customer.setSalutation(salutation);
		customer.setGender(gender);
		customer.setBirthDate(birthDate);
		customer.setEmail(email);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setHomePhone(homePhone);
		customer.setMobileNo(mobileNo);
		customer.setPassword(password);

		session.saveOrUpdate(customer);

		trx.commit();
		session.close();

		return "list";
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
