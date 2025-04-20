import java.util.Scanner;
class Node{
	String itemName;
	int itemId;
	int quantity;
	double price;
	Node next;
	
	Node(String itemName,int itemId, int quantity, double price){
		this.itemName = itemName;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}
}

class InventoryManagement{
	static Node head;
	
	//add the node at the start
	public static Node addatBeginning(Node newInventory){
		if(head == null){
			head = newInventory;
		}else{
			newInventory.next = head;
			head = newInventory;
		}
		return head;
	}
	
	//add the node at the end
	public static Node addatEnding(Node newInventory){
		if(head == null){
			head = newInventory;
		}else{
			Node curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = newInventory;
		}
		return head;
	}
	
	//add the node at a specific position
	public static Node addatPosition(Node newInventory, int pos){
		if(pos == 1){
			head = addatBeginning(newInventory);
			return head;
		}
		Node curr = head;
		pos = pos - 1;
		while(curr != null && pos > 1){
			curr = curr.next;
		}
		Node store = curr.next;
		curr.next = newInventory;
		newInventory.next = store;
		
		return head;
	}
	
	//remove an item based on itemId
	public static Node removeItem(int itemId){
		if(head == null){
			System.out.println("Inventory is empty");
			return null;
		}
		if(head.itemId == itemId){
			head = head.next;
			return head;
		}
		Node curr = head;
		while(curr.next != null){
			if(curr.next.itemId == itemId){
				curr.next = curr.next.next;
				break;
			}
			curr = curr.next;
		}
		return head;
	}
	
	//update the quantity by itemId
	public static void updateQuantity(int itemId, int newquantity){
		if (head == null) {
			System.out.println("Inventory is empty.\n");
			return;
		}
		Node curr = head;
		while(curr != null){
			if(curr.itemId == itemId){
				curr.quantity = newquantity;
				System.out.println("ItemName: "+curr.itemName+"   Quantity: "+curr.quantity+"\n");
				return;
			}
			curr = curr.next;
		}
		System.out.println("Item not found with the itemId: "+itemId+"\n");
	}
	
	//search for an itemid or itemName
	public static void searchItem(){
		System.out.print("Choose an option to search: 1 for ItemId or 2 for ItemName\n");
		Scanner scn = new Scanner(System.in);
		int input = scn.nextInt();
		Node curr = head;
		switch(input){
			case 1:
				if (head == null) {
					System.out.println("Inventory is empty.");
					return;
				}
				System.out.println("Enter itemId: \n");
				int itemId = scn.nextInt();
				while(curr != null){
					if(curr.itemId == itemId){
						System.out.println("Item found! ItemName: "+curr.itemName);
						return;
					}
					curr = curr.next;
				}
				System.out.println("Item not found with the itemId: "+itemId);
				break;
			case 2:
				if (head == null) {
					System.out.println("Inventory is empty.");
					return;
				}
				System.out.println("Enter itemName: \n");
				String itemName = scn.next();
				while(curr != null){
					if(curr.itemName.equals(itemName)){
						System.out.println("Item found! ItemName: "+curr.itemName);
						return;
					}
					curr = curr.next;
				}
				System.out.println("Item not found with the itemName: "+itemName);
				break;
			default:
				System.out.println("Enter valid digit");
		}
	}
	
	//calculating total value of Inventory
	public static void totalValueofInventory(){
		if (head == null) {
			System.out.println("Inventory is empty.");
			return;
		}
		
		Node curr = head;
		double total = 0;
		while(curr != null){
			double cost = curr.price * curr.quantity;
			total = total + cost;
			curr = curr.next;
		}
		System.out.println("Total value of Inventory: "+total);
	}
				
	//display the list
	public static void display(Node head){
		Node curr = head;
		while(curr != null){
			System.out.print(curr.itemName+"->");
			curr = curr.next;
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static void sortInventory(){
		Node p1 = head;
		while(p1 != null){
			Node p2 = p1.next;
			while(p2 != null){
				if(p1.price > p2.price){
					String tempName = p1.itemName;
					int tempId = p1.itemId;
					int tempQty = p1.quantity;
					double tempPrice = p1.price;

					p1.itemName = p2.itemName;
					p1.itemId = p2.itemId;
					p1.quantity = p2.quantity;
					p1.price = p2.price;

					p2.itemName = tempName;
					p2.itemId = tempId;
					p2.quantity = tempQty;
					p2.price = tempPrice;
				}
				p2 = p2.next;
			}
			p1 = p1.next;
		}
		System.out.println("Sorted Inventory by Price:");
		Node curr = head;
		while(curr != null){
			System.out.print("Item: " + curr.itemName + ", Price: " + curr.price+"\n");
			curr = curr.next;
		}
	}

	public static void main(String[] a){
		Node begin = addatBeginning(new Node("Milk", 01, 1, 10.0));
		begin = addatBeginning(new Node("Lays", 02, 1, 10.0));
		display(begin);
		
		Node end = addatEnding(new Node("Curd", 03, 1, 10.0));
		display(end);
		
		Node position = addatPosition(new Node("Rice", 04, 2, 100.0), 2);
		display(position);
		
		Node remove = removeItem(2);
		display(remove);
		
		updateQuantity(1, 2);
		
		//searchItem();
		
		totalValueofInventory();
		
		sortInventory();
	}
}