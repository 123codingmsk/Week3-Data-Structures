// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class ArrayQueue{
    int[] arr;
    int front;
    int rear;
    int size =  5;
    int currsize;
    
    ArrayQueue(){
        arr = new int[size];
        front = -1;
        rear = -1;
        currsize = 0;
    }
    
    public void push(int x){
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        if(rear == -1){
            front = 0;
            rear = 0;
        }else{
            rear = rear + 1;
        }
        arr[rear] = x;
        currsize++;
    }
    
    public int poll(){
        if(front == -1){
            System.out.println("Queue is empty");
            return -1;
        }
        int pop = arr[front];
        if(currsize == 1){
            front = -1;
            rear = -1;
        }else{
            front = front + 1;
        }
        currsize--;
        return pop;
    }
    
    public int peek(){
        if(front == -1){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }
    
    public boolean isEmpty(){
        return rear == -1;
    }
    
    public int size() {
        return currsize;
    }
}

public class QueueImpUArr {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);queue.push(4);queue.push(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}