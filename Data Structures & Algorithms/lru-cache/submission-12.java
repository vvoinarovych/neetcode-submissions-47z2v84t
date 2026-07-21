class LRUCache {
    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node p = map.get(key);
            this.delete(p);
            this.insertToHead(p);
            return p.v;
        }
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.v = value;
            this.delete(node);
        }else{
            node = new Node(key, value);
            map.put(key, node);
        }
        this.insertToHead(node);
        if(map.size() > cap){
            Node toDelete = tail.prev;
            map.remove(toDelete.k);
            this.delete(toDelete);
        }
    }

    private void delete(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    //A -(C) > B
    private void insertToHead(Node node){
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;        
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
