import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {

		MovieDatabase myMovieDatabase = new MovieDatabase();
		int idx;
		try {
			//read the movie.txt
			ArrayList<String> allMovies = new ArrayList<>();
			ArrayList<String> allActors = new ArrayList<>();
			BufferedReader buffReaderMovies = new BufferedReader(new FileReader("movies"));
			String line;
			HashMap<String, ArrayList<String>> actorMovie = new HashMap<>();
			HashMap<String, ArrayList<String>> movieActor = new HashMap<>();
			while((line = buffReaderMovies.readLine()) != null) {
				idx = line.indexOf(',');//index of first ","
//				System.out.println(line.substring(0, idx).trim());//actor
				ArrayList<String> movies = new ArrayList<>();
				for (int n = 0; line.substring(idx+1).split(",").length > n; n++) {
					movies.add(line.substring(idx+1).split(",")[n].trim());
					if(!allMovies.contains(line.substring(idx+1).split(",")[n].trim())) {
						allMovies.add(line.substring(idx+1).split(",")[n].trim());
					}
				}
				actorMovie.put(line.substring(0,idx).trim(), movies);
				if(!allActors.contains(line.substring(0,idx).trim())) {
					allActors.add(line.substring(0,idx).trim());
				}
				
				//sorting to movie-actors
				for (String m : movies) {
					if(movieActor.containsKey(m)) {
						//retrieve that movie actors array
						ArrayList<String> currentActors = movieActor.get(m);
						currentActors.add(line.substring(0,idx).trim());
						movieActor.replace(m, currentActors);
					}else {
//						System.out.println("add movie and [] Actor string: " + m);
						ArrayList<String> actor = new ArrayList<>();
						actor.add(line.substring(0,idx).trim());
						movieActor.put(m, actor);	
					}
				}
				
			}
			buffReaderMovies.close();
			
			System.out.println("movie - actor: " + movieActor.size());
			System.out.println("actor - movie: " + actorMovie);
			System.out.println("all movies: " + allMovies.size());
			System.out.println("all actors: " + allActors);
			
			
			//once we have all movies and actor-movies hash map - create object actor and populate ArrayList<Actor>
			ArrayList<Actor> actorList = new ArrayList<>();
			for (String actor : allActors) {
				Actor act = new Actor();
				act.setName(actor);
				actorList.add(act);
			}
			
			//set up Movie objects
			ArrayList<Movie> movieList = new ArrayList<>();
			for (String mov : allMovies) {
				ArrayList<Actor> actors = new ArrayList<>();
				Movie movie = new Movie();
				movie.setName(mov);
				for(String act : movieActor.get(mov)) {
					System.out.println("actor: " + act);
					for (Actor a : actorList) {
						if(act.contentEquals(a.getName())) {
							actors.add(a);
						}
					}
				}
				movie.setActors(actors);
				movieList.add(movie);
			}
			
			
			System.out.println("movieList: " + movieList);
			
			//let's add movie objects to actorList
			for (Actor a : actorList) {
				ArrayList<Movie> mov = new ArrayList<>();
				System.out.println(actorMovie.get(a.getName()));
				for (Movie m : movieList) {
					for(String mo : actorMovie.get(a.getName())){
						if(m.getName().equals(mo)){
							mov.add(m);
						}
					}
				}
				a.setMovies(mov);
			}
			
//			System.out.println(actorList.get(0).getName());
//			for (Movie m : actorList.get(0).getMovies()) {
//				System.out.println(m.getName());
//			}
			
			//set movieList and actorList
			myMovieDatabase.setMovieList(movieList);
			myMovieDatabase.setActorList(actorList);
			
			//get these lists back to see what happens
			System.out.println(myMovieDatabase.getActorList());
			System.out.println(myMovieDatabase.getMovieList());
			//iterate through movieActor HashMap and convert ArrayList into Array;
//			movieActor.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
			movieActor.forEach((k, v) -> myMovieDatabase.addMovie(k, v.toArray(new String[v.size()])));
			
//			for (String key : movieActor.keySet()) {
//				myMovieDatabase.addMovie(key, movieActor.get(key).toArray(new String[movieActor.get(key).size()]));
//			}
			
			
		}catch(IOException ex){
			System.out.println("some exceptions here " + ex.getMessage());
		}
		
		

	}

}

//I think the same movie should be the same object
//try{
//	BufferedReader buffReaderMovies = new BufferedReader(new FileReader("movies"));
//	String line;
//	ArrayList<String> allMovies = new ArrayList<>();
//	ArrayList<String> allActors = new ArrayList<>();
//	ArrayList<Actor> allActorObjects = new ArrayList<>();
//	ArrayList<String> movieObjectsHelper = new ArrayList<>();
//	ArrayList<Movie> movieObjects = new ArrayList<>();
//	HashMap<String, ArrayList<Actor>> movieActorObjects = new HashMap<>();
//	int i;
//	//cross reference each movie and add array of actors that was in it
//	HashMap<String, ArrayList<String>> movieActors = new HashMap<>();
//	HashMap<String, ArrayList<Movie>> actorMovie = new HashMap<>();//actor to movies reference
//	while((line = buffReaderMovies.readLine()) != null) {
//		//the following logic is for 
//		i = line.indexOf(',');//index of first ","
//		ArrayList<Movie> movies = new ArrayList<>();
//		for (String movie : line.substring(i+1).split(",")) {//making an ArrayList of Movie objects
//			//make sure this is the same Object
//			if (!movieObjectsHelper.contains(movie.trim())) {
//				movieObjectsHelper.add(movie.trim());
//				Movie m = new Movie();
//				m.setName(movie.trim());
//				movieObjects.add(m);
//				movies.add(m);
//			}else {
//				//find it in array and add to movies
//				for(Movie mo : movieObjects) {
//					if(mo.getName().equals(movie.trim())) {
//						movies.add(mo);
//					}
//				}
//			}
//		}
//		actorMovie.put(line.substring(0,i).trim(), movies);
//		allActors.add(line.substring(0,i).trim());
//		
//		//next we are going to make HashMap with movie = [Actors];
//		Actor actor = new Actor();
//		actor.setName(line.substring(0,i).trim());
//		allActorObjects.add(actor);
//		
//		//cross reference movie to actors - movie is a key, and array of actors - value
//		ArrayList<String> movieActor = new ArrayList<>();
//		ArrayList<Actor> mvActorObj = new ArrayList<>();
//		movieActor.add(line.substring(0,i).trim());
//		mvActorObj.add(actor);
//		
//		
//		for(String f : line.substring(i+1).split(",")){
//			if(allMovies.contains(f.trim())){//check if movie is in Array already
////				System.out.println(f.trim());
//				for(int n = 0; n < movieActors.get(f.trim()).size(); n++) {//if movie is already in HashMap - do not add
//					if(!movieActor.contains(movieActors.get(f.trim()).get(n))) {
//						movieActor.add(movieActors.get(f.trim()).get(n));
////						
////						//add logic working with Objects
////						//1.index for ActorObject should be the same as for regular ArrayList
////						//2.Let's iterate through Array of Actor objects and place the same Object instead of name
////
//						for (Actor act : allActorObjects) {
//							if(act.getName().equals(movieActors.get(f.trim()).get(n))) {
//								mvActorObj.add(act);
//							}
//						}
//					}
//				}
////				System.out.println(f.trim() + " : " + mvActorObj);
//				movieActors.replace(f.trim(), movieActor);
//				movieActorObjects.replace(f.trim(), mvActorObj);
//			} else {//if not in array - add it
//				allMovies.add(f.trim());
//				movieActors.put(f.trim(), movieActor);
////				//for movie = [Actors];
//				movieActorObjects.put(f.trim(), mvActorObj);
//			}
//		}
//	}
//	buffReaderMovies.close();
//	
//	//next - read the ratings and then if movie is not in this list - populated it with 5
//	BufferedReader buffReaderRating = new BufferedReader(new FileReader("ratings"));
//	line = null;
//	HashMap<String, String> ratingsMap = new HashMap<>();
//	while((line = buffReaderRating.readLine()) != null) {
//		if(!line.contentEquals("movie_name	critic_score")){//removes description
//			ratingsMap.put(line.split("(?<=\\D)(?=\\d)")[0].trim(), line.split("(?<=\\D)(?=\\d)")[1].trim());
//		}
//	}
//	buffReaderRating.close();
//	
//	//next - iterate through allMovies arrays - and add to ratingsMap what is missing;
//	for (int k = 0; allMovies.size() > k; k++) {
//		if(!ratingsMap.containsKey(allMovies.get(k))){
//			ratingsMap.put(allMovies.get(k), String.valueOf(63));
//			
//		}
//	}
//
//	ArrayList<Actor> actorObjects = new ArrayList<>();
//	//next - create Actor Objects - it takes an Actor's Name and Array of Movie objects;
//	for (int f = 0; f < allActors.size(); f++) {
//		Actor actor = new Actor();
//		actor.setName(allActors.get(f));
//		actor.setMovies(actorMovie.get(allActors.get(f)));
//		actorObjects.add(actor);
//	}	
//	
////	Movie object has Movie name, array  Rating and Actors Array;
//	for (int q = 0; q < movieObjects.size(); q++) {
//		movieObjects.get(q).setRating(ratingsMap.get(movieObjects.get(q).getName()));//set rating
//		movieObjects.get(q).setActors(movieActorObjects.get(movieObjects.get(q).getName()));
//	}
//	
//	
////	System.out.println("actor objects: " + actorObjects);
//	System.out.println("movie actors: " + movieActors);
////	System.out.println("all actors: " + allActors.size());
////	System.out.println("all actors objects: " + allActorObjects.size());
////	System.out.println("actor - movie: " + actorMovie.toString());
////	System.out.println("movies: " + allMovies.size());
////	System.out.println("movie actors Obj: " + movieActorObjects);	
////	System.out.println("helper: " + movieObjectsHelper.size());
//	
//	System.out.println("movie objects: " + movieObjects.get(8).getName() + " rating: " + movieObjects.get(8).getRating());
//	movieObjects.get(8).getActors().forEach(actor -> {
//		System.out.println(actor.getName());
//	});
