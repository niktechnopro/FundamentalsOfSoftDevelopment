import java.util.ArrayList;
import java.util.Arrays;

public class MovieDatabase {
	
	private ArrayList<Movie> movieList = new ArrayList<>();
	private ArrayList<Actor> actorList = new ArrayList<>();
	
	public MovieDatabase() {//creates an object with all this crap
		
	}
	
	public void addMovie(String name, String[] actors) {
		//now that we determined what move and actor to add, let's do that
//		System.out.println("movie name: " + name + ", actor: " + Arrays.deepToString(actors));
		
	}
	
	public void addRating(String name, String rating) {
		//add rating to a movie
		
	}
	
	public void updateRating(String name, double newRating) {
		
	}
	
	public String getBestActor() {//return one actor
		return "";//should be the name of actor that has the best average rating for their movies;
	}
	
	public String getBestMovie() {//return one movie
		return "";//should be the name of the movie with the highest rating
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(ArrayList<Actor> actorList) {
		this.actorList = actorList;
	}
	
//	getters and setters
	

	

}


//if(mv.getActors().contains(v)) {
//	System.out.println("do nothing");
//}else {
//	System.out.println("new Actor detected - we need to add it");
//	for (Actor a : actorList) {
//		if(a.getName().equals(v)) {
//			//if we already have this object - add it
//			mv.getActors().add(a);
//		}else {
//			//new actor - not in actorList - create new Actor object and add it
//			Actor newActor = new Actor();
//			newActor.setName(v);
////			actorList.add(newActor);
//			mv.getActors().add(newActor);
//		}
//	}	
//}


//for (String act : actors) {
//	//1. check if Actor object is already in the actroList array, if not add it, if yes - reuse it
//	//at the same time add new actor object into actorList array
//	for (Actor a : actorList) {
//		if(a.getName().equals(act)) {
//			System.out.println("the actor is in actorList - do not add it");
//			movieActors.add(a);
//		}else {
//			System.out.println("actor is is not in actorList - create an object and add it");
//			Actor newActor = new Actor();
//			newActor.setName(act);
//			newMovieActors.add(newActor);
//		}
//	}	
//}
//for (Actor newAct : newMovieActors) {
//	actorList.add(newAct);
//}



//Movie newMovie = new Movie();
//ArrayList<Actor> movieActors = new ArrayList<>();
//ArrayList<Actor> newMovieActors = new ArrayList<>();
//
////let's work on actors exclusively
//for (String actor : actors) {
//	System.out.println(actor);
//	if(actorList.size() < 1) {
//		Actor act = new Actor();
//		act.setName(actor);
//		actorList.add(act);
//	}else {
//		for(Actor a : actorList) {
//			if(actor.equals(a.getName())) {
//				System.out.println("we already have actor: " + actor + " movie: " + name);
//			}else {
//				Actor act = new Actor();
//				act.setName(actor);
//				newMovieActors.add(act);
//			}
//		}
//	}
//}
////actorList.addAll(newMovieActors);
//System.out.println(actorList);
//System.out.println(newMovieActors);


//if (movieList.size() > 0) {//after we have at least 1 movie
//	for (Movie mv : movieList) {
//		if(mv.getName().equals(name)){
//			System.out.println("movie is in database");
//			//check if we have all the actors in it already
//		}else {
//			//create an object and add it to database
//			for(String actor : actors) {
//				//inner loop to check if this actor in actorList already?
//				for(Actor act : actorList) {
//					if (actor.equals(act.getName())) {//if actor in actorList - use this object
//						movieActors.add(act);
////						System.out.println("match for actor " + actor + " in movie " + name);
//					}else {//if actor is not in actorList - create new Object
//						Actor newActor = new Actor();
//						newActor.setName(actor);
//						movieActors.add(newActor);
//						newMovieActors.add(newActor);
//						System.out.println("new actor: " + actor);
//					}
//				}
//			}
//			
//			newMovie.setName(name);
//			newMovie.setActors(movieActors);
//		}
//	}
//}else {//setting up the first movie
//	newMovie.setName(name);
//	//add actors
//	ArrayList<Actor> newActors = new ArrayList<>();
//	for (String act : actors) {
//		Actor newActor = new Actor();
//		newActor.setName(act);
//		newActors.add(newActor);
//		newMovieActors.add(newActor);
//	}
//	newMovie.setActors(newActors);
//}
//movieList.add(newMovie);
//actorList.addAll(newMovieActors);
//System.out.println("new movie actors: "+ newMovieActors);
//actorList.addAll(newMovieActors);
//for (Actor a : newMovieActors) {
//	actorList.add(a);
//}
//add actors (Actor objects) to the movie

//System.out.println("actors: " + actorList.size());
//System.out.println("movies: " + movieList.size());