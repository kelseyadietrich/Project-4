package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import resume.*;

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
	TextField schoolStreet;
	@FXML
	TextField schoolApt;
	@FXML
	TextField schoolCity;
	@FXML
	ChoiceBox<String> schoolState;
	@FXML
	TextField schoolZip;
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

	//////////// OTHER VARIABLES ////////////////////////
	@FXML
	TabPane tabs;
	User personal;
	ArrayList<Work> work = new ArrayList<Work>();
	ArrayList<Education> edu = new ArrayList<Education>();

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
		fillStates();
		fillDegrees();
		document = new DocHandler();
	}

	private void fillDegrees() {
		for(String deg: Degrees){
			degree.getItems().add(deg);
		}
		degree.getSelectionModel().selectFirst();

	}

	private void fillStates() {
		for(String state: States){
			userState.getItems().add(state);
			schoolState.getItems().add(state);
		}
		userState.getSelectionModel().selectFirst();
		schoolState.getSelectionModel().selectFirst();
	}

	@FXML
	public String getUserAddress(){
		String street, apt, city, state, zip;
		street = userStreet.getText();
		apt = "," + userApt.getText();
		city  = "," + userCity.getText();
		state = "," + userState.getSelectionModel().getSelectedItem();
		zip = "," + userZip.getText();
		return street + apt + city + state + zip;
	}

	@FXML
	public String getSchoolAddress(){
		String street, apt, city, state, zip;
		street = schoolStreet.getText();
		apt = "," + schoolApt.getText();
		city  = "," + schoolCity.getText();
		state = "," + schoolState.getSelectionModel().getSelectedItem();
		zip = "," + schoolZip.getText();
		return street + apt + city + state + zip;
	}

	@FXML
	public void addWork(){
	    work.add(new Work(title.getText(), employer.getText(), (jobStart.getValue() == null)?"":jobStart.getValue().toString(),
	        (jobEnd.getValue() == null)?"":jobEnd.getValue().toString(), jobAdditional.getText(),
	         stillWorks.isSelected()));
	    title.setText("");
	    employer.setText("");
	    jobStart.setValue(null);
	    jobEnd.setValue(null);
	    jobAdditional.setText("");
	    stillWorks.setSelected(false);
	}

	@FXML
	public void addEdu(){
		edu.add(new Education(school.getText(), getSchoolAddress(), (eduStart.getValue() == null)?"":eduStart.getValue().toString(),
				(eduEnd.getValue() == null)?"":eduEnd.getValue().toString(), degree.getSelectionModel().getSelectedItem(),
				 eduAdditional.getText(), stillGoes.isSelected()));
		school.setText("");
		schoolStreet.setText("");
		schoolApt.setText("");
		schoolCity.setText("");
		schoolState.getSelectionModel().selectFirst();
		schoolZip.setText("");
		eduStart.setValue(null);
		eduEnd.setValue(null);
		degree.getSelectionModel().selectFirst();
		eduAdditional.setText("");
		stillGoes.setSelected(false);
	}

	@FXML
	public void personalDone(){
		personal = new User(name.getText(), email.getText(), phone.getText(),
							getUserAddress(), userAdditional.getText());
		tabs.getSelectionModel().select(1);
		System.out.println(personal.toString());
	}

	@FXML
	public void workDone(){
	    addWork();
	    tabs.getSelectionModel().select(2);
	}

	@FXML
	public void eduDone(){
		addEdu();
		tabs.getSelectionModel().selectFirst();
	}

	@FXML
	public void testReader() {
		try {
			System.out.println(document.read());
		} catch (IOException e) {
			System.out.println("Failed to read file");
			e.printStackTrace();
		}
	}

}
