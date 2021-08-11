
public class HowArrayLooks {

	public HowArrayLooks() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		int noRows=2;
		int noColumns=4;
		
		int count=0;
		
		int arr[][]= new int[noRows][noColumns];
		for(int i=0;i<noRows;i++)
		{
			for(int j=0;j<noColumns;j++)
			{
				arr[i][j]=count;
				count++;
			}
			
		}
		
		for(int i=0;i<noRows;i++)
		{
			for(int j=0;j<noColumns;j++)
			{
				System.out.print(arr[i][j]+"    ");
				
			}
			System.out.println();
		}
	}

}
