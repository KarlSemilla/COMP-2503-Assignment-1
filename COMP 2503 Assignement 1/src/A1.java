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
			word = word.trim().replace(",", "").replace(".", "").replace("'", "").toLowerCase();
			word = stop(word);
			wordArr.add(new Word(word));
			//System.out.println(word);
			
			System.out.println("" + wordArr.get(count).toString());
			count++;
		}
		//System.out.println(wordArr.get(0).toString());
		}
	
	public static String stop (String word) {
		ArrayList<String> stopWords = new ArrayList<String>();
		String actual = "";
		int i = 0;
		boolean result = false;
		String stop;
		stop = "a, about, all, am, an, and, any, are, as, at, be,\r\n" + 
				"been, but, by, can, cannot, could, did, do, does,\r\n" + 
				"else, for, from, get, got, had, has, have, he, her,\r\n" + 
				"hers, him, his, how, i, if, in, into, is, it, its, like,\r\n" + 
				"more, me, my, no, now, not, of, on, one, or, our, out,\r\n" + 
				"said, say, says, she, so, some, than, that, the, their,\r\n" + 
				"them, then, there, these, they, this, to, too, us, upon,\r\n" + 
				"was, we, were, what, with, when, where, which, while, who,\r\n" + 
				"whom, why, will, you, your";
		Collections.addAll(stopWords, stop.replace(",","").split(" "));

		while(i < stopWords.size() && result != true ) {
			if(stopWords.get(i).equals(word)) {
				actual = "";
				result = true;
			}
			else 
				actual = word;
			i++;
		}
		return actual;
	}
}