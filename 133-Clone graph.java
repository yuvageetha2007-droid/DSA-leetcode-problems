import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        map.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
