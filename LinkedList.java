class Student{
	int rollNumber;
	String name;
	int age;
	char grade;
	Student next;
	
	Student(int rollNumber, String name, int age, char grade){
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

public class LinkedList{

	public static Student addStudentatBegin(Student head, Student newStudent){
		newStudent.next = head;
		return newStudent;
	}
	
	public static Student addStudentatEnd(Student head, Student newStudent){
		
		if(head == null){
			return newStudent;
		}
		Student curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = newStudent;
		newStudent.next = null;
		
		return head;
	}
	
	public static Student addStudentatPos(Student head, Student newStudent, int pos){
		Student curr = head;
		pos = pos - 1;
		while(curr != null && pos > 1){
			curr = curr.next;
			pos--;
		}
		Student store = curr.next;
		curr.next = newStudent;
		newStudent.next = store;
		
		return head;
	}
	
	public static Student deleteStudent(Student head, int rollNumber){
		
		if(head == null) return null;
		
		if(head.rollNumber == rollNumber){
			return head.next;
		}
		
		Student curr = head;
		while(curr.next != null){
			if(curr.next.rollNumber == rollNumber){
				Student store = curr.next.next;
				curr.next = store;
				return head;
			}
			curr = curr.next;
		}
			
		return null;
	}
	
	public static Student searchStudent(Student head, int rollNumber){
		Student curr = head;
		while(curr != null){
			if(curr.rollNumber == rollNumber){
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}
	
	public static Student updateGrade(Student head, int rollNumber, char newgrade){
		Student curr = head;
		while(curr != null){
			if(curr.rollNumber == rollNumber){
				curr.grade = newgrade;
			}
			curr = curr.next;
		}
		return head;
	}
	
	public static void display(Student head){
		Student curr = head;
		while(curr != null){
			System.out.print(curr.rollNumber+"->");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}


	public static void main(String[] a){
		Student head = null;
		
		//begin of the list
		head = addStudentatBegin(head,new Student(42, "Manoj", 21, 'A'));
		head = addStudentatBegin(head, new Student(41, "Sita", 20, 'B'));
		head = addStudentatBegin(head, new Student(40, "Ram", 22, 'A'));
		display(head);
		
		//end of the list
		head = addStudentatEnd(head, new Student(43, "Rajesh", 23, 'C'));
		display(head);
		
		//add node at a pos
		head = addStudentatPos(head, new Student(44, "Sri", 20, 'B'), 2);
		
		display(head);
		
		//deleteStudent by RollNumber
		head = deleteStudent(head, 44);
		display(head);
		
		//search for student by rollNumber
		Student found = searchStudent(head, 43);
		if (found != null) {
			System.out.println("Found the person with rollNum "+found.rollNumber+" : " + found.name);
		}

		//update grade by rollNumber
		head = updateGrade(head, 41, 'A');
		Student updated = searchStudent(head, 41);
		if (updated != null)
			System.out.println("Grade updated for rollNumber " + updated.rollNumber + " to: " + updated.grade);
	}
}