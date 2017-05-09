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

	public String getStreetSQL(){
		String newStreet = "";
		for(int i = 0; i < street.length(); i ++){
			char letter = street.charAt(i);
			if(!Character.isLetter(letter)) newStreet += "\"" + letter + "\"";
			else { newStreet += letter;}
		}
		return newStreet;
	}
	public String getAptSQL(){
		String newApt = "";
		for(int i = 0; i < apt.length(); i ++){
			char letter = apt.charAt(i);
			if(!Character.isLetter(letter)) newApt += "\"" + letter + "\"";
			else { newApt += letter;}
		}
		return newApt;
	}
	public String getCitySQL(){
		String newName = "";
		for(int i = 0; i < city.length(); i ++){
			char letter = city.charAt(i);
			if(!Character.isLetter(letter)) newName += "\"" + letter + "\"";
			else { newName += letter;}
		}
		return newName;
	}
	public String getStateSQL(){
		String newName = "";
		for(int i = 0; i < state.length(); i ++){
			char letter = state.charAt(i);
			if(!Character.isLetter(letter)) newName += "\"" + letter + "\"";
			else { newName += letter;}
		}
		return newName;
	}

	public void setStreet(String st){ this.street = st; }
	public void setApt(String ap){ this.apt = ap; }
	public void setCity(String cty){ this.city = cty; }
	public void setState(String stat){ this.state = stat; }
	public void setZip(String zp){ this.zip = zp; }

	public String toString() {
		String add = street + " " + apt + ", " + city + ", " + state + ", " + zip;
		return add;
	}

}
