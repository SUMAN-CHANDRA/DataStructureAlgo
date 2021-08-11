import java.util.ArrayList;

public class PermutationNumber {

	public static void main(String args[])
	{
		int n=4;
		ArrayList<Integer> al=new ArrayList<>();
		for(int i=1;i<=n;i++)
		{
			al.add(i);
		}
		permutation(al,new ArrayList<Integer>());
		
	}
	public static void permutation(ArrayList<Integer> al,ArrayList<Integer> num)
	{
		if(al.size()==0)
		{
			System.out.println(num);
		}
		else
		{
			int i=1;
			while(i<=al.size())
			{
				int t=al.get(i-1);
				num.add(al.get(i-1));
				al.remove(i-1);
				permutation(al,num);
				num.remove(num.size()-1);
				al.add(i-1,t);
				i=i+1;
			}
		}
	}

}
