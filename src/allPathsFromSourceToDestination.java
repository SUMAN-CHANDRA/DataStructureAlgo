import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class allPathsFromSourceToDestination {

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sn=br.readLine().split(" ");
		int n=Integer.parseInt(sn[0]);
		int node=Integer.parseInt(sn[1]);
		ArrayList<ArrayList<Integer>> input= new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++)
		{
			String s=br.readLine();
			String[] sa=s.split(" ");
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(Integer.parseInt(sa[0]));
			tmp.add(Integer.parseInt(sa[1]));
			input.add(tmp);
		}
		String d=br.readLine();
		int dest=Integer.parseInt(d);
		System.out.println("Input       "+input);
	HashMap<Integer,ArrayList<Integer>> graph =adjList(input);
	System.out.println("graph        "+graph);
	System.out.println("source        "+node);
	System.out.println("destination          "+dest);	
	
	
//	bfs(graph,node);
//	System.out.println();
//	System.out.println();
//	bfsLevelIndicator(graph,node);
	bfsAllPaths(graph,node,dest);
	}
	public static HashMap<Integer,ArrayList<Integer>> adjList(ArrayList<ArrayList<Integer>> input)
	{
		HashMap<Integer,ArrayList<Integer>> graph= new HashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<input.size();i++)
		{
			if(graph.get(input.get(i).get(0))!=null)
			{
				ArrayList<Integer> temp=graph.get(input.get(i).get(0));
				temp.add(input.get(i).get(1));
				graph.put(input.get(i).get(0),temp);
			}
			else
			{
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.add(input.get(i).get(1));
				graph.put(input.get(i).get(0),temp);
			}
		}
		return graph;
	}
	public static void bfsAllPaths(HashMap<Integer,ArrayList<Integer>> graph,int node,int dest)
	{
		ArrayList<ArrayList<Integer>> queue= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path= new ArrayList<Integer>();
		path.add(node);
		while(queue.size()!=0)
		{
			path =queue.get(0);
			int last=path.get(path.size()-1);
			if(last==dest)
			{
				System.out.print(path+"        ");
			}
			queue.remove(0);
			for (int i = 0; i < graph.get(last).size(); i++) 
			{ 
	            if (isNotVisited(graph.get(last).get(i),path)) 
	            { 
	            	ArrayList<Integer> newpath= new ArrayList<Integer>(); 
	                newpath.add(graph.get(last).get(i)); 
	                queue.add(newpath); 
	            }
			}

		}
	}
	public static boolean isNotVisited(int x, ArrayList<Integer> path) 
	{ 
	    int size = path.size(); 
	    for (int i = 0; i < size; i++)  
	        if (path.get(i) == x)  
	            return false;  
	    return true; 
	} 
}

