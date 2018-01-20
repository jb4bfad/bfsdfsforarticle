import java.util.LinkedList;

public class Graph
{
	public Node rootNode;
	public LinkedList nodes=new LinkedList();
	public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
	int size;
	public void setRootNode(Node n)
	{
		this.rootNode=n;
	}

	public Node getRootNode()
	{
		return this.rootNode;
	}

	public void addNode(Node n)
	{
		nodes.add(n);
	}

	//This method will be called to make connect two nodes
	public void connectNode(Node start,Node end)
	{
		if(adjMatrix==null)
		{
			size=nodes.size();
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1;
		adjMatrix[endIndex][startIndex]=1;
	}

	public Node getUnvisitedChildNode(Node n, LinkedList nodes, int[][] adjMatrix, int size)
	{

		int index=nodes.indexOf(n);
		int j=0;
		//System.out.println("\n["+size);
		while(j<size)
		{
			//if(((Node)nodes.get(j)).visited==false) System.out.println("["+index+ "]");
			if(adjMatrix[index][j]==1 && ((Node)nodes.get(j)).visited==false)
			{
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}

	//BFS traversal of a tree is performed by the bfs() function
	public void bfs()
	{
		Bfs d= new Bfs(rootNode, nodes, adjMatrix,size);
		clearNodes();
	}

	//DFS traversal of a tree is performed by the dfs() function
	public void dfs()
	{
		Dfs d= new Dfs(rootNode, nodes, adjMatrix,size);
		clearNodes();
	}


	//Utility methods for clearing visited property of node
	public void clearNodes()
	{
		int i=0;
		while(i<size)
		{
			Node n=(Node)nodes.get(i);
			n.visited=false;
			i++;
		}
	}

	//Utility methods for printing the node's label
	public void printNode(Node n)
	{
		System.out.print(n.label+" ");
	}





}
