package resume;

import java.io.Serializable;

public class Work implements ResumeObject, Serializable {
	private String title, employer, startDate, endDate, description;
	private boolean stillWorks;
	//Date startDate;
	//Date endDate;
	
	public Work(){this.title = null;this.employer=null;this.startDate=null;
	this.endDate=null;this.description=null;this.stillWorks=false;}

	public Work(String title, String employer, String startDate, String endDate,
			    String description, boolean stillWorks){
		this.title = title;
		this.employer = employer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.stillWorks = stillWorks;
	}

	// table EXPERIENCEDATA

	public String getTitle(){ return title; } // column 2
	public String getEmployer(){ return employer; } // column 3
	public String getStart(){ return startDate; } // column 4
	public String getEnd(){ return endDate; } // column 5
	public String getDescrip(){ return description; } // column 7
	public boolean stillWorks(){ return stillWorks; } // column 6

	public void setTitle(String tit){ this.title = tit; }
	public void setEmployer(String emp){ this.employer = emp; }
	public void setStart(String start){ this.startDate = start; }
	public void setEnd(String end){ this.endDate = end; }
	public void setDescrip(String desc){ this.description = desc; }
	public void setWorking(Boolean b){ 
		stillWorks = b;
	}
	
	public void isSerializable(){}

	@Override
	public String toString(){
		return String.format("%s\n%s\n%s\n%s\n%s\n%b", title, employer, startDate, endDate,
							 description, stillWorks);
	}


}
