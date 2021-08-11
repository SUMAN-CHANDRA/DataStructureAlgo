import java.util.Arrays;
import java.util.HashMap;

public class hackerRankTest {

	public static int dp(int[][] memo,HashMap<Integer,Integer> hm,int i,int j,int[] arr)
	{
		System.out.println("i   :  "+i+"     j    :   "+j);
		System.out.println(1);
		if(j==arr.length)
		{
			return j-1+1;
		}
		if(memo[i][j] != -1)
		{
			System.out.println(2);
			return memo[i][j];
		}
		int left=0,right=0;
		if(hm.size()==1)
		{
			System.out.println(3);
			if(hm.get(arr[j+1])==null)
			{
				System.out.println(4);
				hm.put(arr[j+1],1);
			}
			else
			{
				System.out.println(5);
				if(hm.get(arr[j+1]-1)!=null || hm.get(arr[j+1]+1)!=null )
				{
					System.out.println(6);
					hm.put(arr[j+1],hm.get(arr[j+1])+1);
				}
				else
				{
					System.out.println(7);
					return j-i+1;
				}
				
			}
			left=dp(memo,hm,i,j+1,arr);
			if(i-1>=0)
			{
				if(hm.get(arr[i-1])==1)
				{
					hm.remove(arr[i-1]);
				}
				else
				{
					hm.put(arr[i-1],hm.get(arr[i-1])-1);
				}
			}
			if(hm.size()==0) 
			{
			if(hm.get(arr[i+1])==null )
			{
				hm.put(arr[i+1],1);
			}
			else
			{
				hm.put(arr[i+1],hm.get(arr[i+1])+1);
			}
			}
			else
			{
				if(hm.get(arr[i+1]-1)!=null || hm.get(arr[i+1]+1)!=null )
				{
					hm.put(arr[j+1],hm.get(arr[j+1])+1);
				}
				else
				{
					return j-i+1;
				}
			}
			
			right=dp(memo,hm,i+1,j+1,arr);
			return memo[i][j]=Math.max(left,right);
			
		}
		else
		{
			//i,j+1
			if(hm.get(arr[j+1])==null)
			{
				System.out.println(1);
				return j-i+1;
			}
			else
			{
				System.out.println(1);
				hm.put(arr[j+1],hm.get(arr[j+1])+1);
			}
			left=dp(memo,hm,i,j+1,arr);
			if(i-1>=0)
			{
				System.out.println(1);
				if(hm.get(arr[i-1])==1)
				{
					System.out.println(1);
					hm.remove(arr[i-1]);
				}
				else
				{
					System.out.println(1);
					hm.put(arr[i-1],hm.get(arr[i-1])-1);
				}
			}
			if(hm.get(arr[i+1])==null)
			{
				System.out.println(1);
				return j-i+1;
			}
			else
			{
				System.out.println(1);
				hm.put(arr[i+1],hm.get(arr[i+1])+1);
			}
			right=dp(memo,hm,i+1,j+1,arr);
			return memo[i][j]=Math.max(left,right);
		}
		
	}
	public static void main(String args[])
	{
		int[] arr= {0,1,2,1,2,1,3,2,3};
		System.out.println("{0,1,2,1,2,1,3,2,3}");
		int[][] memo= new int[arr.length][arr.length];
		for(int[] row:memo)
		{
			Arrays.fill(row, -1);
		}
		HashMap<Integer,Integer> hm = new HashMap<>();
		hm.put(arr[0],1);
		if(arr[0]==arr[1])
		{
			hm.put(arr[0],2);
		}
		else
		{
			hm.put(arr[1],1);
		}
		
		System.out.println("VALUE   :  "+dp(memo,hm,0,1,arr));
	}

}
