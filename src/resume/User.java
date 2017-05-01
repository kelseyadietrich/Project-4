package resume;

public class User implements ResumeObject{
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

	public String getName(){ return name; }
	public String getEmail(){ return email; }
	public String getPhone(){ return phone; }
	public Address getAddress(){ return address; }
	public String getAdditional(){ return additional; }
	
	public void setName(String name){this.name = name;}
	public void setEmail(String email){this.email = email;}
	public void setPhone(String phone){this.phone = phone;}
	public void setAdditional(String additional){this.additional = additional;}
	public void setAddress(Address address){this.address = address;}	
	
	public void isSerializable(){}

	@Override
	public String toString(){
		return String.format("%s\n%s\n%s\n%s\n%s", name, email, phone, address, additional);
	}
}
