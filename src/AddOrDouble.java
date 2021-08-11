
public class AddOrDouble {

	public AddOrDouble() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		int numberToReach=15,count=0;
		int value= numberToReach;
		while(value>0)
		{
			if(value%2==0)
			{
				value=value/2;
			}
			else
			{
				value=value-1;
			}
			count=count+1;
		}
		System.out.println("value "+count);
	}

}
