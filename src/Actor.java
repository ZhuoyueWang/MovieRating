
public class Actor {
	private String name;
	private Actor next;
	private boolean isFirst = false;
	/////////////////////////////////private instance variables////////////////////
	public String getName(){
		return this.name;
	}
	public Actor getNext(){
		return this.next;
	}
	public boolean isFirst(){
		return this.isFirst;
	}
	/////////////////////////////////get methods///////////////////////////////////
	public void setName(String newName){
		this.name = newName;
	}
	public void setIsFirst(){
		this.isFirst = true;
	}
	/////////////////////////////////set methods///////////////////////////////////
	public Actor(String name){
		this.name = name;
		this.next = null;
		//length++;
	}
	public Actor(){
		this.name = "INIT";
		this.next = null;
		this.isFirst = true;
		//length++;
	}
	//////////////////////////////////constructors/////////////////////////////////
	public int length(){
		int length = 1;
		for(Actor temp = this; temp.next != null; temp = temp.next){
			length++;
		}
		return length;
	}

	public void addActor(String name){
		Actor temp = this;
		while(temp.next != null) temp = temp.next;
		Actor newActor = new Actor(name);
		temp.next = newActor;
	}
	
	public String toString(){
		if(this.isFirst)return this.next.toString();
		if(this.next == null) return this.name;
		return this.name + ", " + this.next.toString();
	}
	///////////////////////////////////public methods//////////////////////////////
}
