package assignment3;

import java.util.ArrayList;

public class Node{
	ArrayList<String> list = new ArrayList<String>();	//this will hold the whole string array for each word
	boolean visited = false;
	String word;
	Node parent = null;
	public void setWord(String w){
		word = w;
		
	}
	public void add(){
		list.add(word);
	}

}
