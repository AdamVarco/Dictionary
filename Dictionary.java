package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Dictionary {
	private final static String filePath = "C:\\Users\\adamv\\Desktop\\database\\database.txt";
	public static void main (String [] args) {
	int count = -1;
	Scanner scan = new Scanner(System.in);
	Scanner scan1 = new Scanner(System.in);
   Map<String, String> map = new TreeMap<String, String>();
	int userInput = -1;
	while(count !=0) {
		System.out.println("Please enter a choice");
		System.out.println("1 See the definitions from the Database");
		System.out.println("2 Enter a definition");
		System.out.println("3 See all the definitions in the dictionary");
		System.out.println("4 Search for a definition");
		System.out.println("5 Delete from dictionary");
		System.out.println("6 Edit a Definition in the dictionary");
		System.out.println("7 exit ");
		userInput = scan.nextInt();
		
		switch(userInput) {
		case 1:
			System.out.println("Here are all the defintions in the database");
			BufferedReader br = null;
			try {
				String line;
				br = new BufferedReader(new FileReader(filePath));
				System.out.println("word, definition");
				while ((line = br.readLine()) != null) {
					StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
					while (stringTokenizer.hasMoreElements()) {
						String word = stringTokenizer.nextElement().toString();
						String definition = stringTokenizer.nextElement().toString();
						System.out.println(word +"," + definition);
						map.put(word, definition);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			 }
			break;
		case 2:
           System.out.println("Please type a word to add");
		   String word = scan1.nextLine();
		    System.out.println("Please enter a defintion");
		    String definition = scan1.nextLine();
		    map.put(word, definition);
		    break;
		case 3:
			System.out.println("word, definition");
			for(Map.Entry entry: map.entrySet()) {
				System.out.println(entry.getKey() +"," + entry.getValue());
			}
			break;
		case 4:
			System.out.println("Press 1 to search by word, press 2 to search by definition");
			int choice = scan.nextInt();
			if(choice==1) {
				System.out.println("type in a word");
				String word1 = scan1.nextLine();
				if(map.containsKey(word1)) System.out.println(word1 + "," +map.get(word1));
				else System.out.println(word1 + " Is not in the database");
				 }
			else if(choice ==2) {
				System.out.println("Type in a definition");
				String def = scan1.nextLine();
				for(Map.Entry entry: map.entrySet()) {
					if(entry.getValue().toString().contains(def))
						System.out.println(entry.getKey() + "," + entry.getValue());
				}
			}
			else System.out.println("Invalid Entry, please try again");
			break;
		case 5:
			System.out.println("Please choose a word that you want to delete by entering the word");
			String cap = "";
			for(Map.Entry entry: map.entrySet()) {
				System.out.println(entry.getKey());
				}
			cap = scan1.nextLine();
			map.remove(cap);
			System.out.println(cap + " now removed from the dictionary");
			break;
		case 6:
			String string = "";
			String nd = "";
			System.out.println("Please choose a definition you want to edit by choosing the word");
			System.out.println("word, definition");
			for(Map.Entry entry: map.entrySet()) {
				System.out.println(entry.getKey() +"," + entry.getValue());
			}
			string = scan1.nextLine();
			System.out.println("Please Enter the definition you want to change it to");
			nd = scan1.nextLine();
			map.replace(string, nd);
			break;
		case 7:
			System.out.println("Good Bye");
			try {
				PrintWriter pw = new PrintWriter(new File(filePath));
				for(Map.Entry entry: map.entrySet()) {
					pw.println(entry.getKey() +"," + entry.getValue());
				}
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			count = 0;
			break;
			default:
				System.out.println("Please enter a valid choice");
			
		}
	  }
	}
	
}
