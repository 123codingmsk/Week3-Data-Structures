import java.util.*;
public class QueueUsingStack{
	static Stack<Integer> enqueue = new Stack<>();
	static Stack<Integer> dequeue = new Stack<>();
	
	public static void Enqueue(int data){
		enqueue.push(data);
	}	
	
	public static int Dequeue(){
		if(dequeue.isEmpty()){
			while(!enqueue.isEmpty()){
				dequeue.push(enqueue.pop());
			}
		}
		return dequeue.isEmpty() ? -1 : dequeue.pop();
	}
	
	public static void displayEnqueue(Stack<Integer> stack){
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.print(stack.get(i) + " -> ");
		}
		System.out.println("null");
	}
	
	public static void displayDequeue(Stack<Integer> stack){
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.print(stack.get(i) + " -> ");
		}
		System.out.println("null");
	}
	
	public static void main(String[] a){
		Enqueue(1);
		Enqueue(2);
		Enqueue(3);Enqueue(4);
		Enqueue(5);
		displayEnqueue(enqueue);
		Dequeue();
		displayDequeue(dequeue);
		Dequeue();
		displayDequeue(dequeue);
		Dequeue();
		displayDequeue(dequeue);
		Dequeue();
		displayDequeue(dequeue);
		Dequeue();
		displayDequeue(dequeue);
	}
}