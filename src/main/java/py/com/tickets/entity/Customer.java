package py.com.tickets.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = { "ci" }))
public class Customer implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@Column(name = "ci", unique= true, nullable = false)
	private Integer ci;
	
	@Column(name = "firstname",  nullable = false)
	private String firstname;
	
	@Column(name = "lastname",  nullable = false)
	private String lastname;

	@Column(name = "email",  nullable = false)
	private String email;
	
	@Column(name = "telephone", unique= true, nullable = false)
	private String telephone;
	
	@Column(name = "address",  nullable = false)
	private String address;
	
	



	public Customer() {
		
	}
	
	

	public Customer(int ci, String firstname, String lastname, String email, String telephone, String address) {
		super();
		this.ci = ci;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	}




	

	public int getCi() {
		return ci;
	}

	public void setCi(Integer ci) {
		this.ci = ci;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String gettelephone() {
		return telephone;
	}

	public void settelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
	
	
	
	
}
