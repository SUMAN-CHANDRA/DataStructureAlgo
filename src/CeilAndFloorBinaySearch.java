import java.util.ArrayList;
import java.util.Scanner;

public class CeilAndFloorBinaySearch {

	public CeilAndFloorBinaySearch() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        int n= Integer.parseInt(inputString);
        for(int i=0;i<n;i++)
        {
        	String str[]= s.nextLine().split(" ");
        	ArrayList<Integer> arr= new ArrayList<Integer>();
        	 for(int j=0;j<str.length;j++)
             {
        		 arr.add(Integer.parseInt(str[j]));
             }
//        	 binarySearch(arr);
        }
	}
	public static void binarySearch(ArrayList<Integer> arr,int l,int r)
	{
		if(l<r)
		{
			
		}
		int mid=(int)((l+r)/2);
		
		
	}

}
