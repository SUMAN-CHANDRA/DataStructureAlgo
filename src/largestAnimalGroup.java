import java.util.TreeSet;

public class largestAnimalGroup {

	public largestAnimalGroup() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main(String args[])
	{
		int arr[][]= {{1,1,0,0,1},{1,0,1,0,0},{0,0,1,0,0},{0,0,0,0,1},{0,0,0,1,1}};
		
		TreeSet<Integer> tr = new TreeSet<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(arr[j][i]==1)
				{
					tr.add(dfs(arr,j,i,0));
				}
				
			}
		}
		
		
		System.out.println("Value"+tr);
	}
	public static void printArr(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+"	");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean canMove(int row,int column,int[][] grid)
	{
		if(row>=0 && column>=0 && column <grid.length && row<grid[0].length && grid[row][column]==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int dfs(int[][] arr,int row ,int column,int count)
	{

		arr[column][row]=-5;
		count=count+1;
		//printArr(arr);
		int rowCal[]= {-1,-1,-1,0,0,0,1,1,1};
		int colCal[]= {-1,0,1,-1,0,1,-1,0,1};
		for(int i=0;i<rowCal.length;i++)
		{
			//System.out.println(canMove(row+rowCal[i],column+colCal[i],arr)+"	row : "+(row+rowCal[i])+"	column : "+(column+colCal[i]));
			if(canMove(row+rowCal[i],column+colCal[i],arr))
			{
				
				count=dfs(arr,column+colCal[i],row+rowCal[i],count);
			}
		}
		printArr(arr);
		return count;
		
		
	}
		
	

}
