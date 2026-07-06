class LRUCache {
    int capacity;
    int size;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = size;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        delete(map.get(key));
        insert(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        
        if (!map.containsKey(key)) {
            if (size >= capacity) {
            map.remove(tail.prev.key);
            delete(tail.prev);
            size--;
        }
            Node node = new Node(key, value);
            insert(node);
            map.put(key, node);
            size++;
        } else {
            map.get(key).val = value;
            delete(map.get(key));
            insert(map.get(key));
        }
    }

    void insert(Node node) {
       node.prev = head;
       node.next = head.next;
       head.next.prev = node;
       head.next = node;
    }

    void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }

 
}
