package resume;

import java.util.ArrayList;

public class Skills implements ResumeObject{

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