class LRUCache {
    int cap;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
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
        Node node = new Node(key, value);
        map.put(key, node);
        this.insertHead(node);
        if(map.size() > cap){
            Node last = tail.prev;
            this.remove(last);
            map.remove(last.key);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // dummy -> next
    // <-    <-
    //
    public void insertHead(Node node){
        node.next = head.next;
        node.next.prev = node;

        node.prev = head;
        head.next = node;        
    }

    public class Node{
        int val;
        int key;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
