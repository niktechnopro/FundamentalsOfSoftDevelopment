import java.util.ArrayList;

public class MovieDatabase {
	
	public ArrayList<Movie> movieList = new ArrayList<>();
	public ArrayList<Actor> actorList = new ArrayList<>();
	
	public MovieDatabase() {//creates an object with all this crap
		
	}
	
	public void addMovie(String name, String[] actors) {
		
	}
	
	public void addRating(String name, String rating) {
		
	}
	
	public void updateRating(String name, double newRating) {
		
	}
	
	public String getBastActor() {//return one actor
		return "";//should be the name of actor that has the best average rating for their movies;
	}
	
	public String getBestMovie() {//return one movie
		return "";//should be the name of the movie with the highest rating
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
