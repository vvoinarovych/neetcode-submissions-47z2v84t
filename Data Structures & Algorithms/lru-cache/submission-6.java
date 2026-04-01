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
            Node node = map.get(key);
            node.val = value;        
            this.remove(map.get(key));    
        }else{
            map.put(key, new Node(key, value));
        }        
        this.insertHead(map.get(key));

        if(map.size() > cap){
            Node toDelete = tail.prev;
            this.remove(toDelete);
            map.remove(toDelete.key);
        }
    }


    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //h -> 2
    //h  new  2
    private void insertHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private class Node{
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
