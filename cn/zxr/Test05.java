package cn.zxr;

import java.util.Stack;

public class Test05 {
    static class Node{
        Node(Object val){
            this.val = val;
        }
        Node(){
            val = null;
        }

        public Object getVal() {
            return val;
        }

        private Object val;
        Node next;
    }
    public static void preShow(Node head){
        Stack stack = new Stack();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()){
            Node temp = (Node) stack.pop();
            System.out.print(temp.getVal() + " ");
        }
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node temp = head;
        for(int i = 0; i < 10; i++){
           temp.next = new Node(i) ;
           temp = temp.next;
        }
        preShow(head);
    }
}
