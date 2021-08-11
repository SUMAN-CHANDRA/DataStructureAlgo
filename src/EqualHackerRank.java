import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EqualHackerRank {

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
		System.out.println("The array :   "+arr);
		System.out.println("The value :   "+Count(arr,0));
		
	}
	public static int Count(List<Integer> arr,int i)
	{
		if(allNumberEqual(arr)==0)
		{
			return 1;
		}
		else
		{
			List<Integer> arr1=add(arr,1,i);
			List<Integer> arr2=add(arr,2,i);
			List<Integer> arr5=add(arr,5,i);
			if(i+1>arr.size()-1) 
			{
				if(allNumberEqual(arr1)==0||allNumberEqual(arr2)==0||allNumberEqual(arr5)==0)
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				int l=Count(arr1,i+1);
				int m=Count(arr2,i+1);
				int r=Count(arr5,i+1);
				if(l<=m&&l<=r)
				{
					return l;
				}
				else if(r<=m&&r<=l)
				{
					return r;
				}
				else if(m<=l&&m<=r)
				{
					return m;
				}
			}
			
			
		}
		
		
		return 0;
	}
	public static int allNumberEqual(List<Integer> arr)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(0)!=arr.get(i))
			{
				return 1;
			}
		}
		return 0;
	}
	public static List<Integer> add(List<Integer> arr,int n,int pos)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(i!=pos)
			{
				arr.add(i, arr.get(i)+n);
			}
		}
		return arr;
	}
	}

