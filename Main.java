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
import java.util.Collections;

public class Main {
	// static variables and constants only here. 
	public static Set<String> dictionary = makeDictionary();
	
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
	//parse(kb);
	ArrayList<String> x = getWordLadderBFS("MONEY", "STONE");
	System.out.println(x);
	printLadder(x);
	initialize();
	// TODO methods to read in words, output ladder
	} 
	public static void initialize() {
		// initialize your static variables or constants here. 
		// We will call this method before running our JUNIT tests.  So call it
		// only once at the start of main.
	}
	/**	
	  	* @param keyboard Scanner connected to System.in  
	 	* @return ArrayList of 2 Strings containing start word and end word. 
	 	*  If command is /quit, return empty ArrayList.  
	 */ 
	public static ArrayList<String> parse(Scanner keyboard) {
		// TO DO 
		String [] array;
		ArrayList<String> arrayList = new ArrayList<String>();
		String s = keyboard.nextLine();
		if(s.equals("/quit")){
			//QUIT
		}
		array = s.split("\\s+");
		for(int i = 0; i < array.length; i++){
			arrayList.add(array[i]);							
		}
		
		return arrayList;
	} public static ArrayList<String> getWordLadderDFS(String start, String end){	
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> ladder = DFShelper(start, end, list, visited);
		return ladder;
	
		// Returned list should be ordered start to end.  Include start and end.
		// Return empty list if no ladder. 
		// TODO some code Set<String> dict = makeDictionary(); 
		// TODO more code
		//return null; // replace this line later with real return
	}
	
	public static ArrayList<String> DFShelper(String start, String end, ArrayList<String> list, ArrayList<String> visited) {
		Node n = new Node();
		ArrayList<Node> neighbor = new ArrayList<Node>();
		if(n == null){
			return list;		
		}
		visited.add(start);
		n.visited = true;
		if(start.equals(end)){
			return list;
		}
		else{
			neighbor = neighbors(start);
			for(int i = 0; i < neighbor.size(); i++){
				list = DFShelper(neighbor.get(i).word, end, list, visited);
				if(neighbor.equals(end)){
					return list;
				}
			}
			return list;
		}
	}
	 public static ArrayList<String> getWordLadderBFS(String start, String end) {
		// TODO some code
		ArrayList<Node> queue = new ArrayList<Node>();
		ArrayList<String> list = new ArrayList<String>();
		Node n = new Node();
		queue.add(n);
		n.setWord(start);
		//n.visited = true
		ArrayList<Node> visited = new ArrayList<Node>();
		Set<String> dict = makeDictionary();
		// something something fill queue
		while(!queue.isEmpty()){
			// more somethings
			Node temp = queue.remove(0);
			if(temp.word.equals(end)){
				System.out.println("YES");
				while(temp.parent != null){
					list.add(temp.word);
					temp = temp.parent;
				}
				Collections.reverse(list);
				list.add(0, start);
				return list;
			}
			//if(temp.visited == true){
						//check on this(it should discard head)
			//}
			else{
				temp.visited = true;
				dict.remove(temp.word);
				visited.add(temp);
				ArrayList<Node> neighbor = neighbors(temp.word, dict);
				for(int i = 0; i < neighbor.size(); i++){		//for each neighbor
					if(neighbor.get(i).visited == false){
						neighbor.get(i).parent = temp;
						if(temp.parent != null){
							
						}
							queue.add(neighbor.get(i));			// neighbor
							neighbor.get(i).add();			//add the neighbor word to the list 
							dict.remove(neighbor.get(i).word);
						
					}
				}
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
		// TODO 
			int length = ladder.size();
			int wrung = length - 2;												//to ignore the first and last word
			String first = ladder.get(0).toLowerCase();
			String last = ladder.get(length-1).toLowerCase();
			if (length == 0){
				System.out.println("no word ladder can be found between" + first + " and " + last + ".");
			}
			System.out.println("a " + wrung + "-wrung word ladder exists between " + first + " and " + last + ".");
			for (int i=0; i<length; i++) {
				ladder.get(i).toLowerCase();
				System.out.println(ladder.get(i).toLowerCase());
			}
		}
		// Other private static methods here
		public static ArrayList<Node> neighbors(String s, Set<String> dict){
			char[] word = s.toCharArray();
			char temp;
			ArrayList<Node> wordNeighbors = new ArrayList<Node>();
			for(int i=0; i<word.length; i++) {
				for(char letter='A'; letter<='Z'; letter++) {
					temp = word[i];
					if (word[i] != letter){
						word[i] = letter;
					}
					String newWord = new String(word);
					Node dictWord = new Node();
					dictWord.word = newWord;
					if (dict.contains(dictWord.word) && (!(newWord.equals(s)))){
						wordNeighbors.add(dictWord);
					}
					word[i] = temp;
				}
			}
			return wordNeighbors;
		}
}

