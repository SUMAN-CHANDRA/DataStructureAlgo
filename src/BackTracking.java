import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BackTracking {

	public BackTracking() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main(String args[])
	{
		int target=130;
		int l=Integer.toString(target).length();// less than 130
		for(int i=3;i<=l;i++)
		{
			for(int j=1;j<i-1;j++)
			{
				System.out.println("Len:"+i+" pivPos:"+j+" target:"+target);
				Integer[] f= {0,1,2,3,4,5,6,7,8,9};
				Integer[] r= {9,8,7,6,5,4,3,2,1,0};
				bt(i,j,1,f,r,"",0,target);
			}
		}
		System.out.println("The value : "+c);
		
	
	}
	public static int c=0;
	public static void bt(int len,int piPos,int pos,Integer[] f,Integer[] r,String s,int m,int target)
	{
		if(s.length()==len)
		{
			if(Integer.parseInt(s)<=target)
			{
				System.out.println(s);
				c=c+1;
			}
			return;
		}
		for(int i=pos;i<10;i++)
		{
			if(m==piPos)
			{
				pos=10-f[i];
				bt(len,piPos,pos,f,r,s+Integer.toString(f[i]),m+1,target);
			}
			else
			{
				if(m>piPos)
				{
					bt(len,piPos,i,f,r,s+Integer.toString(r[i]),m+1,target);
				}
				else
				{
					bt(len,piPos,i,f,r,s+Integer.toString(f[i]),m+1,target);
				}
			}
			
			
		}
		
	}

}
