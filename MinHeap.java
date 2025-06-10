import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap with a given capacity
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Method to get the index of the parent of a given node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Method to get the index of the left child of a given node
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Method to get the index of the right child of a given node
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Method to swap two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Method to insert a new value into the heap
    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;

        // Restore the heap property by "heapifying up"
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Method to print the current state of the heap
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        // Insert values into the min heap
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(25);

        // Print the heap after inserting elements
        System.out.println("Min Heap:");
        minHeap.printHeap();
    }
}
