class LRUCache {
    Node first = new Node(-1, -1);
    Node last = new Node(-1, -1);
    int cap;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        first.next = last;
        last.prev = first;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        insertFirst(node);
        return node.v;
    }
    
    public void put(int key, int value) {        
        if(map.containsKey(key)){
            map.get(key).v = value;
            removeNode(map.get(key));
        }else{
            map.put(key, new Node(key, value));
        }
        insertFirst(map.get(key));
        if(map.size() > cap){
            Node toDelete = last.prev;
            removeNode(toDelete);
            map.remove(toDelete.k);
        }
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertFirst(Node node){
        node.prev = first;
        node.next = first.next;

        first.next.prev = node;
        first.next = node;
    }

    class Node {
        int k;
        int v;
        Node next;
        Node prev;

        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
}
