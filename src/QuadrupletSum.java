import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QuadrupletSum {

	public QuadrupletSum() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		ArrayList<PairSum> arrPair= new ArrayList<>();
		int[] a= {10,2,3,4,5,9,7,8};
		int k=23;
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				PairSum ps= new PairSum(i,j,a[i]+a[j]);
				arrPair.add(ps);
			}
		}
		arrPair.sort((PairSum m,PairSum n)->(m.getSum()-n.getSum()));
		disp(arrPair);
		List<List<Integer>> result= new ArrayList<>();
		Set<String> visited=new HashSet<>();
		for(int i=0;i<arrPair.size()-1;i++)
		{
			for(int j=i+1;j<arrPair.size();j++)
			{
				if((arrPair.get(i).getSum()+arrPair.get(j).getSum())==k)
				{
					
					int a1=arrPair.get(i).getF();
					int a2=arrPair.get(j).getF();
					int b1=arrPair.get(i).getR();
					int b2=arrPair.get(j).getR();
					
					String s=uni(a1,a2,b1,b2);
					if(!visited.contains(s))
					{
						if(a1!=a2 && a1!=b2 && b1!=a2 && b1!=b2)
						{
							List<Integer> temp = new ArrayList<>();
							temp.add(a[a1]);
							temp.add(a[a2]);
							temp.add(a[b1]);
							temp.add(a[b2]);
							System.out.println(temp);
							visited.add(s);
						}
					}
					
				}
			}
		}
//		rec(result,arrPair,0,arrPair.size()-1,23);
//		System.out.println(result);
		
	}
	public static String uni(int a,int b,int c,int d)
	{
		TreeSet<Integer> ts= new TreeSet<>();
		ts.add(a);ts.add(b);ts.add(c);ts.add(d);
		String s="";
		for(int k:ts)
		{
			s=s+Integer.toString(k);
		}
		return s;
	}
	public static void disp(ArrayList<PairSum> arrPair)
	{
		for(int i=0;i<arrPair.size();i++)
		{
			System.out.print(arrPair.get(i).getSum()+"["+arrPair.get(i).getF()+","+arrPair.get(i).getR()+"]"+"   ");
		}
		System.out.println();
	}
	public static PairSum cmp(PairSum a,PairSum b)
	{
		return (a.getSum() > b.getSum() )? a:b;
	}
	public static void rec(List<List<Integer>> result,ArrayList<PairSum> arrPair,int i,int j,int k)
	{
		if(i>j)
		{
			return;
		}
		if(i==j)
		{
			return;
		}
		if((arrPair.get(i).getSum()+arrPair.get(j).getSum())==k)
		{
			
			int a1=arrPair.get(i).getF();
			int a2=arrPair.get(j).getF();
			int b1=arrPair.get(i).getR();
			int b2=arrPair.get(j).getR();
			
			if(a1!=a2 && a1!=b2 && b1!=a2 && b1!=b2)
			{
				System.out.println();
				List<Integer> temp = new ArrayList<>();
				temp.add(a1);
				temp.add(a2);
				temp.add(b1);
				temp.add(b2);
				System.out.println(temp);
				result.add(temp);
				rec(result,arrPair,i,j-1,k);
				rec(result,arrPair,i+1,j,k);
				
			}
		}
		else if(arrPair.get(i).getSum()+arrPair.get(j).getSum()>k)
		{
			rec(result,arrPair,i,j-1,k);
		}
		else
		{
			rec(result,arrPair,i+1,j,k);
		}
	}

}
class PairSum
{
	int f;
	int r;
	int sum;
	public PairSum(int f, int r, int sum) {
		super();
		this.f = f;
		this.r = r;
		this.sum = sum;
	}
	/**
	 * @return the f
	 */
	public int getF() {
		return f;
	}
	/**
	 * @param f the f to set
	 */
	public void setF(int f) {
		this.f = f;
	}
	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}
	/**
	 * @return the sum
	 */
	public int getSum() {
		return sum;
	}
	/**
	 * @param sum the sum to set
	 */
	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
