package resume;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
