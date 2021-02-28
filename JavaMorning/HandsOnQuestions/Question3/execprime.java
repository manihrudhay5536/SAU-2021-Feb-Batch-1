package HandsOnQuestions;

import java.util.*;
import java.math.*;


public class excepprime  {
	
	public static void main(String[] args)
	{
		for(int i=0;i<=100;i++)
		{
			try
			{
				if(prim(i))
				{
					throw new isPrime();
				}
			}
			catch(isPrime e)
			{
				System.out.println(i+": Prime Number");
			}
		}
	}
	
	public static boolean prim(int p)
	{ 
		if(p==1)return false;
		
	    for(int i=2;i<Math.sqrt(p);i++) {if(p%i==0)return false;}
	    
	    return true;
	}

}
