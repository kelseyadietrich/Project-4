package resume;

import java.util.ArrayList;
import java.util.HashMap;

public class Skills {

	private ArrayList<String> skills;
	private ArrayList<String> desc;

	public Skills() {
		this.skills = new ArrayList<String>();
		this.desc = new ArrayList<String>();
	}
	
	public void add(String ski, String info) {
		skills.add(ski);
		desc.add(info);
	}
	
	public String getSkill(int i) {
		return skills.get(i);
	}
	
	public String getDesc(int i) {
		return desc.get(i);
	}
	
	public int size() {
		return skills.size();
	}

}