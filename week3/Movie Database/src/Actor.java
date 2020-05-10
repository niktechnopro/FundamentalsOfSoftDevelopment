import java.util.ArrayList;

public class Actor {
	private String name = "Some actor";
	private ArrayList<Movie> movies = new ArrayList<>();
	
	public Actor() {//constructor
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	
	public void setMovie(Movie movie) {
		movies.add(movie);
	}
	public ArrayList<Movie> getMovies() {
		return movies;
	}
}
