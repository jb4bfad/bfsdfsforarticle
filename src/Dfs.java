import java.util.LinkedList;

public class Dfs extends Graph{

    public  Dfs(Node rootNode, LinkedList nodes) {

        //DFS uses Stack data structure
        LinkedList s = new LinkedList();
        s.add(rootNode);
        rootNode.visited = true;
        printNode(rootNode);
        while (!s.isEmpty()) {
           // System.out.print('\n');
          //  Node child2 = (Node)nodes.get(2);
         //   printNode(child2);
            Node n = (Node) s.peekLast();

            Node child =  getUnvisitedChildNode(n);

            if (child != null) {

                child.visited = true;
                printNode(child);
                s.add(child);
            } else {
                s.removeLast();
            }
        }
        //Clear visited property of nodes
        clearNodes();
    }
}
