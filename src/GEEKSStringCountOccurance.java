
public class GEEKSStringCountOccurance {

	public GEEKSStringCountOccurance() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		GfG obj = new GfG();
		String S="GeeksforGeeks";
		String T="Gks";
		System.out.println("the value       :"+obj.rec(S,T,"",0));
	}
}
	class GfG
	{
	    int  subsequenceCount(String S, String T)
	    {
	    	return rec(S,T,"",0);	
	    }
	    public int rec(String S,String T,String str,int pos)
	    {
	    	System.out.println(" S : "+S+"    str : "+str+"    pos  : "+pos );
	        if(pos==S.length())
	        {
	            if(str.length()==T.length())
	            {
	                int l=str.length()-1;
	                if(str.charAt(l)!=T.charAt(l))
	                {
	                    return 0;
	                }
	                else
	                {
	                    return 1;
	                }
	            }
	            else
	            {
	                return 0;
	            }
	        }
	        if(str.length()==T.length())
	        {
	            int l=str.length()-1;
	            if(str.charAt(l)!=T.charAt(l))
	            {
	                return 0;
	            }
	            else
	            {
	                return 1;
	            }
	        }
	        if(str.length()!=0)
	        {
	            int right,left;
	            int l=str.length()-1;
	            if(str.charAt(l)!=T.charAt(l))
	            {
	                return 0;
	            }
	            else
	            {
	                left=rec(S,T,str+Character.toString(S.charAt(pos)),pos+1);
	                right=rec(S,T,str,pos+1);
	                return left+right;
	            }
	            
	        }
	        int left=rec(S,T,str+Character.toString(S.charAt(pos)),pos+1);
	        int right=rec(S,T,str,pos+1);
	        return left+right;
	        
	        
	        
	    }
	}


