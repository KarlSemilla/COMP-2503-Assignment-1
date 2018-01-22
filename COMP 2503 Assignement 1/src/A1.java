import java.util.*;

public class A1 {
	public static void main (String[] args) {
		Scanner inp = new Scanner(System.in);
		ArrayList<Word> wordArr = new ArrayList<Word>();
		String word = "";
		int count = 0;
		
		System.out.print("Enter a string of letters: ");
		
		while(inp.hasNext()) {
			word = inp.next();
			word = word.trim().replace(",", "").replace(".", "").replace("'", "");
			count++;
			System.out.println(word);
		}
		
		}
	
	public static void stop () {
		
	
	}
}