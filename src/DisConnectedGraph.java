import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DisConnectedGraph 
{

	public static void main(String args[])
	{
		Integer arr[][]= {{1,2},{2,3},{1,3},{2,4},{4,3},{5,6}};
		List<List<Integer>> ListContactPoint= twoDArrayToList(arr);
		System.out.println(ListContactPoint);
		HashMap<Integer,List<Integer>> routes= new HashMap<Integer,List<Integer>>();
		HashMap<Integer,Boolean> covered= new HashMap<Integer,Boolean>();
		int NoOfNode=6;
		for(int j=1;j<=NoOfNode;j++)
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
		//List<Boolean> Covered= new ArrayList<>();
		for(int j=1;j<=NoOfNode;j++)
		{
			covered.put(j,false);
		}
		System.out.println(covered);
		Track(covered,1,routes);
		
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
	public static void Track(HashMap<Integer,Boolean> covered,int node,HashMap<Integer,List<Integer>> routes)
	{
		if(covered.get(node))
		{
			System.out.println("leaf"+node);
		}
		else
		{
			System.out.println("root "+node);
			covered.put(node,true);
			List<Integer> connect=routes.get(node);
			System.out.println("The next "+connect);
			for(int j=0;j<=routes.size();j++)
			{
				System.out.println("start "+covered+"   "+connect.get(j)+"   "+connect);
				Track(covered,connect.get(j),routes);
				System.out.println("end  "+covered+"   "+connect.get(j)+"   "+connect);
				
			}
			
		}
	}

}
