package controllers;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resume.Education;
import resume.*;
import resume.Skills;
import resume.User;
import resume.Work;
import resumeViewer.ResumeViewer;

public class ChooseLayoutController {
	@FXML
	Button chosen;
	@FXML
	ImageView layout1;
	@FXML
	ImageView layout2;
	@FXML
	ImageView layout3;

	User personal;
	ArrayList<Work> work = new ArrayList<Work>();
	ArrayList<Education> edu = new ArrayList<Education>();
	Skills skills;
	private boolean layout1Picked;
	private boolean layout2Picked;
	private boolean layout3Picked;

	@FXML
	public void initialize(){}

	// get rid of later. Just here bc database not yet implemented
	@FXML
	public void importVariables(ResumeAddController r){
		this.personal = r.personal;
		this.work = r.work;
		this.edu = r.edu;
		this.skills = r.skills;
	}

	@FXML
	public void choose(){
		parser1Call();
	    getSelected();
	    System.out.println("Calling view");
	    callView();
	}

	@FXML
	void pickOne() {
	    layout1Picked = true;
	    layout2Picked = false;
	    layout3Picked = false;
	}

	@FXML
	void pickTwo() {
	    layout1Picked = false;
	    layout2Picked = true;
	    layout3Picked = false;
	}

	@FXML
	void pickThree() {
	    layout1Picked = false;
	    layout2Picked = false;
	    layout3Picked = true;
	}

	private void getSelected() {
	    if (layout1Picked) {
	      parser1Call();
	    }
	    if (layout2Picked) {
	      parser2Call();
	    }
	    if (layout3Picked) {
	      parser3Call();
	    }
	}

	public void callView() {
		ResumeViewer myViewer = new ResumeViewer();
		System.out.println("Displaying content");
		myViewer.DisplayContentsOf("../HTML.html");

	}

	//First parser that can be called
	public void parser1Call() {
		Parser parser = new Parser();
		parser.initialize();
		try {
			parser.parsePersonal(personal);
			for (int i = 0; i < work.size(); i++) {
				parser.parseWork(work.get(i));
			}
			for (int e = 0; e < edu.size(); e++) {
				parser.parseEducation(edu.get(e));
			}
			parser.parseSkill(skills);

		} catch (Exception exc) {
			error("Are you sure you're done? You haven't entered any information.");
		}
		parser.finalize();
	}

	//Second parser that can be called
	public void parser2Call() {
		Parser2 parser = new Parser2();
		parser.initialize();
		try {
			parser.parsePersonal(personal);
			parser.parseSkills(skills);
			for (int i = 0; i < work.size(); i++) {
				parser.parseWork(work.get(i));
			}
			for (int e = 0; e < edu.size(); e++) {
				parser.parseEducation(edu.get(e));
			}

		} catch (Exception exc) {
			error("Are you sure you're done? You haven't entered any information.");
		}
		parser.finalize();

	}

	 //Third parser that can be called

	  public void parser3Call() {
	    Parser3 parser = new Parser3();
	    parser.initialize();
	    try {
		      parser.parsePersonal(personal);
		      parser.parseSkills(skills);
		      parser.openWork();
		      for (int i = 0; i < work.size(); i++) {
		        parser.parseWork(work.get(i));
		      }
		      parser.closeWork();
		      parser.openEdu();
		      for (int e = 0; e < edu.size(); e++) {
		        parser.parseEducation(edu.get(e));
		      }
		      parser.closeEdu();
	    } catch (Exception exc) {
	    	error("Are you sure you're done? You haven't entered any information.");
	    }
	    parser.finalize();
	    }


	public void error(String e) {
		Alert r = new Alert(AlertType.NONE, e , ButtonType.OK);
		r.setTitle("ERROR");
		r.showAndWait();
	}
}
