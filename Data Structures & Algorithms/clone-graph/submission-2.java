/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while(!q.isEmpty()){
            Node n = q.poll();
            
            for(Node nd : n.neighbors){
                if(!map.containsKey(nd)){
                    map.put(nd, new Node(nd.val, new ArrayList<>()));
                    q.offer(nd);
                }
                map.get(n).neighbors.add(map.get(nd));
            }
        }
        return map.get(node);
    }
}