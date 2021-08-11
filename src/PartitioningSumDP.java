import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PartitioningSumDP {

public static void main(String args[])throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String sn=br.readLine();
	int n=Integer.parseInt(sn);
	for(int i=0;i<n;i++)
	{
		String[] sv=br.readLine().split(" ");
		int[] arr = Arrays.stream(sv).mapToInt(Integer::parseInt).toArray();
		
		
		
		System.out.println("The value is      "+partition(arr,0,0,0));
	}
}
public static boolean partition(int[] arr,int sumA,int sumB,int pos)
{
	System.out.println("SUMA     "+sumA+"      SUMB         "+sumB);
	if(pos>arr.length-1)
	{
		if((sumA-sumB)==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	boolean left=partition(arr,sumA+arr[pos],sumB,pos+1);
	boolean right=partition(arr,sumA,sumB+arr[pos],pos+1);
	if(!left && !right)
	{
		return false;
	}
	else
	{
		return true;
	}
	
}




}
