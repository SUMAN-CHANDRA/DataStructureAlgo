import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberOfSubArraySumToK {

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
		System.out.println("The value :   "+Count(arr,k,0,-1,0));
		
	}
	public static int Count(List<Integer> arr,int m,int pos,int last,int sum)
	{
		if(last!=-1)
		{
			System.out.println("last!=-1");
			if(pos+1<arr.size())
			{
				System.out.println("pos+1<arr.size()");
				if(last+1==pos)
				{
					System.out.println("last+1==pos");
					int right=Count(arr,m,pos+1,last,sum);
					int left=Count(arr,m,pos+1,pos,sum+arr.get(pos));
					return (left>right)?left:right;
				}
				else
				{
					System.out.println("last+1!=pos "+arr.get(pos));
					//return sum%m;
					return (sum+arr.get(pos))%m;
				}
			}
			else
			{System.out.println("pos+1>arr.size() "+arr.get(pos));
				//return sum%m;
			return (sum+arr.get(pos))%m;
			}
		
		}
		else
		{System.out.println("last==-1");
			if(pos+1<arr.size())
			{System.out.println("pos+1<arr.size()");
				
					int right=Count(arr,m,pos+1,last,sum);
					int left=Count(arr,m,pos+1,pos,sum+arr.get(pos));
					return (left>right)?left:right;

			}
			else
			{
				System.out.println("pos+1>arr.size() "+arr.get(pos));
				return (sum+arr.get(pos))%m;
			}
		}
			
		
	}

}
