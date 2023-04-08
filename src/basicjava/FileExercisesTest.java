package basicjava;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

public class FileExercisesTest {
	
	private void createFile(String filename, String text){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			PrintWriter output = new PrintWriter(writer);
			output.print(text);
			output.close();
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to (re)create file " + filename);
		}
	}
	
	@Test
	public void test_counting_zero() {
		String content = "Hello\nand\nwelcome\nTo an\nExercise";
		createFile("example.txt", content);
		int actual = 10;
		actual = FileExercises.counting("the");
		
		//Expected output
		int expected = 0;
		
		assertEquals("Test with 'example.txt' file that has no 'the' in it", expected, actual);
	}

	@Test
	public void test_counting_onlyWordIsThe() {
		String content = "the";
		createFile("example.txt", content);
		int actual = 0;
		actual = FileExercises.counting("THE");
		
		//Expected output
		int expected = 1;
		
		assertEquals("Test with 'example.txt' file that has only 'THE' in it", expected, actual);
	}

	@Test
	public void test_counting_upperAndLowerCaseThe() {
		String content = "The quick brown fox jumped over the jumped over the lazy dog";
		createFile("example.txt", content);
		int actual = 0;
		actual = FileExercises.counting("The");
		
		//Expected output
		int expected = 3;
		
		assertEquals("Test with 'example.txt' file that has mixed case 'the' in it", expected, actual);
	}

	@Test
	public void test_counting_sameWordRepeated() {
		String content = "one one one one one ONE ONE ONE One One One";
		createFile("example.txt", content);
		int actual = 0;
		actual = FileExercises.counting("one");
		
		//Expected output
		int expected = 11;
		
		assertEquals("Test with 'one' as word to count", expected, actual);
	}

	@Test
	public void test_toUpper_EmptyFile() throws IOException{
		createFile("test.txt","");
		FileExercises.toUpper("test.txt", "testOut.txt" );
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("testOut.txt"));
			String line = reader.readLine();
			assertNull("Reading from empty file should result in null as first read", line);
			reader.close();
		} catch (FileNotFoundException fnfe) {
			fail("Expected empty file to be created for output: " + fnfe.getMessage());
		} catch (IOException ioe) {
			fail("Unexpected IO exception during test: " + ioe.getMessage());
		}
		File f = new File("test.txt");
		f.delete();
		
	}

	@Test
	public void test_toUpper_OriginalAllLowerCase() throws IOException{
		createFile("test.txt","the quick fox\njumped over \nthe lazy dog.");
		FileExercises.toUpper("test.txt", "testOut.txt" );
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("testOut.txt"));

			assertEquals("Expected first line in output file to be THE QUICK FOX", "THE QUICK FOX", reader.readLine());
			assertEquals("Expected second line in output file to be JUMPED OVER ", "JUMPED OVER ", reader.readLine());
			assertEquals("Expected third line in encrypted file to be THE LAZY DOG.", "THE LAZY DOG.", reader.readLine());
			assertNull("After reading 3 lines, expected file to be empty and read should result in null", reader.readLine());
			reader.close();
		} catch (FileNotFoundException fnfe) {
			fail("Expected file to be created for output: " + fnfe.getMessage());
		} catch (IOException ioe) {
			fail("Unexpected IO exception during test: " + ioe.getMessage());
		}
		File f = new File("test.txt");
		f.delete();		
	}

	@Test
	public void test_topUpper_originalAllUPPERCase() throws IOException{
		createFile("test.txt","THE QUICK FOX\nJUMPED OVER \nTHE LAZY DOG.");
		FileExercises.toUpper("test.txt", "testOut.txt" );
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("testOut.txt"));

			assertEquals("Expected first line in output file to be THE QUICK FOX", "THE QUICK FOX", reader.readLine());
			assertEquals("Expected second line in output file to be JUMPED OVER ", "JUMPED OVER ", reader.readLine());
			assertEquals("Expected third line in encrypted file to be THE LAZY DOG.", "THE LAZY DOG.", reader.readLine());
			assertNull("After reading 3 lines, expected file to be empty and read should result in null", reader.readLine());
			reader.close();
		} catch (FileNotFoundException fnfe) {
			fail("Expected file to be created for output: " + fnfe.getMessage());
		} catch (IOException ioe) {
			fail("Unexpected IO exception during test: " + ioe.getMessage());
		}
		File f = new File("test.txt");
		f.delete();		
	}
}
