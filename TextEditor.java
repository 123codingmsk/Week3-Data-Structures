class StateNode{
    String text;
    StateNode prev;
    StateNode next;

    StateNode(String text){
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {

    static StateNode head = null;
    static StateNode tail = null;
    static StateNode currentState = null;
    static int stateCount = 0;
    static final int max_states = 10;

    static void addState(StateNode state){
        if(currentState != null && currentState.next != null){
            currentState.next.prev = null;
            currentState.next = null;
            tail = currentState;
            stateCount = countStates();
        }
        if(head == null){
            head = state;
            tail = state;
            currentState = state;
            stateCount = 1;
            return;
        }
        tail.next = state;
        state.prev = tail;
        tail = state;
        currentState = state;
        stateCount++;

        if(stateCount>max_states){
            head = head.next;
            head.prev = null;
            stateCount--;
        }
    }

    static void undo(){
        if(currentState != null && currentState.prev != null){
            currentState = currentState.prev;
            return;
        }
        System.out.println("No more Undo Steps");        
    }

    static void redo(){

        if(currentState != null && currentState.next != null){
            currentState = currentState.next;
            return;
        }
        System.out.println("No more redo Steps");        
    }

    static void displayCurrentState(){
        if(currentState != null){
            System.out.println(currentState.text);
            return;
        }
        System.out.println("Editor is empty");
    }

    static int countStates(){
        int c = 0;
        StateNode curr = head;
        while(curr!=null){
            c++;
            curr = curr.next;
        }
        return c;
    }

    public static void main(String[] args){
        StateNode s1 = new StateNode("Hello");
        addState(s1);
        StateNode s2 = new StateNode("Hello Sir");
        addState(s2);
        StateNode s3 = new StateNode("Hello Sir!");
        addState(s3);
        displayCurrentState();
        undo();
        displayCurrentState();
        redo();
        displayCurrentState();
    } 
}