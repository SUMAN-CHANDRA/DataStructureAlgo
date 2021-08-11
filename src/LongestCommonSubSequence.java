import java.util.Arrays;

public class LongestCommonSubSequence {

	public LongestCommonSubSequence() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		
		String s1="HARRY";
		String s2="SALLY";
		int arr[][]= new int [s1.length()][s2.length()];
		for (int[] row :arr) { 
            Arrays.fill(row, -1); 
        } 
		
		for(int i=0;i<s1.length();i++)
		{
			for(int j=0;j<s2.length();j++)
			{
				System.out.print(arr[i][j]+"    ");
				
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("The length of longest common subsequence is       "+lcs(s1,s2,0,0,arr));
	}
	public static int lcs(String s1,String s2,int i1,int i2,int arr[][])
	{
		System.out.println();
		if(i1==s1.length()-1||i2==s2.length()-1)
		{
			return 0;
		}
		else if(arr[i1][i2]!=-1)
		{
			return arr[i1][i2];
		}
		else if(s1.charAt(i1)==s2.charAt(i2))
		{
			arr[i1][i2]=1+lcs(s1,s2,i1+1,i2+1,arr);
			return (arr[i1][i2]);
		}
		else
		{
			arr[i1][i2]=max(lcs(s1,s2,i1+1,i2,arr),lcs(s1,s2,i1,i2+1,arr));
			return (arr[i1][i2]);
		}
	}
	public static int max(int i1,int i2)
	{
		if(i1>i2)
		{
			return i1;
		}
		else
		{
			return i2;
		}
	}

}
