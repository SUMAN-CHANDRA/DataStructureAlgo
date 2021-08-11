import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HackerRankMaxMin {

	public static void main (String args[])throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		List<Integer> arr= new ArrayList<Integer>();
		System.out.println("enter the array of number by entering space");
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println("enter value of k");
        int k = Integer.parseInt(br.readLine());
		System.out.println("The array :   "+arr);
		System.out.println("The value :   "+Count(arr,0,0,0,2,new ArrayList<Integer>()));
		
	}
	public static int Count(List<Integer> arr,int n,int max,int min,int k,List<Integer> subArray)
	{
		if(subArray.size()==k)
		{
			System.out.println(subArray);
			return max-min;
			
		}
		else
		{
			System.out.println(subArray);
			if(n+1>arr.size()-1)
			{
				return -1;
			}
			int right=Count(arr,n+1,max,min,k,subArray);
			subArray.add(arr.get(n+1));
			if(arr.get(n+1)>max)
			{
				max=arr.get(n+1);
			}
			else if(arr.get(n+1)<min)
			{
				min=arr.get(n+1);
			}
			int left=Count(arr,n+1,max,min,k,subArray);
			if(left<0&&right<0)
			{
				return -1;
			}
			else if(left<0&&right>0)
			{
				return right;
			}
			else if(left>0&&right<0)
			{
				return left;
			}
			else
			{
				if(left > right)
				{
					return right;
				}
				return left;
			}
		}
			
		
	}

}

