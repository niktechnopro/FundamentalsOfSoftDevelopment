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
		Movie newMovie = null;
		ArrayList<Movie> mvs = new ArrayList<>();
		for (Movie m : movieList) {
			if(m.getName().equals(name.trim())) {
//				System.out.println("we found match - movie already exists in the list: " + m.getName());
			}else {
				//the movie is not in the list - need to create an object and add it to movieList
//				System.out.println("the movie is not in the list - we need to add it");
				newMovie = new Movie();
			}
		}
		if(newMovie != null) {
			movieList.add(newMovie);
			mvs.add(newMovie);//local array
		
			//now dealing with actors
			//check if new Actor is in actorList
			//System.out.println(Arrays.toString(actors));
			ArrayList<Actor> newActors = new ArrayList<>();
			for (String actor : actors) {
				String newActor = "";
				int idx = 0;
				for (int aidx = 0; actorList.size() > aidx; aidx++) {
					if(actorList.get(aidx).getName().contentEquals(actor.trim())) {
						idx = aidx;
						newActor = "exists";
					}else {
						newActor = actor;
					}
				}
				if (!newActor.contentEquals("exists")) {//if this is new Actor
//					System.out.println("create new actor: " + newActor);
					Actor atr = new Actor();
					atr.setName(newActor);
					atr.setMovies(mvs);
					newActors.add(atr);
				}else{
//					System.out.println("add movie to already existing actor: " + actorList.get(idx).getName());
					newActors.add(actorList.get(idx));
				}
			}
			newMovie.setActors(newActors);
		}
	}
	
	public void addRating(String name, double rating) {
		//double dnum = Double.parseDouble(str); // to convert string to double
//		System.out.println("Movie: " + name + ", rating: " + rating);
		for (Movie m : movieList) {
			if(m.getName().contentEquals(name)) {
				m.setRating(rating);
			}
		}
		
	}
	
	public void updateRating(String name, double newRating) {
		//to update rating - find Movie in movieList and update rating
		for (Movie m : movieList) {
			if(m.getName().equals(name)) {
				m.setRating(newRating);
			}
		}
	}
	
	public String getBestActor() {//return one actor
		// iterate over actorList and, calculate average from movies and 
		double highestRating = 0.0;
		double actorRating = 0.0;
		String bestActor = "";
		for(Actor a : actorList) {
//			System.out.println("movies: " + a.getMovies());
			for (Movie m : a.getMovies()) {
//				System.out.println("movie: " + m.getName() + " " + m.getRating()); 
				actorRating = (actorRating + m.getRating())/a.getMovies().size();
			}
			if(actorRating > highestRating) {
				highestRating = actorRating;
				bestActor = a.getName();
			}
		}
		return bestActor;//should be the name of actor that has the best average rating for their movies;
	}
	
	public String getBestMovie() {//return one movie
		//should be the name of the movie with the highest rating
		double highest = 0.0;
		String bestRatedMovie = "";
		for (Movie m : movieList) {
			if(m.getRating() > highest) {
				highest = m.getRating();//determined the highest rating in Movie objects
			}
		}
		for(Movie m : movieList) {
//			System.out.println(m.getName() + " : " + m.getRating());
			if(m.getRating() == highest) {
				bestRatedMovie = m.getName();
			}
		}
		return bestRatedMovie;
	}

	
	//getters and setters
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