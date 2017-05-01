package resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Skills {

	private ArrayList<String> skills;
	private ArrayList<String> desc;
	private HashMap<String, String> skillsAndDesc;

	public Skills() {
		this.skills = new ArrayList<String>();
		this.desc = new ArrayList<String>();
		this.skillsAndDesc = new HashMap<String, String>();
	}
	
	public void add(String ski, String info) {
		skills.add(ski);
		desc.add(info);
		skillsAndDesc.put(ski, info);
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
	
	public HashMap<String, String> getSkillAndDesc(){
		return this.skillsAndDesc;
	}
	
	

}