import java.util.ArrayList;

public class Movie {
	
	public String name = "";
	public ArrayList<Actor> actors = new ArrayList<>();
	double rating;
	
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

	
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getRating() {
		return rating;
	}
}
