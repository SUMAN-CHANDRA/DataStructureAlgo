import java.util.Scanner;

public class RemoveConsecutiveString {

	public RemoveConsecutiveString() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		  Scanner s = new Scanner(System.in);
	      String inputString = s.nextLine();
	      int n= Integer.parseInt(inputString);
	        for(int i=0;i<n;i++)
	        {
	           String s1= s.nextLine();
	           System.out.println(driver(s1));
	        }
	}
	public static String driver(String s)
	{
		String sub="";
		int i=0;
		while(i<s.length()-1)
		{
			if(s.charAt(i)==s.charAt(i+1))
			{
				i=i+1;
			}
			else
			{
				sub=sub+Character.toString(s.charAt(i));
				i=i+1;
			}
		}
		if(s.charAt(s.length()-1)!=sub.charAt(sub.length()-1))
		{
			sub=sub+Character.toString(s.charAt(s.length()-1));
		}
		return sub;
		
	}

}
