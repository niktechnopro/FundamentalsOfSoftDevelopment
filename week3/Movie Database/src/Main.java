import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
	public static ArrayList<String> listOfmovies = new ArrayList<>();
	public static HashMap<String, String> actorMovie = new HashMap<>();

	public static void main(String[] args) {
		//create new instance of Movie Database
		MovieDatabase myMovieDatabase = new MovieDatabase();
		
		//read info from file
		try {
			BufferedReader bufReader = new BufferedReader(new FileReader("movies"));
			String line;
			int i;
			while((line = bufReader.readLine()) != null) {
				i = line.indexOf(',');
				actorMovie.put(line.substring(0, i), line.substring(i+1));
				listOfmovies.add(line.substring(i+1));
			}
			bufReader.close();
		}catch(IOException ex){
			System.out.println("some exceptions here " + ex.getMessage() );
		}
		
		//now that we have hash map - let's
		actorMovie.forEach((k,v) -> {
			System.out.println("Key: " + k + "    Value: " + v);
		});
		System.out.println(listOfmovies.get(0));
	}

}
