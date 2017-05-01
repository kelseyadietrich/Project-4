package resume;

import java.util.ArrayList;

public class Skills {

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

	public int size() {
		return skills.size();
	}
}