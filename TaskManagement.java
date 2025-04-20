class TaskNode{
	int taskId;
	String taskName;
	String priority;
	String date;
	TaskNode next;
	
	TaskNode(int taskId, String taskName, String priority, String date){
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.date = date;
		this.next = null;
	}
}

public class TaskManagement{
	
	//add at the beginning
	public static TaskNode addatBeginning(TaskNode head, TaskNode newTask){
		if(head == null){
			head = newTask;
			newTask.next = newTask;
		}else{
			TaskNode tail = head;
			while(tail.next != head){
				tail = tail.next;
			}
			newTask.next = head;
			tail.next = newTask;
			head = newTask;
		}	
		return head;
	}
	
	//add at the end
	public static TaskNode addatEnd(TaskNode head, TaskNode newTask){
		if(head == null){
			head = newTask;
			newTask.next = newTask;
		}else{
			TaskNode tail = head;
			while(tail.next != head){
				tail = tail.next;
			}
			tail.next = newTask;
			newTask.next = head;
			tail = newTask;
		}
		return head;
	}
	
	// add at a position
	public static TaskNode addatPosition(TaskNode head, TaskNode newTask, int pos){
		if(pos == 1){
			head = addatBeginning(head, newTask);
			return head;
		}else{
			TaskNode curr = head;
			pos = pos - 1;
			while(curr.next != head && pos > 1){
				curr = curr.next;
				pos--;
			}
			TaskNode store = curr.next;
			curr.next = newTask;
			newTask.next = store;
		}	
		return head;
	}
	
	//remove a task by taskID
	public static TaskNode removeTask(TaskNode head, int taskId){
		TaskNode curr = head;
		while(curr.next != head){
			if(curr.next.taskId == taskId){
				TaskNode store = curr.next.next;
				curr.next = store;
			}
			curr = curr.next;
		}
		return head;
	}
	
	//search for a task by Priority
	public static void searchPriority(TaskNode head, String priority){
		TaskNode curr = head;
		do{
			if(curr.priority.equals(priority)){
				System.out.println(curr.taskName);
				return;
			}
			curr = curr.next;
		}while(curr != head);
		System.out.println("No task with the given priority found");
	}
	
	//display list
	public static void display(TaskNode head){
		TaskNode curr = head;
		do{
			System.out.print(curr.taskName+"->");
			curr = curr.next;
		}while(curr != head);
		System.out.print("null\n");
	}
	
	public static void main(String[] a){
		TaskNode head = null;
		
		head = addatBeginning(head, new TaskNode(01, "Java", "Learn", "9th2025"));
		head = addatBeginning(head, new TaskNode(02, "Basics", "Read", "10th2025"));
		display(head);
		
		head = addatEnd(head, new TaskNode(03, "OOPS", "Encapsulation", "11th2025"));
		display(head);		
		
		head = addatPosition(head, new TaskNode(04, "Spring", "DB", "12th2025"), 4);
		display(head);
		
		head = removeTask(head, 04);
		display(head);
		
		searchPriority(head, "Encapsulation");
		
	}
}

