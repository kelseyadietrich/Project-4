package resume;

import java.util.Arrays;
import java.util.List;

public class Education {
	private String school, startDate, endDate, degree, additional, major, minor;
	private Address address;
	private boolean stillGoes;
	private List<String> smallAddr;

	public Education(String school, Address address, String startDate, String endDate,
					 String degree, String additional, boolean stillGoes, String major,
					 String minor){
		this.school = school;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.degree = degree;
		this.additional = additional;
		this.stillGoes = stillGoes;
		this.major = major;
		this.minor = minor;
	}

	public String getSchool(){ return school; }
	public Address getAddress(){ return address; }
	public String getStart(){ return startDate; }
	public String getEnd(){ return endDate; }
	public String getDegree(){ return degree; }
	public String getAdditional(){ return additional; }
	public String getMajor(){ return major; }
	public String getMinor(){ return minor; }
	public boolean stillGoes(){ return stillGoes; }

	@Override
	public String toString(){
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%b", school, address, startDate,
							 endDate, degree, additional, stillGoes);
	}
}
