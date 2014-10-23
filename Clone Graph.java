/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

 // BFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        cloned.put(node, newNode);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode original = queue.poll();
            UndirectedGraphNode clone = cloned.get(original);
            for (UndirectedGraphNode neighbor : original.neighbors) {
                if (!cloned.containsKey(neighbor)) {
                    newNode = new UndirectedGraphNode(neighbor.label);
                    cloned.put(neighbor, newNode);
                    queue.offer(neighbor);
                }
                clone.neighbors.add(cloned.get(neighbor));
            }
        }
        
        return cloned.get(node);
    }
}


// DFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return clone(node, cloned);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloned) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        cloned.put(node, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (cloned.containsKey(neighbor))
                newNode.neighbors.add(cloned.get(neighbor));
            else
                newNode.neighbors.add(clone(neighbor, cloned));
        }
        return newNode;
    }
}