package basicjava;

import java.util.Arrays;

public class CCArrays {

	public static void replace(char[] charArray, char toReplace, char replaceWith) {
		// TODO Auto-generated method stub
		for(int i =0; i<charArray.length;i++ ) {
			if(charArray[i] ==Character.toUpperCase(toReplace) || charArray[i]==Character.toLowerCase(toReplace)) {
				charArray[i]=replaceWith;
			}
		}
	}

	public static void sortAlphabetic(String[] strArray) {
		// TODO Auto-generated method stub
		Arrays.sort(strArray, String::compareToIgnoreCase);
	}

}
