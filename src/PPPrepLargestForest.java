//PPPrepLargestForest
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class PPPrepLargestForest
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        int n= Integer.parseInt(inputString);
        //ArrayList<Integer> k= new ArrayList<Integer>();
        ArrayList<ArrayList<Character>> str= new ArrayList<ArrayList<Character>>();
        for(int i=0;i<n;i++)
        {
           String inputSt= s.nextLine();
           ArrayList<Character> chars =new ArrayList<Character>();
            for(int j=0;j<inputSt.length();j++)
            {
                
                chars.add(inputSt.charAt(j));
            }
            str.add(chars);
        }
        int ret=0,max=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(str.get(i).get(j)=='T')
                {
                     ret=dfs(str,i,j,0);
                     System.out.println("RET		"+ret);
                }
                if(ret>max)
                {
                	max=ret;
                }
              
            }
            
           
        }

        
        System.out.println(max);
    }
    public static int dfs(ArrayList<ArrayList<Character>> str,int i,int j,int count)
    {
    	str.get(i).remove(j);
        str.get(i).add(j,'W');
        count=count+1;
        print(str);
        System.out.println(count);
        int x[]={-1,0,1,0};
        int y[]={0,1,0,-1};
        for(int k=0;k<x.length;k++)
        {
            if(i+x[k]>=0 && i+x[k]<str.size() && j+y[k]>=0 && j+y[k]<str.size() )
            {
           	 if(str.get(i+x[k]).get(j+y[k])=='T')
            	{
                	count= dfs(str,i+x[k],j+y[k],count);
            	}
            }
        }
        return count;
    }
    public static void print(ArrayList<ArrayList<Character>> str)
    {
    	 for(int i=0;i<str.size();i++)
         {
             for(int j=0;j<str.get(0).size();j++)
             {
            	 System.out.print(str.get(i).get(j));
             }
             System.out.println();
         }
    	
    }
    
    }