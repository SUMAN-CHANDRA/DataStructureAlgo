import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KnapsackProblem01DP 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sn=br.readLine();
		int n=Integer.parseInt(sn);
		for(int i=0;i<n;i++)
		{
			String[] sv=br.readLine().split(" ");
			int[] value = Arrays.stream(sv).mapToInt(Integer::parseInt).toArray();
			String[] sw=br.readLine().split(" ");
			int[] weights = Arrays.stream(sw).mapToInt(Integer::parseInt).toArray();
			String sweight=br.readLine();
			int weight=Integer.parseInt(sweight);
			
			
			int[][] memo = new int[value.length][weight];
			for (int[] row :memo) { 
	            Arrays.fill(row, -1); 
	        }
			
			System.out.println("The value is      "+knapsack(value,weights,weight,0,0,0,memo));
		}
	}
	public static int knapsack(int[] value,int[] weights,int weight,int pos,int maxValue,int maxWeight,int[][] memo)
	{
		if(pos>value.length-1)
		{
			return maxValue;
		}
		if(memo[pos][maxWeight]!=-1)
		{
			return memo[pos][maxWeight];
		}
		if(maxWeight+weights[pos]<=weight)
		{
			int left=knapsack(value,weights,weight,pos+1,maxValue,maxWeight,memo);
			int right=knapsack(value,weights,weight,pos+1,maxValue+value[pos],maxWeight+weights[pos],memo);
			memo[pos][maxWeight]=Math.max(left,right);
			
			return memo[pos][maxWeight];
		}
		
		int left=knapsack(value,weights,weight,pos+1,maxValue,maxWeight,memo);
		memo[pos][maxWeight]=left;
		
		return memo[pos][maxWeight];
		
	}

	

}
