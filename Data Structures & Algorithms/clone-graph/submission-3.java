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
        if(node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node nd = q.poll();

            for(Node n : nd.neighbors){
                if(!map.containsKey(n)){
                    map.put(n, new Node(n.val));
                    q.offer(n);
                }
                map.get(nd).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}