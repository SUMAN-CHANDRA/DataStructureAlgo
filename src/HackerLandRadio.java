import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class HackerLandRadio 
{ 
	static int antenna(int arr[], int k) 
	{ 
		int ant=0;
		int i=1,left=arr[0];
		ArrayList<Integer> leftList= new ArrayList<Integer>();
		ArrayList<Integer> sortList= new ArrayList<Integer>();
		for(int j=0;j<arr.length;j++)
		{
			sortList.add(arr[j]);
		}
		Collections.sort(sortList);
		System.out.println(sortList);
		
//		while(i<arr.length)
//		{
//			if(arr[i])
//			
//		}

		return ant; 
	} 

	public static void main(String args[]) 
	{ 
		//int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
		int arr[] = {7,2,4,6,5,9,12,11};
		//int arr[] = {1,0,3};
		int n = arr.length; 
		System.out.println("Length of the longest 0 sum "
						+ "subarray is " + antenna(arr, n)); 
	} 
} 
//This code is contributed by Kamal Rawal 
