import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPathFromAParticularNode 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sn=br.readLine().split(" ");
		int n=Integer.parseInt(sn[0]);
		int edge=Integer.parseInt(sn[1]);
		int[][] edges = new int[edge][2];
		for(int i=0;i<edge;i++)
		{
			String s=br.readLine();
			String[] sa=s.split(" ");
			edges[i][0]=Integer.parseInt(sa[0]);
			edges[i][1]=Integer.parseInt(sa[1]);
		}
		String start=br.readLine();
		int st=Integer.parseInt(start);
		int[] ret=bfs(n,edge,edges,st);
		System.out.println();
		for(int i=0;i<ret.length;i++)
		{
			System.out.print(ret[i]+"        ");
		}
	}
	static int[] bfs(int n, int m, int[][] edges, int s) {
	    
	    HashMap<Integer,Node> map = new HashMap<Integer,Node>(n);
	    int[] result = new int[n];

	    for(int i=0;i<result.length;i++)
	        result[i]=-1;

	    for(int i=0;i<m;i++)
	    {
	        Node parentNode;
	        Node childNode;

	        if(map.containsKey(edges[i][0]))
	            parentNode = map.get(edges[i][0]);
	        else
	        {
	            parentNode = new Node(edges[i][0]);
	            map.put(parentNode.data,parentNode);
	        }
	            

	        if(map.containsKey(edges[i][1]))
	            childNode = map.get(edges[i][1]);
	        else
	        {
	            childNode = new Node(edges[i][1]);
	            map.put(childNode.data,childNode);
	        }
	        
	        parentNode.childrenMap.put(childNode.data,childNode);
	        childNode.childrenMap.put(parentNode.data,parentNode);
	    }

	    System.out.println("Map size:"+map.size());

	    if(!map.containsKey(s))
	        return result;
	        
	    Node startNode = map.get(s);

	    Queue<Node> queue = new LinkedList<Node>();
	    HashSet<Node> visited = new HashSet<Node>();

	    startNode.level = 0;

	    queue.add(startNode);
	    visited.add(startNode);
	    
	    while(!queue.isEmpty())
	    {
	        
	        Node currentNode = queue.poll();
	        
	        result[currentNode.data] = currentNode.level*6; 
	        //Enqueue all the children except those that are already vistied.
	        for(Map.Entry<Integer,Node> pair : currentNode.childrenMap.entrySet())
	        {
	            Node childOfCurrentNode = pair.getValue();

	            if(!visited.contains(childOfCurrentNode))
	            {
	                visited.add(childOfCurrentNode);
	                childOfCurrentNode.level = currentNode.level+1;
	                queue.add(childOfCurrentNode);
	            }        
	        }
	    }

	    return result;


}
}
class Node
{
    int data;
    int level;

    HashMap<Integer,Node> childrenMap = new HashMap<Integer,Node>();

    public Node(int data)
    {
        this.data = data;
    }
}
