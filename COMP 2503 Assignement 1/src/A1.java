import java.util.*;

/*
 * @author Karl Semilla
 * @date January 26, 2018
 *  COMP 2503 - Assignment 1
 */

public class A1 {
	
	/*
	 * This method takes input from the user, as well as does most of the processing. 
	 * */
	public static void main (String[] args) {
		Scanner inp = new Scanner(System.in);
		ArrayList<Word> wordArr = new ArrayList<Word>();
		String word = "";
		Iterator<Word> itt = wordArr.iterator();
		int count = 0;
		int stopCount = 0;
		int uniqueWords = 0;
		int i = 0;
		int order = 0;
		String escape = "";
		
		System.out.print("Enter a string of letters: ");
		while(inp.hasNext() && escape != "exit") {
			word = inp.next();
			escape = word;
			if (escape.equalsIgnoreCase("exit")) {
				break;
			}
			word = word.trim().replace(",", "").replace(".", "").replace("'", "").replace("?","").toLowerCase();
			word = stop(word);
			
			if (word == "") {
				stopCount++;
			}
			else if (wordArr.isEmpty()) {
				wordArr.add(new Word(word, 1));
				}
			else {
				while (i < wordArr.size()){
					if(wordArr.get(i).getWord().equals(word)) {
						wordArr.get(i).incCount();
						}
					else if (i == wordArr.size() - 1) {
						wordArr.add(new Word(word));
						uniqueWords++;
						}
					
					i++;
				}
				i = 0;
			}
			count++;
		}
		i = 0;
		System.out.println("Total amount of words: " + count);
		System.out.println("Amount of unique words: " + uniqueWords);
		System.out.println("Amount of stop words: " + stopCount);
		System.out.println("10 most common words: ");
		i = 0;
		while(i < wordArr.size() && i < 10) {
			System.out.println(wordArr.get(i).toString());
			i++;
		}
		System.out.println("10 least common words: ");
		order = 0;
		while(i < wordArr.size()) {
			while(order < wordArr.size()) {
			wordArr.get(i).compareTo(wordArr.get(order));
			order++;
			}
			order = 0;
			i++;
		}
		
		i = 0;
		while(i < wordArr.size() && i < 10) {
			System.out.println(wordArr.get(i).toString());
			i++;
		}
		
		System.out.println("Results for all words: ");
		i = 0;
		while(i < wordArr.size()) {
			System.out.println(wordArr.get(i).toString());
			i++;
		}
		inp.close();
		//System.out.println(wordArr.get(0).toString());
	}
	
	/*
	 * This method puts the stop words into an array, take a string word from the main method to check
	 * and verify if the word is a stop word by passing over a blank string if true.
	 * */
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

		while(i < stopWords.size() && result == false) {
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