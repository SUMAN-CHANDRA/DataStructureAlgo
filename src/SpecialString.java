
public class SpecialString {

	public SpecialString() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		String s="mnonopoO";
	}
	public static boolean even(String s)
	{
		int flag=0;
		for(int i=1;i<s.length();i++)
			{
				if(s.charAt(0)!=s.charAt(i))
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

}
