import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

class TicketNode{
	final int ticketID;
	static int counter = 0;
	static int count = 0;
	String customerName;
	String movieName;
	int seatNumber;
	String bookingTime;
	TicketNode next;
	
	TicketNode(String customerName, String movieName, String bookingTime){
		this.customerName = customerName;
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.ticketID = counter++;
		this.seatNumber = count++;
		this.bookingTime = bookingTime;
		this.next = null;
	}
}

public class OnlineTicket{
	
	static TicketNode head;
	static TicketNode tail;
	
	public static void addTicket(TicketNode newTicket){
		if(head == null){
			head = newTicket;
			tail = newTicket;
			tail.next = head;
		}else{
			tail.next = newTicket;
			tail = newTicket;
			newTicket.next = head;
		}
	}
	
	public static void removeTicket(int ticketID){
		if(head == null || head.next == null){
			System.out.println("Tickets not found!");
            return;
		}
		TicketNode curr = head;
		TicketNode prev = null;
		if(head.next == head && head.ticketID == ticketID){
			head = null;
			return;
		}
		do{
			if(curr.ticketID == ticketID){
				if(curr == head){
					head = head.next;
					tail.next = head;
				}else{
					prev.next = curr.next;
				}
				return;
			}
			prev = curr;
			curr = curr.next;
		}while(curr != head);
		System.out.println("Ticket with ID: "+ticketID+" not found!");
	}
	
	public static void searchCustomer(String movieName){
		if(head == null){
			System.out.println("No Tickets available");
			return;
		}
		boolean found = false;
		TicketNode curr = head;
		do {
			if (curr.movieName.equals(movieName)) {
				System.out.println("Customer Name: " + curr.customerName + ", MovieName: " + curr.movieName);
				found = true;
				break; 
			}
			curr = curr.next;
		} while (curr != head);
		if(!found){
			System.out.println("Not found!");
			return;
		}
	}
	
	public static void totalTickets(){
		System.out.println("Total Tickets Booked: "+TicketNode.counter);
	}
	
	public static String getbookingtime(){
		ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = istTime.format(formatter);
		return formattedTime;
	}
	
	public static void display(){
		TicketNode curr = head;
		do{
			System.out.print("[ "+curr.seatNumber+" "+curr.movieName+" "+curr.bookingTime+" ]--->");
			curr = curr.next;
		}while(curr != head);
		System.out.print("head\n");
	}
	
	public static void main(String[] a) throws InterruptedException{
		addTicket(new TicketNode("Manoj", "Rabasa", getbookingtime()));
		addTicket(new TicketNode("Deekshith", "Parugu", getbookingtime()));
		display();
		
		removeTicket(1);
		display();
		
		searchCustomer("Rabasa");
		
		totalTickets();
		
	}
}