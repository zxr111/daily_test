package cn.zxr;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueOfStack<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    public QueueOfStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void add(T t) {
        stack1.push(t);
    }
    public T peek(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueOfStack<Integer> q = new QueueOfStack<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.peek());
        System.out.println(q.peek());
    }
}
