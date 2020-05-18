import java.util.ArrayList;

public class MovieDatabase {
	
	private ArrayList<Movie> movieList = new ArrayList<>();
	private ArrayList<Actor> actorList = new ArrayList<>();
	
	public MovieDatabase() {//creates an object with all this crap
		
	}
	
	public void addMovie(String name, String[] actors) {
		//now that we determined what move and actor to add, let's do that
		System.out.println("movie name: " + name + "actor: " + actors);
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
	
	//getters and setters
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(Movie movie) {
		movieList.add(movie);
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(Actor actor) {
		actorList.add(actor);
	}

	

}
