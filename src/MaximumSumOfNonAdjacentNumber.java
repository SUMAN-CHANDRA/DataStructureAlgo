import java.util.ArrayList;

public class MaximumSumOfNonAdjacentNumber {

	public MaximumSumOfNonAdjacentNumber() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		int arr[]= {3,2,7,10,15,100};
		//System.out.println(arr);
		ArrayList<Integer> intermediateList= new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(i==0)
			{
				intermediateList.add(arr[i]);
			}
			else if(i==1)
			{
				if(intermediateList.get(0)>=arr[i])
				{
					intermediateList.add(intermediateList.get(0));
				}
				else
				{
					intermediateList.add(arr[i]);
				}
			}
			else
			{
				if(intermediateList.get(i-2)+arr[i]>=intermediateList.get(i-1))
				{
					intermediateList.add(intermediateList.get(i-2)+arr[i]);
				}
				else
				{
					intermediateList.add(intermediateList.get(i-1));
				}
			}
		}
		System.out.println(intermediateList.get(intermediateList.size()-1));
	}

}
