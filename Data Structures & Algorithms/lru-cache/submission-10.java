class LRUCache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node toReturn = map.get(key);
            this.remove(toReturn);
            this.insertHead(toReturn);
            return toReturn.v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = null;
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
            Node toDelete = tail.prev;
            this.remove(toDelete);
            map.remove(toDelete.k);
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

    public class Node{
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
