class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        this.remove(node);
        this.addToHead(node);
        return node.v;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            map.get(key).v = value;
            this.remove(node);
        }else{
            node = new Node(key, value);
            map.put(key, node);
        }
        this.addToHead(node);
        if(map.size() > cap){
            Node toRemove = tail.prev;
            map.remove(toRemove.k);
            this.remove(toRemove);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;        
    }

    class Node{
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
