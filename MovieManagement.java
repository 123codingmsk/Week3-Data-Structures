import java.util.*;
class MovieNode{
	String movieTitle;
	String director;
	int yearOfRelease;
	double rating;
	MovieNode prev;
	MovieNode next;
	
	MovieNode(String movieTitle, String director, int yearOfRelease, double rating){
		this.movieTitle = movieTitle;
		this.director = director;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
		this.prev = null;
		this.next = null;
	}
}

public class MovieManagement{
	
	// add the node at beginning
	public static MovieNode addatBeginning(MovieNode head, MovieNode newMovie){
		if(head == null){
			head = newMovie;
			head.next = null;
		}else{
			newMovie.next = head;
			head = newMovie;
		}
		return head;
	}
	
	//add the node at the end
	public static MovieNode addatEnd(MovieNode head, MovieNode newMovie){
		if(head == null){
			head = newMovie;
			head.next = null;
		}else{
			MovieNode curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = newMovie;
			newMovie.prev = curr;
			newMovie.next = null;
		}
		return head;
	}
	
	//add at a specific position
	public static MovieNode addatPosition(MovieNode head, MovieNode newMovie, int pos){
		if(pos == 1){
			head = addatBeginning(head, newMovie);
			return head;
		}
		MovieNode curr = head;
		pos = pos - 1;
		while(curr != null && pos > 1){
			curr = curr.next;
			pos--;
		}
		MovieNode store = curr.next;
		curr.next = newMovie;
		newMovie.prev = curr;
		newMovie.next = store;
		if(store != null){
			store.prev = newMovie;
		}
		return head;
	}
	
	//Remove a Record by Movie-Title
	public static MovieNode removeMovie(MovieNode head, String movieName){
		MovieNode curr = head;
		
		if(head.movieTitle.equals(movieName)){
			head = head.next;
			head.prev = null;
			return head;
		}
		while(curr != null){
			if(curr.next.movieTitle.equals(movieName)){
				MovieNode store = curr.next.next;
				curr.next = store;
				if(store != null){
					store.prev = curr;
				}
				break;
			}
			curr = curr.next;
		}
		return head;
	}
	
	//Search for movie by director
	public static List<String> searchDirectorMovies(MovieNode head, String dirName){
		MovieNode curr = head;
		List<String> movies = new ArrayList<>();
		while(curr != null){
			if(curr.director.equals(dirName)){
				movies.add(curr.movieTitle);
			}
			curr = curr.next;
		}
		return movies;
	}
	
	//display movies in reverse order
	public static void displayReverse(MovieNode head){
		MovieNode curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		while(curr != null){
			System.out.print(curr.movieTitle+"->");
			curr = curr.prev;
		}
		System.out.print("null\n");
	}
	
	//update movie's rating based on title
	public static void updateRating(MovieNode head, String movieName, double rating){
		MovieNode curr = head;
		while(curr != null){
			if(curr.movieTitle.equals(movieName)){
				System.out.println("Before update: "+curr.movieTitle+" : "+curr.rating);
				curr.rating = rating;
				System.out.println("After update: "+curr.movieTitle+" : "+curr.rating);
				break;
			}
			curr = curr.next;
		}
	}
	
	//display the list
	public static void display(MovieNode head){
		MovieNode curr = head;
		while(curr != null){
			System.out.print(curr.movieTitle+"->");
			curr = curr.next;
		}
		System.out.println("null\n");
	}
	
	public static void main(String[] a){
		MovieNode head = null;
		head = addatBeginning(head,new MovieNode("Devara", "Siva", 2024, 5.0));
		head = addatBeginning(head, new MovieNode("Bahubali", "Rajmouli", 2022, 5.0));
		display(head);
		
		head = addatEnd(head, new MovieNode("Arya", "Sukmar", 2005, 4.5));
		display(head);
		
		head = addatPosition(head, new MovieNode("Pushpa", "Sukmar", 2023, 4.1), 2);
		display(head);
		
		//to display sukmar movies, comment below 2 lines
		head = removeMovie(head, "Arya");
		display(head);
		
		List<String> dirMovies = searchDirectorMovies(head, "Sukmar");
		for(String m : dirMovies){
			System.out.print(m+"  ");
		}
		System.out.println("\n");
		
		displayReverse(head);
		
		updateRating(head, "Pushpa", 4.3);
	}
}