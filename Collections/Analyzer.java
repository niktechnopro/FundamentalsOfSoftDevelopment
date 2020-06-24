import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		/* IMPLEMENT THIS METHOD! */
		List<Sentence> sentences = new ArrayList<>(); 
		try {
//			BufferedReader reviews = new BufferedReader(new FileReader(filename));
			File reviews = new File(filename);
	        Scanner scnr = new Scanner(reviews);
	        while(scnr.hasNextLine()){
	            String line = scnr.nextLine();
	            //split line on score and text
	            int score = Integer.parseInt(line.substring(0, 2).trim());//converting to int
	            String text = line.substring(2).trim();
//	            System.out.println("Score: " + score + " text: " + text);
	            if(score > -2 && score < 2) {
	            	sentences.add(new Sentence(score, text));
	            }
	        }      			
		}catch(Exception ex) {
			System.out.println("Ooops: " + ex.getMessage());
		}
		return sentences; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		System.out.println(sentences.size());
		/* IMPLEMENT THIS METHOD! */
		//Set is implemented by HashSet
//		Set<Word> hash_Set = new HashSet<>();
		Set<Word> myWords = new HashSet<>();
		HashMap<String, Integer> myWordsKV = new HashMap<>();
		sentences.forEach(obj -> {
//			System.out.println(obj.getText());
			//option 1
			for(String word : obj.getText().toLowerCase().split("[\\p{Punct}\\s]+")) {//regex to split line by punctuation and white space
//				System.out.println(word);
				if(myWordsKV.containsKey(word)) {
					int count = myWordsKV.get(word);
					myWordsKV.put(word, count+1);	
				}else {
					myWordsKV.put(word, 1);
				}
			}
		});
		System.out.println(myWordsKV.size());
//		System.out.println(myWordsKV);
		
		
		//option 2 - in object
		sentences.forEach(obj -> {
			for(String word : obj.getText().toLowerCase().split("[\\p{Punct}\\s]+")) {//regex to split line by punctuation and white space
				Word myWord = new Word(word);
				myWord.increaseTotal(1);
				if(myWords.size() < 1) {
					myWords.add(myWord);
				}else {
					for(Word w : myWords) {
//						System.out.println(w);
						if(w.equals(myWord)) {
							w.increaseTotal(1);
						}
					}
					myWords.add(myWord);
				}
			}
		});
		myWords.forEach(o -> {
			System.out.println("name: " + o.getText() + " count: " + o.getCount() + " total: " + o.getTotal());
		});
		System.out.println(myWords.size());
		
//		return null; // this line is here only so this code will compile if you don't modify it
		return myWords;
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		
		return 0; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		List<Sentence> allSentences = Analyzer.readFile("reviews");//step 1
		Set<Word> setOfWordObjects = Analyzer.allWords(allSentences);//step 2
		
		
//		if (args.length == 0) {
//			System.out.println("Please specify the name of the input file");
//			System.exit(0);
//		}
//		String filename = args[0];
//		System.out.print("Please enter a sentence: ");
//		Scanner in = new Scanner(System.in);
//		String sentence = in.nextLine();
//		in.close();
//		List<Sentence> sentences = Analyzer.readFile(filename);
//		Set<Word> words = Analyzer.allWords(sentences);
//		Map<String, Double> wordScores = Analyzer.calculateScores(words);
//		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
//		System.out.println("The sentiment score is " + score);
	}
}
