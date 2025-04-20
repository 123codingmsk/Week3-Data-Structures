import java.util.*;
class Stack{
    Queue<Integer> q = new LinkedList<>();
    
    public void push(int x){
        q.add(x);
        for(int i=0; i<q.size()-1; i++){
            q.add(q.remove());
        }
    }
    public int pop(){
        return q.remove();
    }
    public int top(){
        return q.peek();
    }
}

class StackusingQ {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);st.push(2);st.push(3);st.push(4);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.top());
    }
}