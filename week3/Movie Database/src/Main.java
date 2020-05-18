import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		//create new instance of Movie Database
		MovieDatabase myMovieDatabase = new MovieDatabase();
		//another way - let's start with rating first
		try{
			BufferedReader buffReaderMovies = new BufferedReader(new FileReader("movies"));
			String line;
			ArrayList<String> allMovies = new ArrayList<>();
			ArrayList<String> allActors = new ArrayList<>();
			ArrayList<String> movieObjectsHelper = new ArrayList<>();
			ArrayList<Movie> movieObjects = new ArrayList<>();
			int i;
			//cross reference each movie and add array of actors that was in it
			HashMap<String, ArrayList<String>> movieActors = new HashMap<>();
			//actor to movies reference
			HashMap<String, ArrayList<Movie>> actorMovie = new HashMap<>();
			while((line = buffReaderMovies.readLine()) != null) {
				//the following logic is for 
				i = line.indexOf(',');//index of first ","
				ArrayList<Movie> movies = new ArrayList<>();
				for (String movie : line.substring(i+1).split(",")) {//making an ArrayList of Movie objects
					//make sure this is the same Object
					if (!movieObjectsHelper.contains(movie.trim())) {
						movieObjectsHelper.add(movie.trim());
						Movie m = new Movie();
						m.setName(movie.trim());
						movieObjects.add(m);
						movies.add(m);
					}else {
						//find it in array and add to movies
						for(Movie mo : movieObjects) {
							if(mo.getName().equals(movie.trim())) {
								movies.add(mo);
							}
						}
					}
				}
				if (line.substring(0,i).equals("Sidney Poitier")) {
					System.out.println("this hits" + movies);
				}
				actorMovie.put(line.substring(0,i), movies);
				//cross reference movie to actors - movie is a key, and array of actors - value
				ArrayList<String> movieActor = new ArrayList<>();
				allActors.add(line.substring(0,i).trim());
				movieActor.add(line.substring(0,i).trim());
				for(String f : line.substring(i+1).split(",")){
					if(allMovies.contains(f.trim())){//if movie is already in HashMap - do not add
						for(int n = 0; n < movieActors.get(f.trim()).size(); n++) {
							if(!movieActor.contains(movieActors.get(f.trim()).get(n))) {
								movieActor.add(movieActors.get(f.trim()).get(n));
							}
						}
						movieActors.replace(f.trim(), movieActor);
					} else {
						allMovies.add(f.trim());
						movieActors.put(f.trim(), movieActor);
					}
				}
			}
			buffReaderMovies.close();
			
			//next - read the ratings and then if movie is not in this list - populated it with 5
			BufferedReader buffReaderRating = new BufferedReader(new FileReader("ratings"));
			line = null;
			HashMap<String, String> ratingsMap = new HashMap<>();
			while((line = buffReaderRating.readLine()) != null) {
				if(!line.contentEquals("movie_name	critic_score")){//removes description
					ratingsMap.put(line.split("(?<=\\D)(?=\\d)")[0].trim(), line.split("(?<=\\D)(?=\\d)")[1].trim());
				}
			}
			buffReaderRating.close();
			
			//next - iterate through allMovies arrays - and add to ratingsMap what is missing;
			for (int k = 0; allMovies.size() > k; k++) {
				if(!ratingsMap.containsKey(allMovies.get(k))){
					ratingsMap.put(allMovies.get(k), String.valueOf(63));
					
				}
			}
//			System.out.println(ratingsMap);
			
			//next - create Actor Objects - it takes an Actor's Name and Array of Movie objects;
			for (int f = 0; f < allActors.size(); f++) {
//				System.out.println(" movies: " + actorMovie.get(allActors.get(f)) + " actor: " + allActors.get(f));
				Actor actor = new Actor();
				actor.setName(allActors.get(f));
				actor.setMovies(actorMovie.get(allActors.get(f)));
			}	
			
//			Movie object has Movie name, array of Actors and Rating;
//			for (int q = 0; q < allMovies.size(); q++) {
//				if()
//			}
			
			
			System.out.println("movie actors: " + movieActors);
//			System.out.println("all actors: " + allActors);
			System.out.println("actor - movie: " + actorMovie.toString());
			System.out.println("movie objects: " + movieObjects.size());
			System.out.println("movies: " + allMovies.size());
//			System.out.println("helper: " + movieObjectsHelper.size());
			
		}catch(IOException ex){
			System.out.println("some exceptions here " + ex.getMessage());
		}
		
//		System.out.println(myMovieDatabase.getMovieList());
//		System.out.println(myMovieDatabase.getActorList());

	}

}

//I think the same movie should be the same object

