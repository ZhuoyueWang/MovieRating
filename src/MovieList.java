
public class MovieList {
	private Movie data;
	private boolean isFirst;
	private MovieList next;
	//private int id;
	private static int num = 0;
	/////////////////////////////////////Private Variables/////////////////////////
	public Movie getData(){
		if(this.isFirst) return this.next.data;
		return this.data;
	}
	public boolean isFirst(){
		return this.isFirst;
	}
	public MovieList getNext(){
		return this.next;
	}
	public String getDataTitle(){
		if(this.isFirst) return "";
		return this.data.getTitle();
	}
	public int getDataRating(){
		if(this.isFirst) return 0;
		return this.data.getRating();
	}
	public static int getNum(){
		return num;
	}
	/////////////////////////////////////Get Methods///////////////////////////////
	public MovieList(){
		this.data = new Movie();
		this.isFirst = true;
		this.next = null;
	}
	public MovieList(Movie newData){
		this.data = newData;
		this.isFirst = false;
		this.next = null;
		num++;
	}
	public MovieList(Movie[] newData){
		this.data = new Movie();
		this.isFirst = true;
		this.next = null;
		MovieList temp = this;
		for(int i = 0; i < newData.length; i++){
			temp.insert(newData[i]);
			//num++;
		}
	}
	public MovieList(Movie newData, MovieList next){
		this.data = newData;
		this.isFirst = false;
		this.next = next;
		num++;
	}
	/////////////////////////////////////Constructors//////////////////////////////
	public void push_back(Movie newData){
		if(this.next == null){
			this.next = new MovieList(newData);
			//num++;
			return;
		}
		this.next.push_back(newData);
	}
	public void insert(Movie newData){
		if(this.getDataTitle().compareToIgnoreCase(newData.getTitle()) <= 0 && this.next == null){
			this.next = new MovieList(newData);
			//num++;
			return;
		}
		if(this.getDataTitle().compareToIgnoreCase(newData.getTitle()) <= 0 && this.next.getDataTitle().compareToIgnoreCase(newData.getTitle()) > 0){
			this.next = new MovieList(newData, this.next);
			//num++;
			return;
		}
		this.next.insert(newData);
	}
	public void removeMovie(int diff){
		if(diff == 1){
			this.next = this.next.next;
			num--;
			return;
		}
		this.next.removeMovie(diff - 1);
	}
	public String toString(int num){
		if(this.isFirst) return this.next.toString(num + 1);
		if(this.next == null) return num + ". " + this.data.toString();
		return num + "." + this.data.toString() + "\n" + this.next.toString(num + 1);
	}
	public String toStringLargerThan(int num, int rating){
		if(this.isFirst) return this.next.toStringLargerThan(num + 1, rating);
		if(this.next == null && this.data.getRating() < rating && num == 1) return "No movies that has a rate larger than " + rating;
		if(this.next == null && this.data.getRating() < rating) return "";
		if(this.next == null) return num + ". " + this.data.toString();
		if(this.data.getRating() < rating) return this.next.toStringLargerThan(num, rating);
		return num + "." + this.data.toString() + "\n" + this.next.toStringLargerThan(num + 1, rating);
	}
	public String toStringInGenere(int num, int genere){
		if(this.isFirst) return this.next.toStringInGenere(num + 1, genere);
		if(this.next == null && this.data.getGenereInt() != genere && num == 1) return "No movies is in genere " + genereInt2String(genere);
		if(this.next == null && this.data.getGenereInt() != genere) return "";
		if(this.next == null) return num + "." + this.data.toString();
		if(this.data.getGenereInt() != genere) return this.next.toStringInGenere(num, genere);
		return num + "." + this.data.toString() + "\n" + this.next.toStringInGenere(num + 1, genere);
	}
	public String toStringSeen(int num){
		if(this.isFirst) return this.next.toStringSeen(num + 1);
		if(this.next == null && !this.data.getSeen() && num == 1) return "No movie has yet been seen in the list.";
		if(this.next == null && !this.data.getSeen()) return "";
		if(this.next == null) return num + "." + this.data.toString();
		if(!this.data.getSeen()) return this.next.toStringSeen(num);
		return num + "." + this.data.toString() + "\n" + this.next.toStringSeen(num + 1);
	}
	public String toStringHaveActor(int num, String actor){
		if(this.isFirst) return this.next.toStringHaveActor(num + 1, actor);
		if(this.next == null && !this.data.isHaveActor(actor) && num == 1) return "No movie with actor " + actor;
		if(this.next == null && !this.data.isHaveActor(actor)) return "";
		if(this.next == null) return num + "." + this.data.toString();
		if(!this.data.isHaveActor(actor)) return this.next.toStringHaveActor(num, actor);
		return num + "." + this.data.toString() + "\n" + this.next.toStringHaveActor(num + 1, actor);
	}
	/////////////////////////////////////public methods////////////////////////////
	private String genereInt2String(int genere){
		if(genere == 1) return "ACTION";
		if(genere == 2) return "ROMANCE";
		if(genere == 3) return "COMEDY";
		if(genere == 4) return "DRAMA";
		if(genere == 5) return "DOCUMENTARY";
		return "ANIME";
	}
	/////////////////////////////////////private helper methods/////////////////////
}
