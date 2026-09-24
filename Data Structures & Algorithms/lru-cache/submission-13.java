class LRUCache {
    Map<Integer, Node> map;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1, -1);
    int cap;
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
        this.insertToHead(node);
        return node.v;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.v = value;
            this.remove(node);
        }else{
            node = new Node(key, value);
            map.put(key, node);
        }
        insertToHead(node);
        if(map.size() > cap){
            Node toDelete = tail.prev;
            map.remove(toDelete.k);
            this.remove(toDelete);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //h - v - n
    private void insertToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;        
    }

    public class Node{
        Node next;
        Node prev;
        int k;
        int v;

        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
}
