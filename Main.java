/* WORD LADDER Main.java  * EE422C Project 3 submission by 
 * Replace <...> with your actual data.
 * <Student1 Name>  * <Student1 EID>
 * <Student1 5-digit Unique No.>  
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2016  */

package assignment3;
import java.util.*; 
import java.io.*;

public class Main {
	// static variables and constants only here. 
	
	public static Set<String> Dictionary = makeDictionary();
	
	public static void main(String[] args) throws Exception { 
		Scanner kb; 								// input Scanner for commands
		PrintStream ps; 								// output file 
													// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0])); 
			ps = new PrintStream(new File(args[1])); 
			System.setOut(ps);							// redirect output to ps
		} 
		else {
			kb = new Scanner(System.in);   				// default from Stdin 
			ps = System.out; 							// default to Stdout
		} 
		parse(kb);
		initialize();
	// TODO methods to read in words, output ladder
	} 
	
	public static void initialize() {
		// initialize your static variables or constants here. 
		// We will call this method before running our JUNIT tests.  So call it
		// only once at the start of main.
	}
	
	/*	
	  	* @param keyboard Scanner connected to System.in  
	 	* @return ArrayList of 2 Strings containing start word and end word. 
	 	*  If command is /quit, return empty ArrayList.  
	 */ 
	public static ArrayList<String> parse(Scanner keyboard) {
		// TO DO 
		String [] array;
		ArrayList<String> arrayList = new ArrayList<String>();
		String s = keyboard.nextLine();
		if (s.equals("/quit")){
			return arrayList;
		}
		array = s.split("\s+");
		for(int i = 0; i < array.length; i++){
			arrayList.add(array[i]);							
		}
		
		return arrayList;
	} 
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		// Returned list should be ordered start to end.  Include start and end.
		// Return empty list if no ladder. 
		// TODO some code Set<String> dict = makeDictionary(); 
		// TODO more code
		return null; // replace this line later with real return
	}
	
	public static ArrayList<String> getWordLadderBFS(String start, String end) {
		// TODO some code 
		Queue q = null;
		Node n = new Node();
		q.add(n);
		String word = null;
		Set<String> dict = makeDictionary();
		// something something fill queue
		while(!q.isEmpty()){
			// more somethings
			if(word.equals(end)){
				//
			}
		}
		// TODO more code
		return null; // replace this line later with real return
	}   
	
	public static Set<String>  makeDictionary () { 
		Set<String> words = new HashSet<String>();
		Scanner infile = null; 
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!"); 
			e.printStackTrace(); 
			System.exit(1);
		} while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		} 
		return words;
	} 
	
	public static void printLadder(ArrayList<String> ladder) { 
		int length = ladder.size();
		if (length == 0)
			System.out.println("no word ladder can be found between" + first + " and " + last + ".");
		String first = ladder.get(0);
		String last = ladder.get(length-1);
		System.out.println("a " + length + "-wrung word ladder exists between " + first + " and " + last + ".");
		for (int i=0; i<length; i++) {
			System.out.println(ladder.get(i));
		}
	}
	
	// TODO 
	// Other private static methods here
	
	public static boolean neighbors(String s, String t){
		int counter = 0;
		boolean neighbors;
		if(s.length() != t.length()){
			//throw error
		}
		for(int i = 0; i < 5; i++){
			if(s.charAt(i) != t.charAt(i)){
				counter++;
			}
		}
		if(counter == 1){
			neighbors = true;
			return neighbors;
		}
		else{
			neighbors = false;
			return neighbors;
		}
	}
}
