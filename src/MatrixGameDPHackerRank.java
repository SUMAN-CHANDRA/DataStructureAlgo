import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MatrixGameDPHackerRank {

	public MatrixGameDPHackerRank() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] sn=br.readLine().split(" ");
		int n=Integer.parseInt(sn[0]);
		int m=Integer.parseInt(sn[1]);
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++)
		{
			String s=br.readLine();
			String[] sa=s.split(" ");
			for(int j=0;j<m;j++)
			{
				arr[i][j]=Integer.parseInt(sa[j]);
				
			}
			
		}
		//printARR(arr);
		System.out.println("The value         "+matrixLand(arr));
	}
	public static void printARR(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+"    ");
			}
			System.out.println();
		}
	}
	public static int matrixLand(int[][] Ar) 
	{
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<Ar[0].length;i++)
		{
			int[][] B=Ar;
			int t=dp(B,0,i);
			if(t>=max)
			{
				max=t;
			}
			System.out.println("E     N     D      "+t);
		}
		return max;

    }
	public static int dp(int[][] A,int i,int j) 
	{
		printARR(A);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//System.out.println("I :"+i+"      J :"+j);
		
		if(i<0 || i>=A.length ||j<0 || j>=A[0].length)
		{
			return Integer.MIN_VALUE;
		}
		if(A[i][j]==0)
		{
		 return Integer.MIN_VALUE;
		}
		
		int val=A[i][j];
		A[i][j]=0;
		
		int m=Integer.MIN_VALUE;
		int ret=0;
		int left=dp(A,i,j-1);
		int right=dp(A,i,j+1);
		int down=dp(A,i+1,j);
		//System.out.println("left :"+left+"      right :"+right+"      down :"+down);
		
		if(left==m && right == m && down == m)
		{
			ret=  val;
		}
		else if(i==A.length-1)
		{
			ret=Math.max(Math.max(left+val, right+val),val);
		}
		else
		{
			ret=val+Math.max(Math.max(left, right),down);
		}
		
		System.out.println("left :"+left+"      right :"+right+"      down :"+down+"       return   :"+ret);
		return ret;


    }

}
