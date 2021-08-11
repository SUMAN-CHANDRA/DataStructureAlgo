import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyDistribution {

	public CandyDistribution() 
	{
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])throws IOException
	{
		int arr[]= {2,2,3,7};
		System.out.println("The no of steps : "+candyStep(arr,arr.length-1));
	}
	public static int candyStep(int arr[],int n)
	{
		//System.out.println(n);
		int flag=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[0]!=arr[i])
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			
			return 1;
		}
		else if(n==0)
		{
			System.out.println(n);
			return 0;
		}
		else
		{
			int arr1[]=arr,a1=0;
			int arr2[]=arr,a2=0;
			int arr5[]=arr,a5=0;
			for(int i=0;i<arr.length;i++)
			{
				if(i!=n)
				{
					arr1[i]=arr[i]+1;
					arr2[i]=arr[i]+2;
					arr5[i]=arr[i]+5;
					
				}
				
			}
			a1=candyStep(arr1,n-1);
			a2=candyStep(arr2,n-1);
			a5=candyStep(arr5,n-1);
			if(a1<=a2&&a1<=a5)
			{
				return a1;
			}
			else if(a2<=a1&&a2<=a5)
			{
				return a2;
			}
			else
			{
				return a5;
			}
		}
		
	}

}
