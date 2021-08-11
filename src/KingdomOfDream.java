import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class KingdomOfDream {

	public KingdomOfDream() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		  Scanner sc = new Scanner(System.in); 
	      String inp = sc.nextLine();
	      ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
	      int test=Integer.parseInt(inp);
	      for(int i=0;i<test;i++)
	      {
	    	  ArrayList<Integer> temp = new ArrayList<Integer>();
	    	  String l = sc.nextLine();
	    	  String inpt = sc.nextLine();
	    	  String arr[]=inpt.split(" ");
	    	  for(int j=0;j<arr.length;j++)
	    	  {
	    		  temp.add(Integer.parseInt(arr[j]));
	    	  }
	    	  input.add(temp);
	      }
	      for(int i=0;i<test;i++)
	      {
	    	  driver(input.get(i));
	      }
	      
	      
	      
	      
	}
	public static void driver(ArrayList<Integer> lm)
	{
		int count=0;
		int loop=0;
		System.out.println(lm);
		TreeSet<Integer> island= new TreeSet<Integer>();
		TreeSet<Integer> kod= new TreeSet<Integer>();

		for(int i=0;i<lm.size();i++)
	     {
			island.add(lm.get(i));
	     }
		System.out.println(island);
		System.out.println(kod);
		while(island.size()!=0)
		{
			if(island.size()==1)
			{
				kod.add(island.first());
				count=count+island.first();
				island.remove(island.first());
				
			}
			else if(island.size()==2)
			{
				kod.add(island.first());
				int a=island.first();
				island.remove(island.first());
				kod.add(island.first());
				int b=island.first();
				island.remove(island.first());
				
				count = count+Math.max(a, b);
			}
			else if(island.size()>2)
			{
				if(loop!=0)
				{ 	
					int t=island.first();
					island.remove(island.first());
					
					kod.add(island.first());
					int a=island.first();
					island.remove(island.first());
					kod.add(island.first());
					int b=island.first();
					island.remove(island.first());
					island.add(t);
					
					count = count+Math.max(a, b);
					
					
					count=count+kod.first();
					island.add(kod.first());
					kod.remove(kod.first());
					
				}
				else
				{
				kod.add(island.first());
				int a=island.first();
				island.remove(island.first());
				kod.add(island.first());
				int b=island.first();
				island.remove(island.first());
				
				
				count = count+Math.max(a, b);
				
				
				count=count+kod.first();
				island.add(kod.first());
				kod.remove(kod.first());
				}
					
			}
			loop=loop+1;
			System.out.println("ISLAND		"+island);
			System.out.println("KOD		"+kod);
		}
		System.out.println(count);
	 }

}
