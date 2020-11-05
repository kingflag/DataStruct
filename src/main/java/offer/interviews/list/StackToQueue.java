package offer.interviews.list;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作
 *
 * @author kingflag
 */
public class StackToQueue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        // 1-->2-->3-->4-->5......压栈
        stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                // 从stack1出栈...5-->4-->4-->3-->2-->1 压入到stack2   1-->2-->3-->4-->5....
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            push(i);
        }
        System.out.println(stack1.size());
        System.out.println(stack2.size());
        for (int i = 0; i < 100; i++) {
            System.out.println(pop());
        }

    }
}
