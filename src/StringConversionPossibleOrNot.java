import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class StringConversionPossibleOrNot {
	/*Test Case:
	 2
	 deAbCdf
	 ABC
	 aABcdf
	 ABCD
	 aBCAbCAb
	 ABC
	 * */

	public StringConversionPossibleOrNot() {
		// TODO Auto-generated constructor stub
	}
	static ArrayList<Integer> lm;
	public static void main(String args[])
	{
		  Scanner s = new Scanner(System.in);
	      String inputString = s.nextLine();
	      int n= Integer.parseInt(inputString);
	        for(int i=0;i<n;i++)
	        {
	           String s1= s.nextLine();
	           String s2= s.nextLine();
	           lm=new ArrayList<>();
	           int memo[][]= new int [s1.length()][s2.length()];
	   			for (int[] row :memo) 
	   			{ 
	               Arrays.fill(row, -1); 
	           } 
	   			int ret=lcs(s1,s2,0,0,memo,lm);
	   			System.out.println(ret);
	   			System.out.println(lm);
	   			if(ret==s2.length()&&caseSense(s1))
	   			{
	   				System.out.println("YES");
	   			}
	   			else
	   			{
	   				System.out.println("NO");
	   			}
	           
	        }
	}
	public static ArrayList<ArrayList<Integer>> allLcs(String s1,String s2)
	{
		ArrayList<ArrayList<Integer>> allLcs= new ArrayList<ArrayList<Integer>>();
		while(s1.length()>=s2.length())
		{
	        lm=new ArrayList<>();
	        int memo[][]= new int [s1.length()][s2.length()];
			for (int[] row :memo) 
   			{ 
               Arrays.fill(row, -1); 
   			} 
			int ret=lcs(s1,s2,0,0,memo,lm);
   			System.out.println(ret);
   			System.out.println(lm);
   			if(ret==s2.length())
   			{
   				System.out.println("YES");
   				allLcs.add(lm);
   			}
   			else
   			{
   				System.out.println("NO");
   			}
   			
			
		}
		
		return null;
		
	}
	public static String dropString(String s1)
	{
		String ret="";
		for(int i=0;i<s1.length();i++)
		{
			if(!lm.contains(i))
			{
				ret=ret+Character.toString(s1.charAt(i));
			}
		}
		return ret;
	}
	public static boolean caseSense(String s1)
	{
		int flag=0;
		int j=0;
		for(int i=0;i<s1.length();i++)
		{
			if(!lm.contains(i))
			
				if((int)s1.charAt(i)>=65 && (int)s1.charAt(i)<=90)
				{
					flag=1;
					break;
				}
			
		}
		if(flag==1)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	public static int lcs(String s1,String s2,int p1,int p2,int[][] memo,ArrayList<Integer> lm)
	{
		if(p1>=s1.length()||p2>=s2.length())
		{
			return 0;
		}
		if(memo[p1][p2]!=-1)
		{
			return memo[p1][p2];
		}
		if((int)s1.charAt(p1)==(int)s2.charAt(p2))
		{
			lm.add(p1);
			memo[p1][p2]=1+lcs(s1,s2,p1+1,p2+1,memo,lm);
			return memo[p1][p2];
		}
		if((int)s1.charAt(p1)>=97 && (int)s1.charAt(p1)<=122)
		{
			int uC=((int)s1.charAt(p1))-32;
			if(uC==(int)s2.charAt(p2))
			{
				lm.add(p1);
				memo[p1][p2]=1+lcs(s1,s2,p1+1,p2+1,memo,lm);
				return memo[p1][p2];
			}
		}
		
		memo[p1][p2]=Math.max(lcs(s1,s2,p1+1,p2,memo,lm), lcs(s1,s2,p1,p2+1,memo,lm));
		return memo[p1][p2] ;
	}

}
