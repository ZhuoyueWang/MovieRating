
public class Movie {
	private String title;
	private int rating;
	private String movieDescription;
	private int genere;
	private boolean haveSeen;
	private Actor actors;
	////////////////////////////////////////Private variables/////////////////////
	public String getTitle(){
		return this.title;
	}
	public int getRating(){
		return this.rating;
	}
	public String getDes(){
		return this.movieDescription;
	}
	public String getGenere(){
		if(genere == 1) return "ACTION";
		if(genere == 2) return "ROMANCE";
		if(genere == 3) return "COMEDY";
		if(genere == 4) return "DRAMA";
		if(genere == 5) return "DOCUMENTARY";
		return "ANIME";
	}
	public int getGenereInt(){
		if(genere <= 0 || genere >6) return 6;
		return genere;
	}
	public boolean getSeen(){
		return this.haveSeen;
	}
	public String getActors(){
		return this.actors.toString();
	}
	/////////////////////////////////////////Get Methods///////////////////////////
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	public void setRating(int newRate){
		if(newRate >= 1 && newRate <= 5) this.rating = newRate;
	}
	public void setSeen(boolean seen){
		this.haveSeen = seen;
	}
	/////////////////////////////////////////Set Methods///////////////////////////
	public Movie(){
		this.title = "INIT";
		this.rating = 0;
		this.genere = 0;
		this.haveSeen = false;
		this.movieDescription = "INIT";
		this.actors = new Actor();
	}
	public Movie(String newTitle, int newRating, int newGenere, boolean seen, String description, Actor newActors){
		this.title = newTitle;
		this.rating = newRating;
		this.genere = newGenere;
		this.haveSeen = seen;
		this.movieDescription = description;
		this.actors = newActors;
	}
	/////////////////////////////////////////Constructors//////////////////////////
	public String toString(){
		String result = "\tMovie title:		" + this.title;
		if(!this.haveSeen) result += "(*)";
		result += "\n";
		result = result + "\tMovie genere:		" + this.getGenere() + "\n\tActors/Actresses:	" + this.actors.toString() + "\n\tRatings:		" + this.rating + "\n\tDescription:		" + this.getDes() + "\n";
		return result;
	}
	public boolean isHaveActor(String actor){
		return this.actors.toString().toUpperCase().indexOf(actor.toUpperCase()) >= 0;
	}
}
