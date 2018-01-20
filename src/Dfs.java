import java.util.LinkedList;

public class Dfs extends Graph{
    Graph graph;
    public  Dfs(Node rootNode, LinkedList nodes, int[][] adjMatrix, int size) {

        //DFS uses Stack data structure
        LinkedList s = new LinkedList();
        s.add(rootNode);
        rootNode.visited = true;
        printNode(rootNode);
        while (!s.isEmpty()) {

            Node n = (Node) s.peekLast();

            Node child =  getUnvisitedChildNode(n, nodes, adjMatrix, size);

            if (child != null) {

                child.visited = true;
                printNode(child);
                s.add(child);
            } else {
                s.removeLast();
            }
        }
        //Clear visited property of nodes

    }
}
