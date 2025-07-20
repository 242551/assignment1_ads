public class MyMinHeapTest {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        // Test 1: Add elements
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(2);

        System.out.println("After insertions: ");
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");  // Expecting: 1 2 3 5 8
        }
        System.out.println();

        // Test 2: Peek and poll
        heap.add(10);
        heap.add(4);
        System.out.println("Peek (expect 4): " + heap.peek()); // 4
        System.out.println("Poll (expect 4): " + heap.poll()); // 4
        System.out.println("Peek after poll (expect 10): " + heap.peek()); // 10

        // Test 3: Add more after poll
        heap.add(6);
        heap.add(0);
        heap.add(7);
        System.out.println("New min (expect 0): " + heap.peek()); // 0

        // Test 4: Final extraction in order
        System.out.print("Final heap extraction: ");
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");  // Expecting: 0 6 7 10
        }
        System.out.println();
    }
}
