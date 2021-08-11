import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberOfSubSequenceSumToK {

	public NumberOfSubSequenceSumToK() {
		// TODO Auto-generated constructor stub
	}
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
		System.out.println("The value :   "+Count(arr,0,k,0,new ArrayList<Integer>()));
		
	}
	public static int Count(List<Integer> arr,int n,int k,int sum,List<Integer> subArray)
	{
		if(sum==k)
		{
			return 1;
		}
		else if(sum >k)
		{
			return 0;
		}
		else
		{
			if(n+1>arr.size()-1)
			{
				return 0;
			}
			int right=Count(arr,n+1,k,sum,subArray);
			subArray.add(arr.get(n));
			int left=Count(arr,n+1,k,sum+arr.get(n),subArray);
			return left+right;
		}
			
		
	}

}
