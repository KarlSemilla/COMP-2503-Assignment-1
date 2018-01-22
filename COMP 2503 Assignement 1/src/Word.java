import java.util.*;
public class Word implements Comparable<Word> {
	private String word;
	private int count;
	
	public Word() {
		
	}
	
	public Word(String entry) {
		word = entry;
	}
	
	public String getWord()
	{
		return word;
	}

	public void setWord(String word)
	{
		this.word = word;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}
	
	public int compareTo(Word other) {
		if(count < other.count) {
			return -1;
		}
		if(count > other.count) {
			return 1;
		}
		else
			return 0;
	}
	public String toString() {
		return word;
	}
}
