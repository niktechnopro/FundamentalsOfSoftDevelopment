import java.util.ArrayList;

public class Movie {
	
	private String name = "";
	private ArrayList<Actor> actors = new ArrayList<>();
	private String rating;
	
	public Movie() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	public ArrayList<Actor> getActors() {
		return actors;
	}

	
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getRating() {
		return rating;
	}
}
