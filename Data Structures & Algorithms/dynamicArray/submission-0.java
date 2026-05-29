class DynamicArray {
    private int[] arr;
    private int size;
    private int capacity;

    // Constructor
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    // Get element at index i
    public int get(int i) {
        return arr[i];
    }

    // Set element at index i
    public void set(int i, int n) {
        arr[i] = n;
    }

    // Push element at the end
    public void pushback(int n) {
        // Resize if array is full
        if (size == capacity) {
            resize();
        }

        arr[size] = n;
        size++;
    }

    // Pop last element
    public int popback() {
        int val = arr[size - 1];
        size--;
        return val;
    }

    // Double the capacity
    public void resize() {
        capacity = capacity * 2;

        int[] newArr = new int[capacity];

        // Copy old elements
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // Return current size
    public int getSize() {
        return size;
    }

    // Return current capacity
    public int getCapacity() {
        return capacity;
    }
}
