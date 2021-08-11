import java.util.Arrays;

public class ThreeDNoOfPath {

	public ThreeDNoOfPath() {
		// TODO Auto-generated constructor stub
	}
	public static int count=0;
	public static void main(String args[])
	{
		int[] start= {2,7,4};
		int[] dest= {9,9,9};
		int d=Math.max(Math.max(dest[0], dest[1]),dest[2])+1;
//		System.out.println(d);
		dfs(start[0],start[1],start[2],d,d,d,dest[0],dest[1],dest[2]);
//		dfs(2,7,4,10,10,10,9,9,9);
//		dfs(0,0,0,3,3,3,2,2,2);
		System.out.println("val:"+count);
	}
	public static void dfs(int i,int j,int k,int n,int m,int o,int di,int dj,int dk)
	{
		if(i==di && j==dj && k==dk)
		{
			count=count+1;
			return;
		}
		int x[]= {1,0,1};
		int y[]= {1,1,0};
		int z[]= {0,1,1};
		for(int p=0;p<x.length;p++)
		{
			if(fes(i+x[p],j+y[p],k+z[p],n,m,o))
			{
				dfs(i+x[p],j+y[p],k+z[p],n,m,o,di,dj,dk);
			}
		}
	}
	public static boolean fes(int i,int j,int k,int n,int m,int o)
	{
		if(i>=0 && i<n && j>=0 && j<m && k>=0 && k<o )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
