public class TestMyStackAndQueue {
    public static void main(String[] args) {
        System.out.println("Testing MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek: " + stack.peek()); // 30
        System.out.println("Pop: " + stack.pop());   // 30
        System.out.println("Pop: " + stack.pop());   // 20

        System.out.println("\nTesting MyQueue:");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Peek: " + queue.peek()); // A
        System.out.println("Dequeue: " + queue.dequeue()); // A
        System.out.println("Dequeue: " + queue.dequeue()); // B
    }
}
