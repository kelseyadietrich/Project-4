package resume;

public class Address {
	private String street, apt, city, state, zip;

	public Address(String street, String apt, String city, String state, String zip){
		this.street = street;
		this.apt = apt;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet(){ return street; }
	public String getApt(){ return apt; }
	public String getCity(){ return city; }
	public String getState(){ return state; }
	public String getZip(){ return zip; }

}
