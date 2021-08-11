import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class assignmentSeven {

	public assignmentSeven() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        int n= Integer.parseInt(inputString);
        ArrayList<ArrayList<Integer>> student= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
          ArrayList<Integer> temp= new ArrayList<Integer>();
          String inputSt= s.nextLine();
          String[] s1=inputSt.split(" ");
          temp.add(Integer.parseInt(s1[0]));
          temp.add(Integer.parseInt(s1[1]));
          student.add(temp);
        }
        ArrayList<ArrayList<Integer>> sortedStudent=sortRange(student);
        action(sortedStudent);
		
	}
	public static ArrayList<ArrayList<Integer>> sortRange(ArrayList<ArrayList<Integer>> student)
	{
		HashMap<Integer,ArrayList<Integer>> hm= new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<Integer> from= new ArrayList<Integer>();
		for(int i=0;i<student.size();i++)
		{
			from.add(student.get(i).get(0));
			if(hm.get(student.get(i).get(0))!=null)
			{
				ArrayList<Integer> temp=hm.get(student.get(i).get(0));
				temp.add(student.get(i).get(1));
				hm.put(student.get(i).get(0),temp);
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(student.get(i).get(1));
				hm.put(student.get(i).get(0),temp);
			}
		}
		ArrayList<Integer> to= new ArrayList<Integer>();
		System.out.println(hm);	
		System.out.println(from);
		Collections.sort(from);
		System.out.println(from);
		for(int i=0;i<from.size();i++)
		{
			System.out.println(hm.get(from.get(i)).get(0));	
			to.add(hm.get(from.get(i)).get(0));
			ArrayList<Integer> temp=hm.get(from.get(i));
			temp.remove(0);
			hm.put(from.get(i),temp);
		}
		System.out.println(to);
		ArrayList<ArrayList<Integer>> ret= new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<from.size();i++)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(from.get(i));
			temp.add(to.get(i));
			ret.add(temp);
		}
		System.out.println(ret);
		return ret;
	}
	public static void action(ArrayList<ArrayList<Integer>> sortedStudent)
	{
		PriorityQueue<Integer> ends= new PriorityQueue<Integer>();
		int start=0;
		int end=0;
		int candie=0;
		int noStudent=0;
		for(int i=0;i<sortedStudent.size();i++)
		{
			start=sortedStudent.get(i).get(0);
			end=sortedStudent.get(i).get(1);
			ends.add(end);
			if(start>ends.peek())
			{
				PriorityQueue<Integer> endsDup=ends;
				while(start>endsDup.peek())
				{
					endsDup.poll();
				}
				if(endsDup.size()>noStudent)
				{
					ends=endsDup;
					noStudent=endsDup.size();
					candie=start;
				}
			}
			else
			{
				noStudent=ends.size();
				candie=start;
			}
		}
		System.out.println(candie);
		System.out.println(noStudent);
		
	}
}
