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
    //vertex -> node, edge -> connection between nodes. Set visited -> one for whole graph
    Set<Node> visited = new HashSet<>();
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        map.put(node, new Node(node.val));
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        for(Node nb : node.neighbors){
            if(!map.containsKey(nb)){
                map.put(nb, new Node(nb.val));
                dfs(nb);
            }
            map.get(node).neighbors.add(map.get(nb));
        }
    }
}