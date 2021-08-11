import java.util.Arrays;

//Java program to find 
//celebrity using two 
//pointers 

class CelebrityProblem 
{ 
	// Person with 2 is celebrity 
	static int MATRIX[][] = { { 0, 1, 0},
	           { 0, 1, 0},
	           { 0, 0, 0}}; 

	// Returns true if a knows 
	// b, false otherwise 
	static boolean knows(int a, int b) 
	{ 
		boolean res = (MATRIX[a][b] == 1) ? 
									true : 
									false; 
		return res; 
	}
	public static int dp(int i,int j,int[][] memo)
	{
		if(i==j)
		{
			return i;
		}
		if(i+1==j) {
		if(knows(i,j))
		{
			if(knows(j,i))
			{
				return memo[i][j]=-1;
			}
			else
			{
				return memo[i][j]=j;
			}
		}
		else
		{
			return memo[i][j]=-1;
		}
		}
		if(memo[i][j]!=0)
		{
			return memo[i][j];
		}
		if(knows(i,j) && knows(j,i))
		{
			memo[i][j] =dp(i+1,j-1,memo);
		}
		else if(knows(i,j))
		{
			memo[i][j] =dp(i+1,j,memo);
		}
		else if(knows(j,i))
		{
			memo[i][j] =dp(i,j-1,memo);
		}
		else
		{
			int l=dp(i+1,j,memo);
			int r=dp(i,j-1,memo);
			memo[i][j] = Math.max(l,r);
		}
		return memo[i][j] ;
	}

	// Driver Code 
	public static void main(String[] args) 
	{ 
		int n = 3;
		int[][] memo=new int[n][n];
//		for(int row[]:memo)
//		{
//			Arrays.fill(row,MATRIX.length+1);
//		}
		int result = dp(0,MATRIX.length-1,memo); 
		if (result == -1) 
		{ 
			System.out.println("No Celebrity"); 
		} 
		else
			System.out.println("Celebrity ID " + 
										result); 
	} 
} 

//This code is contributed by Rishabh Mahrsee 

