package resume;

public class Education implements ResumeObject {
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

	// table EDUCATIONDATA

	public String getSchool(){ return school; } // column 2
	public String getStart(){ return startDate; } // column 3
	public String getEnd(){ return endDate; } // column 4
	public String getDegree(){ return degree; } // column 6
	public String getAdditional(){ return additional; } // column 9
	public String getMajor(){ return major; } // column 7
	public String getMinor(){ return minor; } // column 8
	public boolean stillGoes(){ return stillGoes; } // column 5

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
	
	public void isSerializable(){}

	@Override
	public String toString(){
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%b", school, startDate,
							 endDate, degree, additional, stillGoes);
	}
}
