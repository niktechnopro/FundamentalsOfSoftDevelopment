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
				i = line.indexOf(',');
				actor.setName(line.substring(0, i));
				for(String mov: line.substring(i+1).split(",")) {
					Movie movie = new Movie();//creating new object for Movies
					movie.setName(mov);
					actor.setMovie(movie);
					myMovieDatabase.setMovieList(movie);
				}
				myMovieDatabase.setActorList(actor);
//				System.out.println(actor.getName()); //(line.substring(0, i), line.substring(i+1));
			}
			buffReaderMovies.close();
			
			//now we are going to read ratings;
			BufferedReader buffReaderRatings = new BufferedReader(new FileReader("ratings"));
			i = 0;
			line = "";
			while((line = buffReaderRatings.readLine()) != null) {
				if(!line.contentEquals("movie_name	critic_score")){//removes description
					String[] partedLine = line.split("(?<=\\D)(?=\\d)");
					System.out.println(partedLine[0]);
					partedLine = null;
				}
			}
			buffReaderRatings.close();
			
//			for (int a = 0; myMovieDatabase.getMovieList().size() > a; a++) {
//				System.out.println(myMovieDatabase.getMovieList().get(a).getName());
//			}
//			
//			
//			for (int b = 0; myMovieDatabase.getActorList().size() > b; b++) {
//				System.out.println(myMovieDatabase.getActorList().get(b).getName());
//			}
			
			
		}catch(IOException ex){
			System.out.println("some exceptions here " + ex.getMessage() );
		}
		
		System.out.println(myMovieDatabase.getMovieList());
		System.out.println(myMovieDatabase.getActorList());

	}

}
