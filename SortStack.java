import java.util.Stack;

public class SortStack{

    
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();      
            sortStack(stack);             
            insertInSortedOrder(stack, top); 
        }
    }

    public static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, value);
        stack.push(top);
    }

    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted stack (ascending):");
        printStack(stack);
    }
}