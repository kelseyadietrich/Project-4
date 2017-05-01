package resume;

public class User {
	private String name, email, phone, additional;
	private Address address;

	public User(){}

	public User(String name, String email, String phone, Address address, String additional) {
		this.name = name;
		this.email =  email;
		this.phone = phone;
		this.address = address;
		this.additional = additional;
	}

	/// Table: PERSONALDATA

	public String getName(){ return name; } // column 2
	public String getEmail(){ return email; } // column 3
	public String getPhone(){ return phone; } // column 4
	public Address getAddress(){ return address; } // column 5
	public String getAdditional(){ return additional; } // column 6

	public void setName(String name){this.name = name;}
	public void setEmail(String email){this.email = email;}
	public void setPhone(String phone){this.phone = phone;}
	public void setAdditional(String additional){this.additional = additional;}
	public void setAddress(Address address){this.address = address;}


	@Override
	public String toString(){
		return String.format("%s\n%s\n%s\n%s\n%s", name, email, phone, address, additional);
	}
}
