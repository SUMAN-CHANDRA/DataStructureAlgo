
public class DPSubString {

public static void main(String args[])
{
	String S="GFGFG";
	String T="GFG";
	System.out.println("the value       :"+dp(S,T,S.length()-1,T.length()-1));
}
public static int dp(String S,String T,int i,int j)
{
//	if(i==0 && j==0)
//	{
//		return 1;
//	}
//	if(j==0)
//	{
//		return 1;
//	}
	if ((i == -1 && j == -1) || j == -1) 
        return 1; 
	if(i==-1)
	{
		return 0;
	}
	System.out.println("   S : "+S.substring(0,i+1)+"        T  :  "+T.substring(0,j+1));
	
	if(S.charAt(i)==T.charAt(j))
	{
		return dp(S,T,i-1,j-1)+dp(S,T,i-1,j);
	}
	else 
	{
		return dp(S,T,i-1,j);
	}
}
}
