class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    private final int capacity;
    private int minFreq;

    private final Map<Integer, Node> keyMap;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);
        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }
        if (keyMap.size() == capacity) {
            DoublyLinkedList minList = freqMap.get(minFreq);
            Node removed = minList.removeLast();

            keyMap.remove(removed.key);
        }
        Node newNode = new Node(key, value);
        keyMap.put(key, newNode);

        freqMap.computeIfAbsent(
            1, f -> new DoublyLinkedList()
        ).addFirst(newNode);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.computeIfAbsent(
            node.freq, f -> new DoublyLinkedList()
        ).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */