package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GradeCalculatorController {


	@FXML
    private ChoiceBox<Integer> requiredcodingChallengesChoiceBox;
	
	@FXML
	private ChoiceBox<Integer> optionalcodingChallengesChoiceBox;

    @FXML
    private Slider quizSlider;

    @FXML
    private TextField projectGradeTextfield;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    Label projectErrorLabel;

    @FXML
    void calculateGrade(ActionEvent event) {
    	double courseGrade = 0.0;
    	
    	// assuming that the project is worth 50% towards the course grade
    	String projectGrade = projectGradeTextfield.getText();
    	courseGrade= courseGrade + Double.parseDouble(projectGrade) * 50/100;
    	System.out.println("Project grade entered: " + projectGrade +
    			" Course grade so far: " + courseGrade);
    	// assuming that the quizzes is worth 25% towards the course grade.
    	// assuming that quizzes are marked out of 10.
    	double quizGrade = quizSlider.getValue();
    	courseGrade += (quizGrade *100/10 )* .25;
    	System.out.println("Quiz grade entered: " + quizGrade +
    			" Course grade so far: " + courseGrade);
    	
    	// assuming that the coding challenges are worth 25% towards the course grade.
    	// assuming that there are 15 required coding challenges
    	int requiredcodingChallengesPassed = requiredcodingChallengesChoiceBox.getValue();
    	courseGrade += (requiredcodingChallengesPassed*15/15)* 1.25;
    	System.out.println("Coding challenges passed: " + requiredcodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	// assuming that there are 5 optional coding challenges.
    	int optionalcodingChallengesPassed = optionalcodingChallengesChoiceBox.getValue();
    	courseGrade += (optionalcodingChallengesPassed*5/5)* 1.25;
    	System.out.println("Coding challenges passed: " + optionalcodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	// Display	result of calculation to the user in the window
    	// Display result to two digits after decimal point
    	courseGradeLabel.setText(String.format("Your overall grade is: %.2f" , courseGrade));
    	
    	
    	
    }

}
