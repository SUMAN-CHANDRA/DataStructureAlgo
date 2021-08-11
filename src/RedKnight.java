import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RedKnight {

	public RedKnight() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] pos1=br.readLine().split(" ");
		int i_from=Integer.parseInt(pos1[0]);
		int j_from=Integer.parseInt(pos1[1]);
		String[] pos2=br.readLine().split(" ");
		int i_to=Integer.parseInt(pos2[0]);
		int j_to=Integer.parseInt(pos2[1]);
		path(i_from,j_from,i_to,j_to,n);
		
	}
	public static void path(int i_from,int j_from,int i_to,int j_to,int n)
	{
		int x[]={-2,-2,0,2,2,0};
		int y[]= {-1,1,2,1,-1,-2};
		String z[]= {"UL","UR","R","LR","LL","L"};
		//System.out.println(x.length+" "+z.length);
		int[][] visited= new int[n][n];
		for(int[] row:visited)
		{
			Arrays.fill(row, -1);
		}
		Queue<ArrayList<Integer>> queue= new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> pos= new ArrayList<Integer>();
		//ArrayList<String> pathTo= new ArrayList<String>();
		HashMap<Integer,HashMap<Integer,ArrayList<String>>> pathOfNode = new HashMap<Integer,HashMap<Integer,ArrayList<String>>>();
		ArrayList<String> pathTo=new ArrayList<String>();
		
		HashMap<Integer,ArrayList<String>> te=new HashMap<Integer,ArrayList<String>>();
		te.put(j_from,pathTo);
		pathOfNode.put(i_from,te);
		
		//System.out.println(pathOfNode);
		
		pos.add(i_from);
		pos.add(j_from);
		pos.add(0);
		pos.add(0);
		queue.add(pos);
		visited[i_from][j_from]=0;
		while(queue.size()!=0)
		{
			int i_now=queue.peek().get(0);
			int j_now=queue.peek().get(1);
			int count=queue.peek().get(2);
			queue.remove();
			if(i_now==i_to&&j_now==j_to)
			{
				System.out.println(pathOfNode.get(i_now).get(j_now));
				System.out.println(count);
				break;
			}
			for(int i=0;i<x.length;i++)
			{
				if(possible(n,i_now+x[i],j_now+y[i]))
				{
					if(visited[i_now+x[i]][j_now+y[i]]==-1)
					{
						visited[i_now+x[i]][j_now+y[i]]=0;
						pos= new ArrayList<Integer>();
						pos.add(i_now+x[i]);
						pos.add(j_now+y[i]);
						pos.add(count+1);
						queue.add(pos);
						
							ArrayList<String> pathTo1= pathOfNode.get(i_now).get(j_now);
							HashMap<Integer,ArrayList<String>> te1 = new HashMap<Integer,ArrayList<String>>();
							
							pathTo1.add(z[i]);
							te1.put(j_now+y[i],pathTo1);
							
							pathOfNode.put(i_now+x[i],te1);
							//System.out.println(pathOfNode.get(i_now+x[i]).get(j_now+y[i]));
			
						
					}
					
				}
			}
			//System.out.println(pathOfNode);
		}
		
		
	}
	public static boolean possible(int n,int i,int j)
	{
		if(i>=0&&i<n&&j>=0&&j<n)
		{
			return true;
		}
		return false;
	}

}
