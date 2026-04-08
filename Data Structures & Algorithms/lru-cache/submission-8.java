class LRUCache {
    int cap;
    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            this.remove(node);
            this.insertHead(node);
            return node.v;
        }
        return -1;
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
        this.insertHead(node);
        if(map.size() > cap){
            Node toDel = tail.prev;
            this.remove(toDel);
            map.remove(toDel.k);
        }
    }

    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insertHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public class Node{
        int k;
        int v;
        Node prev;
        Node next;

        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
}
