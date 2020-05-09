import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		//create new instance of Movie Database
		MovieDatabase myMovieDatabase = new MovieDatabase();
		
		//read info from files
		try {
			BufferedReader buffReaderMovies = new BufferedReader(new FileReader("movies"));
			String line;
			int i;
			while((line = buffReaderMovies.readLine()) != null) {
				//on each iteration I need to create and object Actor.
				Actor actor = new Actor();
				Movie movie = new Movie();
				i = line.indexOf(',');
//				actor.setName(line.substring(0, i));
//				System.out.println(actor.getName()); (line.substring(0, i), line.substring(i+1));
				for(String mov: line.substring(i+1).split(",")) {
					movie.setName(mov);
					actor.setMovie(movie);
					myMovieDatabase.setMovieList(movie);
				}
				myMovieDatabase.setActorList(actor);
			}
			buffReaderMovies.close();
			
			BufferedReader buffReaderRatings = new BufferedReader(new FileReader("ratings"));
			
			buffReaderRatings.close();
		}catch(IOException ex){
			System.out.println("some exceptions here " + ex.getMessage() );
		}
		
		System.out.println(myMovieDatabase.getMovieList());
		System.out.println(myMovieDatabase.getActorList());

	}

}
