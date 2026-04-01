class LRUCache {
    int cap;
    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.cap = capacity;
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
        map.put(key, newNode);   
        this.insertHead(newNode);
        if(map.size() > cap){
            Node node = tail.prev;
            this.remove(node);
            map.remove(node.key);
        }
    }

    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    //d 1 2 3 4 
    private void insertHead(Node node){
        node.next = head.next;
        head.next.prev = node;        
        node.prev = head;
        head.next = node;
    }

    public class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
