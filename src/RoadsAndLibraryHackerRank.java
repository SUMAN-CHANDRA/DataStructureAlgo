import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class RoadsAndLibraryHackerRank {

	public RoadsAndLibraryHackerRank() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sn=br.readLine().split(" ");
		int n=Integer.parseInt(sn[0]);
		int no=Integer.parseInt(sn[1]);
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
		 int [][] graph=adjMatrix(no,input);
		System.out.println();
		System.out.println();
		disp(graph);
		TreeSet<Integer> tr = new TreeSet<Integer>();
		for(int i=0;i<graph.length;i++)
		{
			for(int j=0;j<graph[0].length;j++)
			{
				if(graph[j][i]==1)
				{
					tr.add(dfs(graph,j,i,0));
				}
				
			}
		}
		System.out.println(tr);
		
	}
	public static int [][] adjMatrix(int n,ArrayList<ArrayList<Integer>> input)
	{
		int [][] ret= new int[n+1][n+1];
		for(int[] row: ret)
		{
			Arrays.fill(row,0);
		}
		for(int i=0;i<input.size();i++)
		{
			ret[input.get(i).get(0)][input.get(i).get(1)]=1;
		}
		return ret;
	}
	public static void disp(int [][] ret)
	{
		for(int i=0;i<ret.length;i++)
		{
			for(int j=0;j<ret.length;j++)
			{
				System.out.print(ret[i][j]+"	");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean canMove(int row,int column,int[][] grid)
	{
		if(row>=0 && column>=0 && column <grid.length && row<grid[0].length && grid[row][column]==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int dfs(int[][] arr,int i ,int j,int count)
	{

		arr[i][j]=0;
		count=count+1;
		int rowCal[]= {-1,0,1,0,-1,-1,1,1};
		int colCal[]= {0,1,0,-1,-1,1,-1,1};
		for(int m=0;m<rowCal.length;m++)
		{
			if(canMove(i+rowCal[m],j+colCal[m],arr))
			{
				
				count=dfs(arr,i+rowCal[m],j+colCal[m],count);
			}
		}
		disp(arr);
		
		return count;
		
		
	}
		
	

}


