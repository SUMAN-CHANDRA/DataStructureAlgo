import java.util.HashMap;

//Java code to find the largest subarray 
//with 0 sum 
class LargestSubArraySumZero { 
	// Returns length of the largest subarray 
	// with 0 sum 
	static int maxLen(int arr[], int n) 
	{ 
		int max_len = 0;
		int sum=0;
		HashMap<Integer,Integer> sumPos= new HashMap<Integer,Integer>();

		// Pick a starting point 
		for (int i = 0; i < n; i++) { 
			
			sum=sum+arr[i];
			if(sumPos.get(sum)==null)
			{
				sumPos.put(sum,i);
			}
			else if(sumPos.get(sum)!=null)
			{
				max_len=i-sumPos.get(sum);
			}
			else if(sumPos.get(sum)==0)
			{
				max_len=i+1;
			}
//			else if(arr[i]==0)
//			{
//				max_len=i+1;
//			}
//			
			System.out.println(sumPos);
			System.out.println(max_len);
			// Initialize curr_sum for every 
			// starting point 
//			int curr_sum = 0; 
//
//			// try all subarrays starting with 'i' 
//			for (int j = i; j < n; j++) { 
//				curr_sum += arr[j]; 
//
//				// If curr_sum becomes 0, then update 
//				// max_len 
//				if (curr_sum == 0) 
//					max_len = Math.max(max_len, j - i + 1); 
//			} 
		} 
		return max_len; 
	} 

	public static void main(String args[]) 
	{ 
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, -12 }; 
		//int arr[] = {1,2,3};
		//int arr[] = {1,0,3};
		int n = arr.length; 
		System.out.println("Length of the longest 0 sum "
						+ "subarray is " + maxLen(arr, n)); 
	} 
} 
//This code is contributed by Kamal Rawal 
