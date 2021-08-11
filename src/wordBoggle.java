import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class wordBoggle {

	public static void main(String args[])throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc= Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++)
		{
			int noWords= Integer.parseInt(br.readLine());
			String[] dic = br.readLine().split(" ");
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			String[] s1=br.readLine().split(" ");
			char[][] boggle= new char[n][m];
			int c=0;
			for(int k=0;k<n;k++)
			{
				for(int j=0;j<m;j++)
				{
					boggle[k][j]=s1[c].charAt(0);
					c=c+1;
				}
			}
//			disp(boggle);
			TreeSet<String> ts= new TreeSet<>();
			for(int k=0;k<dic.length;k++)
			{
				int flag=0;
				for(int l=0;l<n;l++)
				{
					for(int j=0;j<m;j++)
					{
						if(boggle[l][j]==dic[k].charAt(0))
						{
							System.out.println(l+"  "+j);
							int[][] visited= new int[n][m];
							//dispInt(visited);
							visited[l][j]=1;
							String r=dfs(1,l,j,boggle,dic[k],visited,n,m);
							visited[l][j]=0;
							if(r.length()!=0)
							{
								ts.add(r);
								flag=1;
								break;
							}
						}
					}
					if(flag==1)
					{
						break;
					}
				}	
			}
			String r="";
			if(ts.size()>0)
			{
				for(String ks:ts)
				{
					r=r+ks+" ";
				}
				System.out.println(r);
			}
			else
			{
				System.out.println(-1);
			}
			
		}
		
	}
	public static String dfs(int pos,int i,int j,char[][] boggle,String s,int[][] visited,int n,int m)
	{
		if(pos==s.length())
		{
			return s;
		}
		
		int[] x= {-1,-1,-1,0,1,1,1,0};
		int[] y= {-1,0,1,1,1,0,-1,-1};
		String ret="";
		for(int k=0;k<x.length;k++)
		{
			if(fes(i+x[k],j+y[k],n,m))
			{
				
				if(s.charAt(pos)==boggle[i+x[k]][j+y[k]] && visited[i+x[k]][j+y[k]]==0)
				{
					System.out.println(s.charAt(pos));
					visited[i+x[k]][j+y[k]]=1;
					String r=dfs(pos+1,i+x[k],j+y[k],boggle,s,visited,n,m);
					visited[i+x[k]][j+y[k]]=0;
					if(r.length()>ret.length())
					{
						ret=r;
					}
				}
			}
		}
		return ret;
	}
	public static boolean fes(int i,int j,int n,int m)
	{
		if(i>=0 && i<n && j>=0 && j<m)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void disp(char[][] boggle)
	{
		for(int i=0;i<boggle.length;i++)
		{
			for(int j=0;j<boggle[0].length;j++)
			{
				System.out.print(boggle[i][j]);
			}
			System.out.println();
		}
	}
	public static void dispInt(int[][] boggle)
	{
		for(int i=0;i<boggle.length;i++)
		{
			for(int j=0;j<boggle[0].length;j++)
			{
				System.out.print(boggle[i][j]);
			}
			System.out.println();
		}
	}

}
