package resume;

public class Education {
	private String school, startDate, endDate, degree, additional, major, minor;
	private boolean stillGoes;

	public Education(String school, String startDate, String endDate,
					 String degree, String additional, boolean stillGoes, String major,
					 String minor){
		this.school = school;
		this.startDate = startDate;
		this.endDate = endDate;
		this.degree = degree;
		this.additional = additional;
		this.stillGoes = stillGoes;
		this.major = major;
		this.minor = minor;
	}

	public String getSchool(){ return school; }
	//public Address getAddress(){ return address; }
	public String getStart(){ return startDate; }
	public String getEnd(){ return endDate; }
	public String getDegree(){ return degree; }
	public String getAdditional(){ return additional; }
	public String getMajor(){ return major; }
	public String getMinor(){ return minor; }
	public boolean stillGoes(){ return stillGoes; }
	
	public void setStart(String start){ this.startDate = start; }
	public void setEnd(String end){ this.endDate = end; }
	public void setDegree(String deg){ this.degree = deg; }
	public void setAdditional(String add){ this.additional = add; }
	public void setMajor(String maj){ this.major = maj; }
	public void setMinor(String min){ this.minor = min; }
	public void setGoes(){ 
		if (stillGoes == true) {
			this.stillGoes = false;
		}else {
			this.stillGoes = true;
		}
	}

	@Override
	public String toString(){
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%b", school, startDate,
							 endDate, degree, additional, stillGoes);
	}
}
