import java.util.*;
class BookNode{
	String title;
	String author;
	String genre;
	final int bookID;
	static int counter = 1;
	boolean avaialability;
	BookNode prev;
	BookNode next;

	BookNode(String title, String author, String genre, boolean avaialability){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.bookID = counter++;
		this.avaialability = avaialability;
		this.prev = null;
		this.next = null;
	}
}

public class LibraryManagement{
	static BookNode head;
	static BookNode tail;
	
	//add at a Beginning
	public static BookNode addatBeginning(BookNode newBook){
		if(head == null){
			head = newBook;
			tail = newBook;
		}else{
			newBook.next = head;
			head.prev = newBook;
			head = newBook;
		}
		return head;
	}
	
	//add at a Ending
	public static BookNode addatEnding(BookNode newBook){
		if(head == null){
			head = newBook;
			tail = newBook;
		}else{
			tail.next = newBook;
			newBook.prev = tail;
			tail = newBook;
		}
		return head;
	}
	
	//add at a Position
	public static BookNode addatPosition(BookNode newBook, int pos){
		if(pos == 1){
			head = addatBeginning(newBook);
			return head;
		}
		BookNode curr = head;
		pos = pos - 1;
		while(curr.next != null && pos > 1){
			curr = curr.next;
			pos--;
		}
		BookNode store = curr.next;
		curr.next = newBook;
		newBook.prev = curr;
		newBook.next = store;
		
		//key thing for linking prev nodes
		if (store == null) {
			tail = newBook;
		}else{
			store.prev = newBook;
		}
		
		return head;
	}
	
	//Remove Book by BookId
	public static BookNode removeBook(int bookID){
		if(head == null){
			System.out.println("Library is Empty");
			return null;
		}
		
		BookNode curr = head;
		while(curr!= null){
			if(curr.bookID == bookID){
				if (curr == head) {
					head = head.next;
					if (head != null) head.prev = null;
					else tail = null;
				} else if (curr == tail) {
					tail = tail.prev;
					if(tail != null) tail.next = null;
				} else {
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
				}
				System.out.println("BookID: " + bookID + " is removed");
				return head;
			}
			curr = curr.next;
		}
		System.out.println("BookID " + bookID + " not found.");
		return head;
	}
	
	//search for a book by Title
	public static List<String> searchBook(List<String> books, String author){
		BookNode curr = head;
		while(curr != null){
			if(curr.author.equals(author)){
				books.add(curr.title);
			}
			curr = curr.next;
		}
		return books;
	}
	
	//update books status
	public static void updateAvailability(int bookID, boolean avaialability){
		BookNode curr = head;
		while(curr != null){
			if(curr.bookID == bookID){
				curr.avaialability = avaialability;
				System.out.println("\nBookID: "+curr.bookID+"  Availability: "+curr.avaialability);
				return;
			}
			curr = curr.next;
		}
		System.out.println("Book not found to update!");
	}
	
	//reverseDisplay
	public static void displayReverse(){
		BookNode curr = tail;
		System.out.print("In Reverse Order: ");
		while(curr != null){
			System.out.print(curr.title+"->");
			curr = curr.prev;
		}
		System.out.println("null");
	}
	
	//TotalBooks
	public static void totalBooks(){
		if(head == null){
			System.out.println("No books avaiable");
		}
		BookNode curr = head;
		int len = 0;
		while(curr != null){
			len++;
			curr = curr.next;
		}
		System.out.println("Total number of Books: "+len);
	}
	
	//display the list
	public static void display(BookNode head){
		BookNode curr = head;
		while(curr != null){
			System.out.print(curr.title+"-->");
			curr = curr.next;
		}
		System.out.print("null\n");
	}
	
	public static void main(String[] a){
		BookNode begin = addatBeginning(new BookNode("HarryPotter", "Rowling", "Drama", true));
		begin = addatBeginning(new BookNode("Wings of Fire", "Kalam", "Purpose", true));
		display(begin);
		
		BookNode end = addatEnding(new BookNode("Nature", "Manoj", "social", true));
		display(end);
		
		BookNode position = addatPosition(new BookNode("Science", "Sai", "sci", false), 3);
		display(position);
		
		BookNode remove = removeBook(1);
		display(remove);
		
		List<String> books = new ArrayList<>();
		books = searchBook(books, "Kalam");
		for(String b : books){
			System.out.print(b+" ");
		}
		
		updateAvailability(2, false);
		
		displayReverse();
		
		totalBooks();
		/*	BookNode curr = head;
			while(curr != null){
			System.out.print(curr.bookID+"-->");
			curr = curr.next;
		}*/
		//System.out.print(tail.title);
	}
}