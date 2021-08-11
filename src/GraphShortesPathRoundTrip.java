import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GraphShortesPathRoundTrip {

	public static void main (String args[])throws IOException
	{
		Integer arr[][]= {{2,6},{3,1},{1,5},{3,5},{4,2},{2,5},{6,4},{1,4}};
		List<List<Integer>> ListContactPoint= twoDArrayToList(arr);
		System.out.println(ListContactPoint);
		HashMap<Integer,List<Integer>> routes= new HashMap<Integer,List<Integer>>();
		int innum=6;
		for(int j=1;j<=innum;j++)
		{
			List<Integer> temp= new ArrayList<Integer>();
		for(int i=0;i<ListContactPoint.size();i++)
		{
			if(ListContactPoint.get(i).get(1)==j)
			{
				temp.add(ListContactPoint.get(i).get(0));
			}
			else if(ListContactPoint.get(i).get(0)==j)
			{
				temp.add(ListContactPoint.get(i).get(1));
			}
		}
		routes.put(j,temp);
		}
		System.out.println(routes);
		ArrayList<Integer> LeftOut= new ArrayList<Integer>();
		for(int i=1;i<=innum;i++)
		{
			LeftOut.add(i);
		}
		System.out.println(LeftOut);
		System.out.println(Count(routes,1,LeftOut,innum));
		
	}
	public static <T> List<List<T>> twoDArrayToList(T[][] twoDArray) {
	    List<T> list = new ArrayList<T>();
	    List<T> mainlist = new ArrayList<T>();
	    for (T[] array : twoDArray) {
	    	list = new ArrayList<T>();
	        list.addAll(Arrays.asList(array));
	        mainlist.add((T) list);
	    }
	    return (List<List<T>>) mainlist;
	}
	public static int Count(HashMap<Integer,List<Integer>> routes,int point,List<Integer> LeftOut,int innum)
	{
		if(point==1&&LeftOut.size()==0)
		{
			return 1;
		}
		else
		{
			if(point==1&&LeftOut.size()<innum)
			{
				return -innum;
			}
			else
			{
			System.out.println("1");
			List<Integer> goToPoint=routes.get(point);
			TreeSet<Integer> value=new TreeSet<Integer>();
			for(int i=0;i<LeftOut.size();i++)
			{
				if(LeftOut.get(i)==point)
				{
					LeftOut.remove(i);
					break;
				}
			}
			System.out.println(LeftOut);
			System.out.println(goToPoint);
			for(int i=0;i<goToPoint.size();i++)
			{
//				if(goToPoint.get(i)!=point)
//				{
					System.out.println(goToPoint.get(i));
					int t=Count(routes,goToPoint.get(i),LeftOut,innum);
					if(t>0)
					{
						value.add(t);
					}
//				}
			}
			return 1+value.last();
			}
		}
		}
		
	
}
