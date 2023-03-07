package application;

public class Grade {
	//attributes/data
	double value;
	double weight;
	int maxValue = 100;
	
	Grade(double gradeValue, int maxPossibleValue, double weightTowardsCourseGrade){
		value = gradeValue;
		maxValue = maxPossibleValue;
		weight = weightTowardsCourseGrade;
	}
	
	double getWeightedPercentageValue() {
		return value * 100 * weight / maxValue;
	}
	
	//actions 
	String setValue(String valueAsString) {
		
		String errorMessage= "";
		// assuming that the project is worth 50% towards the course grade
    	
    	
    	// Check that the user entered a numeric value
    	boolean validGrade = true;
    	int decimalCount = 0;
    	
    	for (char c : valueAsString.toCharArray()) {
    		// if any character is not a digit, set flag to false: is is not a number 
    		if (!Character.isDigit(c) && c != '.') {
    			validGrade = false;
    			errorMessage = "Don't include the character: " + c + "Grade should be a number. " ;
    			
    		}
    		if (c=='.') {
    			decimalCount++;
    		}
    	}
    	
    	// Check if there is more than 1 decimal point. If yes, set flag to false and display error message
        if (decimalCount > 1) {
            validGrade = false;
            return "Grade should be a number. Don't include multiple decimal points." ;
        }
    	
    	// Default project grade to 0. If valid number entered, convert user input to 
    	// floating point number.
    	
    	if (validGrade) {
    		  value = Double.parseDouble(valueAsString);
    	}
    	// Check if projectGrade is a valid percentage grade. If not, reset to default grade of 0.
    	if (value< 0 || value > maxValue) {
    		errorMessage = "Grade should be between 0% and 100%. Invalid project grade: " + value ;
		 		value = 0;
    	}
    	return errorMessage; 
	}

}
