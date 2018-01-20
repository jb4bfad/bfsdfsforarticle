import java.util.LinkedList;

public class Bfs extends Graph{
    public  Bfs(Node rootNode, LinkedList nodes, int[][] adjMatrix, int size)
    {
        LinkedList q=new LinkedList();
        q.add(rootNode);
        printNode(rootNode);
        rootNode.visited=true;
        while(!q.isEmpty())
        {

            Node n=(Node)q.remove();
            Node child=null;

            while((child=getUnvisitedChildNode(n, nodes,adjMatrix,size))!=null)
            {

                //  Node child2 = (Node)nodes.get(2);
                //   printNode(child2);
                child.visited=true;
                printNode(child);
                q.add(child);
            }
        }
        //Clear visited property of nodes
        clearNodes();
    }
}
