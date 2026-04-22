class LRUCache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        Node node = map.get(key);
        remove(node);
        insertHead(node);
        return node.v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.v = value;
            remove(node);
        }else{
            node = new Node(key, value);
            map.put(key, node);
        }
        insertHead(node);
        if(map.size() > cap){
            Node nodeToRemove = tail.prev;
            remove(nodeToRemove);
            map.remove(nodeToRemove.k);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertHead(Node node){
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    class Node{
        Node prev;
        Node next;
        int k;
        int v;

        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
}
