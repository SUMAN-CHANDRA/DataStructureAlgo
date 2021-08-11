import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class MaximumDistance {

	public MaximumDistance() 
	{
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		int arr[]= {3,2,1,2,1,4,5,4,2,3};
		HashMap<Integer,ArrayList<Integer>> hm= new HashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<arr.length;i++)
		{
			if(hm.get(arr[i])!=null)
			{
				ArrayList<Integer> temp=hm.get(arr[i]);
				temp.remove(1);
				temp.add(i);
				hm.put(arr[i],temp);
				
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				temp.add(i);
				hm.put(arr[i],temp);
				
			}
			
		}
		TreeSet<Integer> te= new TreeSet<Integer>();
		for(int k:hm.keySet())
		{
			te.add(hm.get(k).get(1)-hm.get(k).get(0));
		}
		System.out.println("The largest : "+te.last());
	}

}
