package resume;

import java.io.Serializable;

public class User implements ResumeObject, Serializable{
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

	public String getNameSQL(){
		String newName = "";
		for(int i = 0; i < name.length(); i ++){
			char letter = name.charAt(i);
			if(!Character.isLetter(letter)) newName += "\"";
			else { newName += letter;}
		}
		return newName;
	}

	public String getEmailSQL(){
		String newEmail = "";
		for(int i = 0; i < email.length(); i ++){
			char letter = email.charAt(i);
			if(!Character.isLetter(letter)) newEmail += "\"" + letter + "\"";
			else { newEmail += letter;}
		}
		return newEmail;
	}

	public String getPhoneSQL(){
		String newPhone = "";
		for(int i = 0; i < phone.length(); i ++){
			char letter = phone.charAt(i);
			if(!Character.isLetter(letter)) newPhone += "\"" + letter + "\"";
			else { newPhone += letter;}
		}
		return newPhone;
	}

	public String getAddSQL(){
		String newAdd = "";
		for(int i = 0; i < additional.length(); i ++){
			char letter = additional.charAt(i);
			if(!Character.isLetter(letter)) newAdd += "\"" + letter + "\"";
			else { newAdd += letter;}
		}
		return newAdd;
	}

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
