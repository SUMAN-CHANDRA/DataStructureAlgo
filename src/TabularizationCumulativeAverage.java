import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TabularizationCumulativeAverage {

	public TabularizationCumulativeAverage() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        int n= Integer.parseInt(inputString);
        String[] inputSt= s.nextLine().split(" ");
        ArrayList<Integer> input =new ArrayList<>();
        for(int i=0;i<n;i++)
        {
           input.add(Integer.parseInt(inputSt[i]));
           
        }
        
        Collections.sort(input);
        System.out.println(input);
        
        int[][] memo = new int[n][n];
        for(int i=0;i<n;i++)
        {
        	 for(int j=0;j<n;j++)
             {
             	memo[i][j]=(Math.abs(input.get(i)-input.get(j)));
             }
        	
        }
        print(memo,input);
        
	}
	public static void print(int[][] memo,ArrayList<Integer> input)
	{
		System.out.println();
		for(int i=0;i<memo.length;i++)
        {
        	 for(int j=0;j<memo.length;j++)
             {
        		 System.out.print(memo[i][j]+"    ");
             }
        	 System.out.println();
        	
        }
		
		System.out.println();
		
	}

}
