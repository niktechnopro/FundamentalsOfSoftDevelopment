import java.io.*;
import java.util.ArrayList;
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
			String actor;
			String movies;
			ArrayList<String> allMovies = new ArrayList<>();
			ArrayList<String> allActors = new ArrayList<>();
			String [] moviesarr;
			int i;
////			first - building an array of actors and all movies;
//			while((line = buffReaderMovies.readLine()) != null) {
//				i = line.indexOf(',');//index of first ","
//				allActors.add(line.substring(0,i).trim());
//				moviesarr = line.substring(i+1).trim().split(",");
//				for(String s : moviesarr) {
//					if(!allMovies.contains(s)) {//removing duplicates
//						allMovies.add(s.trim());
//					}
//				}
//			}
//			System.out.println(allMovies.toString());
//			System.out.println(allActors.toString());
			buffReaderMovies.close();
			
			//next step - cross reference each movie and add array of actors that was in it
			HashMap<String, ArrayList<String>> movieActors = new HashMap<>();
			buffReaderMovies = new BufferedReader(new FileReader("movies"));
			while((line = buffReaderMovies.readLine()) != null) {
				i = line.indexOf(',');//index of first ","
				ArrayList<String> movieActor = new ArrayList<>();
				movieActor.add(line.substring(0,i).trim());
				for(String f : line.substring(i+1).split(",")){
					if(!movieActors.containsKey(f.trim())){//if movie is not already in HashMap - add actor
						System.out.println("add this movie: " + f.trim() + " actor: " + line.substring(0,i));
						allMovies.add(f.trim());
						movieActors.put(f.trim(), movieActor);//(f.trim(), movieActor.add(line.substring(0,i)));
					}else {
						if(!movieActors.get(f.trim()).contains(line.substring(0,i).trim())) {
							movieActors.get(f.trim()).add(line.substring(0,i).trim());
						}
					}
				}		
			}
//				movieActors.put(allMovies.get(g), movieActor);
			
			System.out.println(movieActors.toString());
			System.out.println(allMovies.size());
//			System.out.println(allMovies.get(1).split(","));
//			for(String s : allMovies.get(1).split(",")) {
//				System.out.println(s);
//			}
//			System.out.println(allActors.get(2));
			
			//next step - movie is a key, and array of actors - value
			
			
			
			
			
			
			buffReaderMovies.close();
		}catch(IOException ex){
			System.out.println("some exceptions here " + ex.getMessage());
		}
		
//		System.out.println(myMovieDatabase.getMovieList());
//		System.out.println(myMovieDatabase.getActorList());

	}

}


//first - will create an array of all movies in myMovieDatabase from movies with no duplicates;
//second - create an array of actors for each movie;

//movie - key; actors = value;



//public class Main {
//
//	public static void main(String[] args) {
//		//create new instance of Movie Database
//		MovieDatabase myMovieDatabase = new MovieDatabase();
//		//another way - let's start with rating first
//		try{
//			BufferedReader buffReaderRatings = new BufferedReader(new FileReader("ratings"));
//			String line = "";
//			String[] newArrLine;
//			while((line = buffReaderRatings.readLine()) != null) {
//				if(!line.contentEquals("movie_name	critic_score")){//removes description
//					Movie movie = new Movie();//creating new object for Movies
//					newArrLine = line.split("(?<=\\D)(?=\\d)");
//					movie.setName(newArrLine[0].trim());
//					movie.setRating(newArrLine[1].trim());
//					myMovieDatabase.setMovieList(movie);
//				}
//			}
//			buffReaderRatings.close();
//		}catch(IOException ex){
//			System.out.println("some exceptions here " + ex.getMessage());
//		}
//		
//		//reading all the actors
//		try {
//			BufferedReader buffReaderActors = new BufferedReader(new FileReader("movies"));
//			String line = "";
//			String[] newArrLine;
//			String[] movieArrayForActor;
//			int i;
//			while((line = buffReaderActors.readLine()) != null) {
//				i = line.indexOf(',');
//				movieArrayForActor = line.substring(i+1).split(",");
////				Actor actor = new Actor();
////				actor.setName(line.substring(0, i));
//				for (int z=0; z < myMovieDatabase.getMovieList().size(); z++) {
//					for(int x=0; x<movieArrayForActor.length; x++) {
//						if(myMovieDatabase.getMovieList().get(z).getName().equals(movieArrayForActor[x].trim())) {//movies that we have in database
////							System.out.println(myMovieDatabase.getMovieList().get(z).getName());
//							
//						}else {//movies that we do not have in database yet
//							System.out.println("add movie: " + movieArrayForActor[x].trim());
////							myMovieDatabase.addMovie(movieArrayForActor[x].trim(), new String[]{line.substring(0, i)});
//							Movie movie = new Movie();//creating new object for Movies
//							movie.setName(movieArrayForActor[x].trim());
//							myMovieDatabase.setMovieList(movie);
//						}
//					}
//				}
////				System.out.println(line.substring(0, i) + " : " + movieArrayForActor[movieArrayForActor.length - 1]);
//			}
//		}catch(IOException ex){
//			System.out.println("some exceptions here " + ex.getMessage());
//		}
//		
//		for (int a = 0; myMovieDatabase.getMovieList().size() > a; a++) {
//			System.out.println(myMovieDatabase.getMovieList().get(a).getName() + " : " + myMovieDatabase.getMovieList().get(a).getRating());
//		}
		
		
//		System.out.println(myMovieDatabase.getMovieList());
//		System.out.println(myMovieDatabase.getActorList());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//read info from files
//		try {
//			BufferedReader buffReaderMovies = new BufferedReader(new FileReader("movies"));
//			String line = "";
//			int i;
//			while((line = buffReaderMovies.readLine()) != null) {
//				//on each iteration I need to create and object Actor.
//				Actor actor = new Actor();
//				i = line.indexOf(',');
//				actor.setName(line.substring(0, i));
//				for(String mov: line.substring(i+1).split(",")) {
//					Movie movie = new Movie();//creating new object for Movies
//					movie.setName(mov);
//					actor.setMovie(movie); 
//					myMovieDatabase.setMovieList(movie);
//				}
//				myMovieDatabase.setActorList(actor);
////				System.out.println(actor.getName()); //(line.substring(0, i), line.substring(i+1));
//			}
//			buffReaderMovies.close();
//			
//			//now we are going to read ratings;
//			BufferedReader buffReaderRatings = new BufferedReader(new FileReader("ratings"));
//			i = 0;
//			line = "";
//			while((line = buffReaderRatings.readLine()) != null) {
//				String[] partedLine;
//				if(!line.contentEquals("movie_name	critic_score")){//removes description
////					System.out.println(line);
//					partedLine = line.split("(?<=\\D)(?=\\d)");
//					for (int a = 0; myMovieDatabase.getMovieList().size() > a; a++) {
//						if(myMovieDatabase.getMovieList().get(a).getName().trim().equals(partedLine[1].trim())) {
//							System.out.println("here: " + myMovieDatabase.getMovieList().get(a).getName() + " " + a);
////							myMovieDatabase.getMovieList().get(a).setRating(partedLine[1]);
//						};
//					}
//				}
//			}
//			buffReaderRatings.close();
//			
////			for (int a = 0; myMovieDatabase.getMovieList().size() > a; a++) {
////				System.out.println(myMovieDatabase.getMovieList().get(a).getName() + " : " + myMovieDatabase.getMovieList().get(a).getRating());
////			}
////			
////			
////			for (int b = 0; myMovieDatabase.getActorList().size() > b; b++) {
////				System.out.println(myMovieDatabase.getActorList().get(b).getName());
////			}
//			
//			
//		}catch(IOException ex){
//			System.out.println("some exceptions here " + ex.getMessage() );
//		}
//		
//		System.out.println(myMovieDatabase.getMovieList());
//		System.out.println(myMovieDatabase.getActorList());

//	}
	
