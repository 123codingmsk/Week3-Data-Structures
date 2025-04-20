// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class ArrayStack{
    int[] arr;
    int top;
    int capacity;
    int size = 10;
    
    ArrayStack(){
        arr = new int[size];
        top = -1;
        capacity = size;
    }
    public void push(int x){
        if(top == capacity - 1){
            System.out.println("Stack is full, cant push");
            return;
        }
        top = top + 1;
        arr[top] = x;
    }
    
    public int top(){
        if(top == -1){
            System.out.println("Stack is empty, cant find top");
            return -1;
        }
        return arr[top];
    }
    
    public int pop(){
        if(top == -1){
            System.out.println("Stack is empty, cant pop");
            return -1;
        }
        int pop = arr[top];
        top--;
        return pop;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
}

class StackImpUArr {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}