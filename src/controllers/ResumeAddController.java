package controllers;
import java.io.IOException;import java.sql.SQLException;import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;import database.CVDataBase;import database.Database;import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resume.*;
import resumeViewer.ExampleMain;
import resumeViewer.LaunchResumeExampleController;
import resumeViewer.ResumeViewer;
public class ResumeAddController {
	/////////// PERSONAL TAB ///////////////
	@FXML
	TextField name;
	@FXML
	TextField email;
	@FXML
	TextField phone;
	@FXML
	TextField userStreet;
	@FXML
	TextField userApt;
	@FXML
	TextField userCity;
	@FXML
	ChoiceBox<String> userState;
	@FXML
	TextField userZip;
	@FXML
	TextArea userAdditional;
	@FXML
	Button personalDone;
	////////// WORK TAB //////////////////
	@FXML
	TextField title;
	@FXML
	TextField employer;
	@FXML
	DatePicker jobStart;
	@FXML
	DatePicker jobEnd;
	@FXML
	CheckBox stillWorks;
	@FXML
	TextArea jobAdditional;
	@FXML
	Button addJob;
	@FXML
	Button jobDone;
	/////////// EDUCATION TAB //////////////////
	@FXML
	TextField school;
	@FXML
	DatePicker eduStart;
	@FXML
	DatePicker eduEnd;
	@FXML
	CheckBox stillGoes;
	@FXML
	ChoiceBox<String> degree;
	@FXML
	TextArea eduAdditional;
	@FXML
	Button addEdu;
	@FXML
	Button eduDone;
	@FXML
	TextField major;
	@FXML
	TextField minor;
	//////////// SKILLS TAB ////////////////////
	@FXML
	TextField skill1;
	@FXML
	TextField skill2;
	@FXML
	TextField skill3;
	@FXML
	TextField skill4;
	@FXML
	TextField skill5;
	@FXML
	TextField skill6;
	@FXML
	TextField skill7;
	@FXML
	Button addSkills;
	@FXML
	Button skillsDone;
	//////////// OTHER VARIABLES ////////////////////////
	@FXML
	Button here;
	@FXML
	TabPane tabs;
	User personal;
	ArrayList<Work> work = new ArrayList<Work>();
	ArrayList<Education> edu = new ArrayList<Education>();
	Skills skills;	int resNum = 1;	Database db;	CVDataBase cvdb;
	List<String> States = new ArrayList<>(Arrays.asList("States", "Alabama", "Alaska", "Arizona",
			"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
			"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
			"Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
			"Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
			"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
			"Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
			"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"));
	List<String> Degrees = new ArrayList<>(Arrays.asList("Degrees", "GED", "High School Diploma",
			"Vocational", "Assosciates", "Bachelors", "Masters", "Doctorate"));
	DocHandler document;
	//////////////////////////////////////////////////////////////
	@FXML
	public void initialize(){
		fillStates();		userState.setValue("Arkansas");
		fillDegrees();		degree.setValue("Bachelor's");
		document = new DocHandler();
		skills = new Skills();
	}	@FXML	public void importVariables(StartController start){		db = start.dbase;	}	@FXML
	private void fillDegrees() {
		for(String deg: Degrees){
			degree.getItems().add(deg);
		}
		degree.getSelectionModel().selectFirst();	}
	@FXML
	private void fillStates() {
		for(String state: States){
			userState.getItems().add(state);
		}
		userState.getSelectionModel().selectFirst();
	}
	@FXML
	public Address getUserAddress(){
		String street, apt, city, state, zip;
		street = userStreet.getText();
		apt = userApt.getText();
		city  = userCity.getText();
		state = userState.getSelectionModel().getSelectedItem();
		zip = userZip.getText();
		return new Address(street, apt, city, state, zip);
	}
	@FXML
	public void addWork() throws ClassNotFoundException{
	    work.add(new Work(title.getText(), employer.getText(), (jobStart.getValue() == null)?"":jobStart.getValue().toString(),
	        (jobEnd.getValue() == null)?"":jobEnd.getValue().toString(), jobAdditional.getText(),
	         stillWorks.isSelected()));	   /* try {	    	Work latest = work.get(work.size() - 1);			db.sendCommand("INSERT INTO Work VALUES (" + resNum + ", " + latest.getTitle() + ", " + latest.getEmployer() + ", " + latest.getStart()													   + ", " + latest.getEnd() + ", " + latest.stillWorks() + ", "	+ latest.getDescrip() + ")");		} catch (SQLException e) {			// TODO Auto-generated catch block			e.printStackTrace();		}*/
	    title.setText("");
	    employer.setText("");
	    jobStart.setValue(null);
	    jobEnd.setValue(null);
	    jobAdditional.setText("");
	    stillWorks.setSelected(false);
	}
	@FXML
	public void addEdu() throws ClassNotFoundException{
		edu.add(new Education(school.getText(), (eduStart.getValue() == null)?"":eduStart.getValue().toString(),
				(eduEnd.getValue() == null)?"":eduEnd.getValue().toString(), degree.getSelectionModel().getSelectedItem(),
				 eduAdditional.getText(), stillGoes.isSelected(), major.getText(), minor.getText()));		/*try {			Education latest = edu.get(edu.size()-1);			db.sendCommand("INSERT INTO Education VALUES (" + resNum + ", " + latest.getSchool() + ", " + latest.getStart() + ", "															+ latest.getEnd() + ", " + latest.stillGoes() + ", " + latest.getDegree() + ", "															+ latest.getMajor() + ", " + latest.getMinor() + ", " + latest.getAdditional() + ")");		} catch (SQLException e) {			// TODO Auto-generated catch block			e.printStackTrace();		}*/		if(major.getText() != "") System.out.println("major: " + major.getText());		if(minor.getText().equals("")) System.out.println("minor is empty");		if(eduAdditional.getText() != "") System.out.println("additional: " + eduAdditional.getText());
		school.setText("");
		eduStart.setValue(null);
		eduEnd.setValue(null);
		degree.getSelectionModel().selectFirst();
		eduAdditional.setText("");
		stillGoes.setSelected(false);
		major.setText("");
		minor.setText("");
	}

	@FXML
	public void addSkills() throws ClassNotFoundException{
		if(!skill1.getText().equals("")) { skills.add(skill1.getText()); }
		if(!skill2.getText().equals("")) { skills.add(skill2.getText()); }
		if(!skill3.getText().equals("")) { skills.add(skill3.getText()); }
		if(!skill4.getText().equals("")) { skills.add(skill4.getText()); }
		if(!skill5.getText().equals("")) { skills.add(skill5.getText()); }
		if(!skill6.getText().equals("")) { skills.add(skill6.getText()); }
		if(!skill7.getText().equals("")) { skills.add(skill7.getText()); }		/*for(int i = 7; i > 0; i --){			try{				db.sendCommand("INSERT INTO Skills VALUES (" + resNum + ", " + skills.getSkill(skills.size() - i) + ")");			} catch (SQLException e){				e.printStackTrace();			}		}*/
		skill1.setText("");
		skill2.setText("");
		skill3.setText("");
		skill4.setText("");
		skill5.setText("");
		skill6.setText("");
		skill7.setText("");
	}
	@FXML
	public void personalDone() throws ClassNotFoundException{		boolean errors = checkPersonal();		if(!errors){
			personal = new User(name.getText(), email.getText(), phone.getText(),
								getUserAddress(), userAdditional.getText());			/*try {				db.sendCommand("INSERT INTO Personal VALUES (" + resNum + "," + personal.getNameSQL() + "," + personal.getEmailSQL() + ","															   + personal.getPhoneSQL() + "," + personal.getAddress().getStreetSQL() + ","															   + personal.getAddress().getAptSQL() + "," + personal.getAddress().getCitySQL() + ","															   + personal.getAddress().getStateSQL() + "," + personal.getAddress().getZip() + ","															   + personal.getAddSQL() + ")");			} catch (SQLException e) {				// TODO Auto-generated catch block				e.printStackTrace();			}*/
			tabs.getSelectionModel().select(1);		}
		//System.out.println(personal.toString());
	}
	@FXML
	public void workDone(){		boolean errors = checkWork();		if(!errors){
		    try {				addWork();			} catch (ClassNotFoundException e) {				// TODO Auto-generated catch block				e.printStackTrace();			}
		    tabs.getSelectionModel().select(2);		}
	}
	@FXML
	public void eduDone(){		boolean errors = checkEdu();		if(!errors){
			try {				addEdu();			} catch (ClassNotFoundException e) {				// TODO Auto-generated catch block				e.printStackTrace();			}
			tabs.getSelectionModel().select(3);		}
	}
	@FXML
	public void skillsDone(){
		try {			addSkills();		} catch (ClassNotFoundException e) {			// TODO Auto-generated catch block			e.printStackTrace();		}
		tabs.getSelectionModel().selectFirst();
	}
	//Where the parsers are called from the button
	@FXML
	public void makeResume() {		checkDone();
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GuiMain.class.getResource("ChooseLayout.fxml"));
			Pane root = (Pane) loader.load();
			ChooseLayoutController choose = (ChooseLayoutController) loader.getController();
			choose.importVariables(this);
			Stage secondStage = new Stage();
			Scene scene = new Scene(root);
			secondStage.setScene(scene);
			secondStage.show();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}	@FXML	public boolean checkPersonal(){		boolean errors = false;		if((name.getText() == "")){			error("You are nameless.");			errors = true;		}else if((userStreet.getText() == "") || (userCity.getText() == "")){			error("You did not enter a complete address.");			errors = true;		}else if(userState.getSelectionModel().getSelectedItem().equals("States")){			error("Whoa! You do not live a state bud.");			errors = true;		}else if(!userApt.getText().equals("")){			try{				Integer.parseInt(userApt.getText());			} catch (Exception e){				error("Incorrect apartment format.");				errors = true;			}		}		try{			Integer.parseInt(userZip.getText());		} catch (Exception e){			error("Incorrect zipcode format.");			errors = true;		}		return errors;	}	@FXML	public boolean checkWork(){		boolean errors = false;		if((title.getText() == "") || (employer.getText() == "")){			error("You did not enter complete job information");			errors = true;		}else if(jobStart.getValue() == null){			error("You did not put a start date.");			errors = true;		}else if(jobEnd.getValue() == null && !stillWorks.isSelected()){			error("Do you still work here? You need to put an end date if you don't, or if you do, you must say so.");			errors = true;		}else if(!stillWorks.isSelected() && jobStart.getValue().isAfter(jobEnd.getValue())){			error("You cannot end school before you start it. Your dates are incorrect.");			errors = true;		}else if(jobAdditional.getText() == ""){			error("What did you do at this job?");			errors = true;		}		return errors;	}	@FXML	public boolean checkEdu(){		boolean errors = false;		if(school.getText() == ""){			error("You did not enter a school.");			errors = true;		}else if(eduStart.getValue() == null){			error("You did not put a start date.");			errors = true;		}else if(eduEnd.getValue() == null && !stillGoes.isSelected()){			error("Do you still go here? You need to put an end date if you don't, or if you do, you must say so.");			errors = true;		}else if(!stillGoes.isSelected() && eduStart.getValue().isAfter(eduEnd.getValue())){			error("You cannot end school before you start it. Your dates are incorrect.");			errors = true;		}else if(degree.getSelectionModel().getSelectedItem().equals("Degrees")){			error("What degree did/will you get here?");			errors = true;		}else if((degree.getSelectionModel().getSelectedItem().equals("Bachelors") ||		    degree.getSelectionModel().getSelectedItem().equals("Associates")) &&			major.getText() == ""){			error("Wait! You didn't enter your major.");			errors = true;		}		return errors;	}	@FXML	public void checkDone(){		if((personal == null) && work.size() == 0 && edu.size() == 0 && skills.size() == 0 ){			error("Are you sure you're done? You haven't entered any information.");		}	}	public void error(String e) {		Alert r = new Alert(AlertType.NONE, e , ButtonType.OK);		r.setTitle("ERROR");		r.showAndWait();	}
}
