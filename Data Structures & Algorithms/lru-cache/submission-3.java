class LRUCache {
    Map<Integer, Node> map;
    int cap;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        this.remove(node);
        this.insertHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            this.remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        this.insertHead(newNode);
        map.put(key, newNode);
        if(map.size() > cap){
            Node nodeToRemove = tail.prev;
            this.remove(nodeToRemove);
            map.remove(nodeToRemove.key);            
        }
    }

    public void insertHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
