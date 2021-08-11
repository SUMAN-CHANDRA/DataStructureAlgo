import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BFSByMe {

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
		System.out.println(input);
	HashMap<Integer,ArrayList<Integer>> graph =adjList(input);
	HashMap<Integer,ArrayList<Integer>> graph1=adjListBidirectional(input);
	System.out.println(graph);
	System.out.println(graph1);
//	bfs(graph,node);
//	System.out.println();
//	System.out.println();
//	bfsLevelIndicator(graph,node);

	HashMap<Integer,ArrayList<Integer>> allBfs =new HashMap<Integer,ArrayList<Integer>>();
	for(int i=1;i<=node;i++)
	{
		
		allBfs.put(i,bfsOfAllNode(graph1,i));
	}
	System.out.println();
	System.out.println(allBfs);
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
	public static void bfs(HashMap<Integer,ArrayList<Integer>> graph,int node)
	{
		ArrayList<Integer> queue= new ArrayList<Integer>();
		HashMap<Integer,Boolean> visited= new HashMap<Integer,Boolean>();
		
		visited.put(node,true);
		queue.add(node);
		
		while(queue.size()!=0)
		{
			node =queue.get(0);
			visited.put(node,true);
			System.out.print(node+"        ");
			queue.remove(0);
			if(graph.get(node)!=null)
			{
				ArrayList<Integer> t=graph.get(node);
				for(int i=0;i<t.size();i++)
				{
					if(visited.get(t.get(i))==null)	
					{
						queue.add(t.get(i));
					}
				
				}
			}
			
		
	}
	}
	public static void bfsLevelIndicator(HashMap<Integer,ArrayList<Integer>> graph,int node)
	{
		ArrayList<Integer> queue= new ArrayList<Integer>();
		ArrayList<Integer> level= new ArrayList<Integer>();
		int l=0;
		HashMap<Integer,Boolean> visited= new HashMap<Integer,Boolean>();
		visited.put(node,true);
		queue.add(node);
		level.add(l);
		
		while(queue.size()!=0)
		{
			node =queue.get(0);
			l =level.get(0);
			visited.put(node,true);
			System.out.print(node+"("+level.get(0)+")"+"        ");
			queue.remove(0);
			level.remove(0);
			if(graph.get(node)!= null)
			{
				l=l+1;
				ArrayList<Integer> t=graph.get(node);
				for(int i=0;i<t.size();i++)
				{
					if(visited.get(t.get(i))==null)	
					{
						queue.add(t.get(i));
						level.add(l);
					}
				
				}
			}
			
		
	}
	}
	public static ArrayList<Integer> bfsOfAllNode(HashMap<Integer,ArrayList<Integer>> graph,int node)
	{
		ArrayList<Integer> ret= new ArrayList<Integer>();
		ArrayList<Integer> queue= new ArrayList<Integer>();
		HashMap<Integer,Boolean> visited= new HashMap<Integer,Boolean>();
		
		visited.put(node,true);
		queue.add(node);
		
		while(queue.size()!=0)
		{
			node =queue.get(0);
			queue.remove(0);
			ret.add(node);
			//System.out.print(node);
			
			if(graph.get(node)!=null)
			{
				ArrayList<Integer> t=graph.get(node);
				for(int i=0;i<t.size();i++)
				{
					if(visited.get(t.get(i))==null)	
					{
						queue.add(t.get(i));
						visited.put(t.get(i),true);
//						ret.add(node);
					}
				
				}
			}
			
		
	}
		return ret;
	}
	public static HashMap<Integer,ArrayList<Integer>> adjListBidirectional(ArrayList<ArrayList<Integer>> input)
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
			if(graph.get(input.get(i).get(1))!=null)
			{
				ArrayList<Integer> temp=graph.get(input.get(i).get(1));
				temp.add(input.get(i).get(0));
				graph.put(input.get(i).get(1),temp);
			}
			else
			{
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.add(input.get(i).get(0));
				graph.put(input.get(i).get(1),temp);
			}
		}
		return graph;
	}
}
