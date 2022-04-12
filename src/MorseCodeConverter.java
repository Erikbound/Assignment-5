import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	
	public static String convertToEnglish(String code) {
		String result = ""; //The String getting built one at a time
		MorseCodeTree tree;
		
		Scanner scan = new Scanner(code);
		
		while(scan.hasNext()) {
			String next = scan.next();
				
			tree = new MorseCodeTree(next); //Create the tree
			result += tree.fetch(next); //Get the result
		}
		
		scan.close();
		return result;
	}

	public static String convertToEnglish(File file) throws FileNotFoundException{
		Scanner scan = new Scanner(file);
		MorseCodeTree tree;
		String result = ""; //The String getting built one at a time
		
		while(scan.hasNext()) {
			String next = scan.next();
				
			tree = new MorseCodeTree(next); //Create the tree
			result += tree.fetch(next); //Get the result
		}
		
		scan.close();
		return result;
	}
	
	public static String printTree() {
		String result = "";
		MorseCodeTree tree = new MorseCodeTree();
		
		ArrayList<String> list = tree.toArrayList();
		
		for(int i = 0; i< list.size(); i++) {
			result += list.get(i) + " ";
		}
		result = result.substring(0, result.length()-1);
	
		return result;
	}
}
