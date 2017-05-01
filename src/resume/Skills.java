package resume;

import java.io.Serializable;
import java.util.ArrayList;

public class Skills implements ResumeObject, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> skills;

	public Skills() {
		this.skills = new ArrayList<String>();
	}

	public void add(String skill) {
		skills.add(skill);
	}

	public String getSkill(int i) {
		return skills.get(i);
	}

	public ArrayList<String> getAll(){
		return skills;
	}

	public int size() {
		return skills.size();
	}
	
	public void isSerializable(){}

}