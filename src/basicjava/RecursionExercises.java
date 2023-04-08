package basicjava;

import java.util.ArrayList;


public class RecursionExercises {

	public static int countDigits(int i) {
		if (i < 0) {
            i = -i; 
        }
        if (i < 10) {
            return 1; 
        } else {
            return 1 + countDigits(i / 10); 
        }
	}

	public static int addDigits(int i) {
		 if (i < 10) {
	            return i; 
	        } else {
	            return i % 10 + addDigits(i / 10); 
	        }
	}
	
	public static int sum(int sumFrom,int sumTo) {
		if (sumFrom < 0 || sumTo < 0 || sumTo < sumFrom) {
            return 0;
        } else if (sumFrom == sumTo) {
            return sumFrom;
        } else {
            return sumFrom + sum(sumFrom + 1, sumTo);
        }
	}
	
	public static int sumEvenNumbers(int i) {
		if (i < 0) { 
	        return 0;
	    } else if (i % 2 == 0) { 
	        return i + sumEvenNumbers(i - 2);
	    } else { 
	        return sumEvenNumbers(i - 1);
	    }
	}
	
	public static int sumOfMultiple(ArrayList<Integer> list) {
		if (list == null) {
	        return 0;
	    }
		if (list.size() == 0 ) { 
	        return 0;
	    } else {
	        int num = list.remove(0);
	        if (num % 5 == 0) { 
	            return num + sumOfMultiple(list);
	        } else { 
	            return sumOfMultiple(list);
	        }
	    }
	}
	
	public static int countVowels(String s) {
		if(s==null) {
			return 0;
		}
		if (s=="") {
            return 0;
        }
        char firstChar = Character.toLowerCase(s.charAt(0));
        int count = countVowels(s.substring(1));
        if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
            count++;
        }
        return count;
		
	}
	
	public static String removeVowels(String s) {
		if(s==null) {
			return null;
		}
		if (s=="") {
            return "";
        }
        char firstChar = s.charAt(0);
        String rest = removeVowels(s.substring(1));
        if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u'
                || firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U') {
            return rest;
        }
        return firstChar + rest;
	}
	
}
