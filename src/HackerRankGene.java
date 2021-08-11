import java.util.HashMap;

public class HackerRankGene {

	public static void main(String args[])
	{
		int reqVal=0;
		String s="GAAATAAA";
		HashMap<Character,Integer> freq= new HashMap<Character,Integer>();
		if(s.length()%4==0)
		{
			reqVal=s.length()/4;
		}
		else
		{
			System.out.println("Not Possible");
		}
		for(int i=0;i<s.length();i++)
		{
			if(freq.get(s.charAt(i))!=null)
			{
				freq.put(s.charAt(i),freq.get(s.charAt(i))+1);
			}
			else
			{
				freq.put(s.charAt(i),1);
			}
		}
		char arr[]= {'A','C','G','T'};
		HashMap<Character,Integer> remove= new HashMap<Character,Integer>();
		HashMap<Character,Integer> add= new HashMap<Character,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(freq.get(arr[i])==null)
			{
				add.put(arr[i],reqVal);
			}
		}
		int minLengthOfSubstring=0;
		for(char k:freq.keySet())
		{
			if(freq.get(k)>reqVal)
			{
				remove.put(k,freq.get(k)-reqVal);
				minLengthOfSubstring=minLengthOfSubstring+freq.get(k)-reqVal;
			}
			else if(freq.get(k)<reqVal)
			{
				add.put(k,reqVal-freq.get(k));
			}
		}
		System.out.println("Remove  "+remove);
		System.out.println("Add  "+add);
		System.out.println("minimum length of substring  "+minLengthOfSubstring);
		int j=0;
//		HashMap<Character,Integer> newMap= new HashMap<Character,Integer>();
		int flag =0;
		int lengthSubString=0;
		while(j<s.length()-minLengthOfSubstring)
		{
			lengthSubString=minLengthOfSubstring+j;
			HashMap<Character,Integer> tempMap= new HashMap<Character,Integer>();
			System.out.println("The substring  "+s.substring(0,lengthSubString));
			for(int k=0;k<s.substring(0,lengthSubString).length();k++)
				{
				if(remove.get(s.charAt(k))!= null)
				{
					if(tempMap.get(s.charAt(k))!=null)
					{
						tempMap.put(s.charAt(k),tempMap.get(s.charAt(k))+1);
					}
					else
					{
						tempMap.put(s.charAt(k),1);
					}
				}
				}
			
//			System.out.println("Remove :      "+remove+"    TempMap     :"+tempMap);
			
		
		for(int i=0;i<s.length()-lengthSubString+1;i++)
		{
			String subString = s.substring(i,i+lengthSubString);
			if(i!=0)
			{
				if(remove.get(s.charAt(i-1))!= null)
				{
				tempMap.put(s.charAt(i-1),tempMap.get(s.charAt(i-1))-1);
				if(tempMap.get(subString.charAt(subString.length()-1))!=null)
				{
					tempMap.put(subString.charAt(subString.length()-1),tempMap.get(subString.charAt(subString.length()-1))+1);
				}
				else
				{
					tempMap.put(s.charAt(i+lengthSubString-1),1);
				}
				}
			}
			
			//String subString = s.substring(i, i+lengthSubString);
			System.out.println("Substring :      "+subString+"    result     :"+accept(subString ,remove )+"    new  result     :"+remove.equals(tempMap));
			System.out.println("Remove :      "+remove+"    TempMap     :"+tempMap);
			if(accept(subString ,remove )==true)
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			break;
		}
		j=j+1;
		}
		if(flag==0)
		{
			System.out.println("Not Possible");
		}
		else
		{
		System.out.println("The length of substring  "+lengthSubString);
		}
	}
	public static boolean accept(String s,HashMap<Character,Integer> hm )
	{
		HashMap<Character,Integer> newMap= new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
			{
			if(hm.get(s.charAt(i))!= null)
			{
				if(newMap.get(s.charAt(i))!=null)
				{
					newMap.put(s.charAt(i),newMap.get(s.charAt(i))+1);
				}
				else
				{
					newMap.put(s.charAt(i),1);
				}
			}
			
			}
		return(hm.equals(newMap));
	}

}
