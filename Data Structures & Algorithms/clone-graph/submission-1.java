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
        map.put(node, new Node(node.val, new ArrayList<>()));
        q.push(node);
        while(!q.isEmpty()){
            Node nd = q.poll();

            for(Node nb : nd.neighbors){
                if(!map.containsKey(nb)){
                    map.put(nb, new Node(nb.val, new ArrayList<>()));
                    q.push(nb);
                }
                map.get(nd).neighbors.add(map.get(nb));
            }
        }
        return map.get(node);
    }
}