package resume;

public class User {
	private String name, email, phone, address, additional;

	public User(String name, String email, String phone, String address, String additional) {
		this.name = name;
		this.email =  email;
		this.phone = phone;
		this.address = address;
		this.additional = additional;
	}

	public String getName(){ return name; }
	public String getEmail(){ return email; }
	public String getPhone(){ return phone; }
	public String getAddress(){ return address; }
	public String getAdditional(){ return additional; }

	@Override
	public String toString(){
		return String.format("%s\n%s\n%s\n%s\n%s", name, email, phone, address, additional);
	}
}
