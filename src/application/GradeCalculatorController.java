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
    	double averageReqQuizGrade = 0.0;
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
    	double averageOptQuizGrade = 0.0;
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
    	Grade projectGrade = new Grade();
    	projectGrade.setValue(projectValueEntered);
    	projectGrade.weight = .5;
    	projectGrade.maxValue = 100;
    	
    	Grade ReqQuizGrade = new Grade(averageReqQuizGrade , 10 , .1875);
    	Grade OptQuizGrade = new Grade(averageOptQuizGrade, 10 , .0625);
    	
    	courseGrade= courseGrade + projectGrade.getWeightedPercentageValue();
    	System.out.println("Project grade entered: " + projectGrade +
    			" Course grade so far: " + courseGrade);
    	
    	double ReqQuizgrade = (((averageReqQuizGrade)*(10))*0.1875);
 	    double OptQuizgrade = (((averageOptQuizGrade)*(10))*0.0625);
 	   courseGrade = courseGrade + (((ReqQuizgrade)+(OptQuizgrade))); 
 	   System.out.println("Required Quiz grade: " + averageReqQuizGrade + "Optional Quizzes Grade: " + averageOptQuizGrade + "Course grade so far:" + courseGrade);
    	
     	
     	
     	int requiredcodingChallengesPassed = requiredcodingChallengesChoiceBox.getValue();    	
	    int optionalcodingChallengesPassed = optionalcodingChallengesChoiceBox.getValue();
	    int TotalcodingChallengesPassed = requiredcodingChallengesPassed + optionalcodingChallengesPassed ;
	    courseGrade = courseGrade + (TotalcodingChallengesPassed*100/20)*0.25;
    	
    	
		System.out.println("Required Coding challenges passed: " + requiredcodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	System.out.println("Optional Coding challenges passed: " + optionalcodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	
    	
    	// Display	result of calculation to the user in the window
    	// Display result to two digits after decimal point
    	courseGradeLabel.setText(String.format("Your overall grade is: %.2f" , courseGrade));
    	    	
    	
    	
    }

}
