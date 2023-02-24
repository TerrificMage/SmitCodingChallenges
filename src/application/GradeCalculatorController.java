package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;import javafx.stage.Stage;

public class GradeCalculatorController {
	
	Stage applicationStage;
	

	@FXML
    private ChoiceBox<Integer> requiredcodingChallengesChoiceBox;
	
	@FXML
	private ChoiceBox<Integer> optionalcodingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> RequiredquizzesChoiceBox;
    
    @FXML
    private ChoiceBox<Integer> OptionalquizzesChoiceBox;

    @FXML
    private TextField projectGradeTextfield;
    
    @FXML
    private Button ReqcalculateGradeButton;
    
    @FXML
    private Button OptcalculateGradeButton;
    
    @FXML
    private Label courseGradeLabel;
    
    
    @FXML
    private Label ReqQuizAvg;
    
    @FXML
    private Label OptQuizAvG;
    
    @FXML
    Label projectErrorLabel;
    
    @FXML
    private Label projectGradeErrorLabel;
    
    /**
     * checks if the value provided is a valid project grade. A project grade must be numeric and 
     * a percentage (between 0 to 100). If valid, the equivalent double is returne, if not, this method returns zero. 	
     * @param valueEntered the value entered as the project grade 
     * @return the double value of valueEntered if it is numeric and a valid percentage and 0 otherwise. 
     */
    
    
    double getProjectGrade(String valueEntered) {
    	// assuming that the project is worth 50% towards the course grade
    	String projectValueEntered = projectGradeTextfield.getText();
    	
    	// Check that the user entered a numeric value
    	boolean validProjectGrade = true;
    	int decimalCount = 0;
    	
    	for (char c : projectValueEntered.toCharArray()) {
    		// if any character is not a digit, set flag to false: is is not a number 
    		if (!Character.isDigit(c) && c != '.') {
    			validProjectGrade = false;
    			projectGradeErrorLabel.setText("Don't include the character: " + c + "Project grade should be number. " );
    			break;
    		}
    		if (c=='.') {
    			decimalCount++;
    		}
    	}
    	
    	// Check if there is more than 1 decimal point. If yes, set flag to false and display error message
        if (decimalCount > 1) {
            validProjectGrade = false;
            projectGradeErrorLabel.setText("Project grade should be a number. Don't include multiple decimal points.");
        }
    	
    	// Default project grade to 0. If valid number entered, convert user input to 
    	// floating point number.
    	double projectGrade = 0;
    	if (validProjectGrade) {
    		  projectGrade = Double.parseDouble(projectValueEntered);
    	}
    	// Check if projectGrade is a valid percentage grade. If not, reset to default grade of 0.
    	if (projectGrade< 0 || projectGrade > 100) {
		 	projectGradeErrorLabel.setText("Project Grade should be between 0% and 100%. Invalid project grade: " + projectGrade);
		 		projectGrade = 0;
    	}
    	return projectGrade;
    }
    
    /**
     * event using inputs from user to calculate average quiz grade for required quizzes
     * choicebox indicates number of quizzes completed/being inputed
     * @param Action event enterQuizGradeEvent via button changes scene
     * second scene allows required quiz grade input via textfield and average calculation
     * average displayed via label on main scene
     */
    
    double averageReqQuizGrade = 0.0;
    
    void calculateAverageQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextfields) {
    	applicationStage.setScene(mainScene);
    	//reset to zero
    	averageReqQuizGrade = 0.0;
    	for (TextField quizGradeTextfield : quizGradeTextfields) {
    		averageReqQuizGrade += Double.parseDouble(quizGradeTextfield.getText());
    	}
    	averageReqQuizGrade = (averageReqQuizGrade / 15); 
    	ReqQuizAvg.setText(String.format("Average (out of 10): %.2f ", averageReqQuizGrade));
    }
    
    @FXML
    void getReqQuizGrades(ActionEvent enterQuizGradeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberOfQuizzes = RequiredquizzesChoiceBox.getValue();
    	int rowsCreated = 0;
    	VBox ReqquizGradeContainer = new VBox();
    	//title label
    	Label reqTitle = new Label("Required Quizzes");
    	ReqquizGradeContainer.getChildren().add(reqTitle);
    	
    	//Creating a list to enter  quiz grades
    	ArrayList<TextField> quizGradeTextfields = new ArrayList<TextField>();
    	while (rowsCreated < numberOfQuizzes) {
    	
    	HBox rowContainer = new HBox();
    	Label quizGradeLabel = new Label("Quiz grade");
    	TextField quizGradeTextfield = new TextField();
    	quizGradeTextfields.add(quizGradeTextfield);
    	
    	rowContainer.getChildren().addAll(quizGradeLabel,quizGradeTextfield);
    	rowsCreated++;
    	
    	ReqquizGradeContainer.getChildren().addAll(rowContainer);
    }
    	Button ReqdoneButton = new Button("Done");
    	ReqdoneButton.setOnAction(doneEvent -> calculateAverageQuizGrade(mainScene, quizGradeTextfields));
    	ReqquizGradeContainer.getChildren().add(ReqdoneButton);
    	
    	Scene ReqquizGradeScene = new Scene(ReqquizGradeContainer);
    	applicationStage.setScene(ReqquizGradeScene);
    }
    
    /**
     * event using inputs from user to calculate average quiz grade for optional quizzes
     * choicebox indicates number of quizzes completed/being inputed
     * @param Action event enteroptQuizGradeEvent via button changes scene
     * second scene allows optional quiz grade input via textfield and average calculation
     * average displayed via label on main scene
     */
    
    double averageOptQuizGrade = 0.0;
    
    void calculateOptAverageQuizGrade(Scene mainScene, ArrayList<TextField> optquizGradeTextfields) {
    	applicationStage.setScene(mainScene);
    	averageOptQuizGrade = 0.0;
    	for (TextField optquizGradeTextfield : optquizGradeTextfields) {
    	averageOptQuizGrade += Double.parseDouble(optquizGradeTextfield.getText());
    	}
    	averageOptQuizGrade = (averageOptQuizGrade / 5);
    	OptQuizAvG.setText(String.format("Average(out of 10): %.2f ", averageOptQuizGrade));
    }
    
    @FXML
    void getOptQuizGrades(ActionEvent enteroptQuizGradeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	int numberOfOptQuizzes = OptionalquizzesChoiceBox.getValue();
    	int rowscreated = 0;
    	VBox OptquizGradeContainer = new VBox();
    	//Title Label
    	Label optTitle = new Label("Optional Quizzes");
    	OptquizGradeContainer.getChildren().add(optTitle);
    	
    	ArrayList<TextField> optquizGradeTextfields =  new ArrayList<TextField>();
    	while (rowscreated < numberOfOptQuizzes) {
    	
    	HBox rowcontainer = new HBox();
    	Label optquizGradeLabel = new Label("Quiz grade");
    	TextField optquizGradeTextfield = new TextField();
    	optquizGradeTextfields.add(optquizGradeTextfield);
    	
    	rowcontainer.getChildren().addAll(optquizGradeLabel,optquizGradeTextfield);
    	rowscreated++;
    	
    	OptquizGradeContainer.getChildren().addAll(rowcontainer);
    	}
    	Button OptdoneButton = new Button("Done");
    	OptdoneButton.setOnAction(optdoneEvent -> calculateOptAverageQuizGrade(mainScene, optquizGradeTextfields));
    	OptquizGradeContainer.getChildren().add(OptdoneButton);
    	
    	Scene OptquizGradesScene = new Scene(OptquizGradeContainer);
    	applicationStage.setScene(OptquizGradesScene);
    }
    
    

    @FXML
    /**
     * Calculates the overall course grade based on the values entered for project grade, quiz grade, 
     * required coding challenges, and optional coding challenges. 
     *
     * @param event the event triggered when the calculate grade button is clicked. 
     */
    void calculateGrade(ActionEvent event) {
    	projectGradeErrorLabel.setText("");
    	double courseGrade = 0.0;
    	
    	// assuming that the project is worth 50% towards the course grade
    	String projectValueEntered = projectGradeTextfield.getText();
    	
    	
    	// Check if user entered a percentage grade. If not, display error message and don't include project grade in course grade
    	
    	double projectGrade = getProjectGrade(projectValueEntered);
    	courseGrade= courseGrade + projectGrade * 50/100;
    	System.out.println("Project grade entered: " + projectGrade +
    			" Course grade so far: " + courseGrade);
    	
    	 double ReqQuizgrade = (((averageReqQuizGrade)*(10))*0.1875);
    	 double OptQuizgrade = (((averageOptQuizGrade)*(10))*0.0625);
    	 courseGrade = courseGrade + (((ReqQuizgrade)+(OptQuizgrade))); 
    	 System.out.println("Required Quiz grade: " + averageReqQuizGrade + "Optional Quizzes Grade: " + averageOptQuizGrade + "Course grade so far:" + courseGrade);
    	
    	 //trying to add CCs so the calculation is 1.25% each passed CC
    	 
    	 int requiredcodingChallengesPassed = requiredcodingChallengesChoiceBox.getValue();    	
    	 int optionalcodingChallengesPassed = optionalcodingChallengesChoiceBox.getValue();
    	 int TotalcodingChallengesPassed = requiredcodingChallengesPassed + optionalcodingChallengesPassed ;
    	 courseGrade = courseGrade + (TotalcodingChallengesPassed*100/22)*0.25;
    	 
    
    	
    	System.out.println("Required Coding challenges passed: " + requiredcodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	System.out.println("Optional Coding challenges passed: " + optionalcodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	
    	
    	// Display	result of calculation to the user in the window
    	// Display result to two digits after decimal point
    	courseGradeLabel.setText(String.format("Your overall grade is: %.2f" , courseGrade));
    	
    	
    	
    }

}
