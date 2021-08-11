import java.util.ArrayList;
import java.util.HashMap;

public class ChaoticHackerRank {

	public ChaoticHackerRank() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		int[] q= {1,2,5,3,7,8,6,4};
		minimumBribesTwo(q) ;
	}
	public static void minimumBribes(int[] q) 
    {
    int count=0;
    HashMap<Integer,ArrayList<Integer>> hm= new HashMap<Integer,ArrayList<Integer>>();
    //HashMap<Integer,Integer> prevMap= new HashMap<Integer,Integer>();
    for(int i=0;i<q.length;i++)
    {
        if(hm.get(q[i])==null)
        {
            ArrayList<Integer> al= new ArrayList<Integer>();
            al.add(q[i]-1);
            al.add(i);
            hm.put(q[i],al);
        }
    }
    System.out.println(hm);
    int flag=0;
    for(int i=0;i<q.length;i++)
    {
        int prev=hm.get(i+1).get(0);
        int now=hm.get(i+1).get(1);
        if(now<prev)
        {
            if(prev-now>2)
            {
                flag=1;
                break;
            }
            else
            {
                count=count+prev-now;
            }
        }
    }
    if(flag!=1)
    System.out.println(count);
    else
    System.out.println("Too chaotic");

    }

	public static void minimumBribesTwo(int[] q) 
    {
    int count=0;
    //HashMap<Integer,ArrayList<Integer>> hm= new HashMap<Integer,ArrayList<Integer>>();
    HashMap<Integer,Integer> prevMap= new HashMap<Integer,Integer>();
    ArrayList<Integer> lm = new ArrayList<>();
    for(int i=0;i<q.length;i++)
    {
    	lm.add(i+1);
        prevMap.put(i+1,i);
    }
    System.out.println("Begin :   "+lm);
    int flag=0;
    for(int i=0;i<q.length;i++)
    {
    	if( lm.get(i)!=q[i])
    	{
    		if(lm.get(i+1)==q[i])
    		{
    			count=count+1;
    			int t=lm.get(i+1);
    			lm.remove(i+1);
    			lm.add(i,t);
    		}
    		else if(lm.get(i+2)==q[i])
    		{
    			count=count+2;
    			int t=lm.get(i+2);
    			lm.remove(i+2);
    			lm.add(i,t);
    			
    		}
    		else
    		{
    			 flag=1;
                 break;
    		}
    		System.out.println("IN THE LOOP :      "+lm);
    	}
    	
        
        
    }
    if(flag!=1)
    System.out.println(count);
    else
    System.out.println("Too chaotic");

    }

}
