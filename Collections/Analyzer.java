import java.util.ArrayList;
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
		System.out.println("passing name of the file here: " + filename);
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

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

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
		Analyzer.readFile("reviews");
		
		
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
