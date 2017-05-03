

public class UserInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Boolean isQuit = false;
		int option = 0;
		MovieList list = new MovieList();
		while(!isQuit){
			option=userInterface();
			if(option == 1){
				list.insert(option1());
				System.out.println("Your movie has been successfully added into the list.");
				returnMainMenu();
			}
			else if(option == 2){
				if(MovieList.getNum() != 0){
					option2(list);
					TextIO.putln("Remove success");
				}
				else{
					System.out.println("There is currently no movie in the list! Try again later!");
				}
				returnMainMenu();
			}
			else if(option == 3){
				option3(list);
				returnMainMenu();
			}
			else if(option == 4){
				option4(list);
				returnMainMenu();
			}
			else if(option == 5){
				option5(list);
				returnMainMenu();
			}
			else if(option == 6){
				option6(list);
				returnMainMenu();
			}
			else if(option == 7){
				option7(list);
				returnMainMenu();
			}
			else{
				String quit="";
				TextIO.put("Are you sure you want to quit? - all your data will be lost.");
				while(!quit.equalsIgnoreCase("Y") && !quit.equalsIgnoreCase("N")){
					TextIO.putln("Press Y to quit, and press N to stay here!");
					quit=TextIO.getlnString();
				}
				if(quit.equalsIgnoreCase("Y")){
					isQuit=true;
				}
				else{
					isQuit=false;
				}
			}
		}
	}
	
	public static void returnMainMenu(){
		TextIO.putln("Return the main menu, hit return!!");
		String temp=" ";
		while(!temp.equals("")){
			temp=TextIO.getln();
		}
	}
	
	public static int userInterface(){
		int option=0;
		while(option==0){
			System.out.println("Welcome to the Movie Rating App! Select an option below:");
			System.out.println();
			System.out.println("1) add a movie");
			System.out.println("2) remove a movie");
			System.out.println("3) display movies alphabetically");
			System.out.println("4) display movies >= a certain rating");
			System.out.println("5) display movies in a specified genere");
			System.out.println("6) list all movies with a specified actor/actress");
			System.out.println("7) list all movies that the user has yet to see");
			System.out.println("8) quit");
			System.out.println();
			System.out.println("Select an option above:");
			option=TextIO.getlnInt();
			if(option<0 || option>8){
				System.out.println("Please enter a valid option number(must be between 1 and 8!!!)");
				option=0;
			}
		}
		return option;
	}

	public static Movie option1(){
		String movieTitle = "", movieDescription = "";
		boolean seen;
		String temp ="";
		int actorNum = 0;
		int rating=0, genere = 0;
		Actor movieActor = new Actor();
		while(movieTitle.length() == 0){
			TextIO.putln("Please enter the title of the movie! After entering, press ENTER!");
			movieTitle = TextIO.getlnString();
			//System.out.println(movieTitle);
		}
		String tempStr = movieTitle.substring(0, 1);
		tempStr = tempStr.toUpperCase();
		movieTitle = tempStr + movieTitle.substring(1);
		TextIO.putln("Please enter a description of that movie! After entering, press ENTER!");
		movieDescription = TextIO.getlnString();
		if(movieDescription.length() == 0){
			movieDescription = "No description";
		}
		while(true){
			TextIO.putln("Have you watched that movie? \"Y\" for yes and \"N\" for no. After entering, press ENTER!");
			temp=TextIO.getlnString();
			if(temp.equalsIgnoreCase("Y")){
				seen = true;
				break;
			}
			if(temp.equalsIgnoreCase("N")){
				seen = false;
				break;
			}
		}
		while(genere <1 || genere > 6){
			TextIO.putln("Please enter the genere of the movie! After entering, press ENTER!");
			TextIO.putln("1. Action\n2. Romance\n3. Comedy\n4. Drama\n5. Documentary\n6. Anime");
			genere = TextIO.getlnInt();
		}
		while(rating<=0 || rating>5){
			TextIO.putln("Provide a rating for that movie! (1: poor; 5: great) After entering, press ENTER!");
			rating=TextIO.getlnInt();
		}
		while(actorNum == 0){
			TextIO.putln("Please enter the number of actors/actress in the movie. After entering, press ENTER!");
			actorNum = TextIO.getlnInt();
		}
		for(int i = 0; i < actorNum; i++){
			String actorName = "";
			while(actorName == ""){
				TextIO.putln("Please enter the #" + (i+1) + " actor/actress. After entering, press ENTER!");
				actorName = TextIO.getlnString();
			}
			movieActor.addActor(actorName);
			actorName = "";
		}
		Movie data=new Movie(movieTitle, rating, genere, seen, movieDescription, movieActor);
		return data;
	}

	public static void option2(MovieList list){
		int tempOption=0;
		System.out.println("Here is all the Movies in the list. Which one do you want to remove?");
		option3(list);
		tempOption=TextIO.getlnInt();
		while(tempOption < 1 || tempOption > MovieList.getNum()){
			System.out.println("Please choose an existing workout! Choose again please!!");
			tempOption=TextIO.getlnInt();
		}
		list.removeMovie(tempOption);
	}
	
	public static void option3(MovieList list){
		if(MovieList.getNum() == 0){
			System.out.println("There is currently no movie in the list! Try again later!");
			return;
		}
		System.out.println(list.toString(0));
	}
	
	public static void option4(MovieList list){
		int standardRating = 0;
		if(MovieList.getNum() == 0){
			System.out.println("There is currently no movie in the list! Try again later!");
			return;
		}
		while(standardRating <= 0 || standardRating > 5){
			TextIO.putln("Please enter the rating.(1: poor; 5: great) After entering, press ENTER!");
			standardRating=TextIO.getlnInt();
		}
		System.out.println(list.toStringLargerThan(0, standardRating));
	}
	
	public static void option5(MovieList list)
	{
		int genere = 0;
		if(MovieList.getNum() == 0){
			System.out.println("There is currently no movie in the list! Try again later!");
			return;
		}
		while(genere <1 || genere > 6){
			TextIO.putln("Please enter the genere of the movie! After entering, press ENTER!");
			TextIO.putln("1. Action\n2. Romance\n3. Comedy\n4. Drama\n5. Documentary\n6. Anime");
			genere = TextIO.getlnInt();
		}
		System.out.println(list.toStringInGenere(0, genere));
	}
	
	public static void option6(MovieList list){
		String actor = "";
		if(MovieList.getNum() == 0){
			System.out.println("There is currently no movie in the list! Try again later!");
			return;
		}
		while(actor.length() == 0){
			TextIO.putln("Please enter the actor/actress you want to search for! After entering, press ENTER!");
			actor = TextIO.getlnString();
		}
		System.out.println(list.toStringHaveActor(0, actor));
	}
	
	public static void option7(MovieList list)
	{
		if(MovieList.getNum() == 0){
			System.out.println("There is currently no movie in the list! Try again later!");
			return;
		}
		System.out.println(list.toStringSeen(0));
	}
}
