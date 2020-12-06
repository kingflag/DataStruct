package offer.interviews.stack;

import java.util.Stack;

public class SortStack {

    private static Stack<Integer> tmpStack = new Stack();

    public static Stack sort(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() < pop) {
                stack.push(tmpStack.pop());
            }
            tmpStack.push(pop);
        }
        return tmpStack;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(1);
//        System.out.println(sort(stack));
        test(stack);
    }

    public static void test(Stack<Integer> stack){
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() < pop){
                stack.push(tmpStack.pop());
            }
            tmpStack.push(pop);
        }
        System.out.println(tmpStack);
    }
}
