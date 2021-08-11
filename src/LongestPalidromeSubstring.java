import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalidromeSubstring {

	public LongestPalidromeSubstring() {
		// TODO Auto-generated constructor stub
	}
	public static void main (String args[])throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String no= br.readLine();
		int n= Integer.parseInt(no);
		for(int i=0;i<n;i++)
		{
			String word=br.readLine();
			System.out.println(lps(word,0,word.length()-1,""));
		}
	}
	public static int lps(String s,int i,int j,String pal)
	{
		if(i>j)
		{
			System.out.println(pal);
			return 0;
		}
		if(i==j)
		{
			System.out.println(pal);
			return 1;
		}
		
		if((s.charAt(i)==s.charAt(j)))
		{
			pal=pal+s.charAt(i);
			return 2+lps(s,i+1,j-1,pal);
			
		}
			return Math.max(lps(s,i+1,j,pal),lps(s,i,j-1,pal));
			
		
	}

}
