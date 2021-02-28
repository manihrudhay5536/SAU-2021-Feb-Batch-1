package HandsOnQuestions;

import java.util.*;
import java.util.Map.Entry;  

public class rev_map_keys {  
     public static void main(String args[]) {
   Scanner sc = new Scanner(System.in);
   
  TreeMap <Integer,String> map1 = new TreeMap <Integer,String> ();

  int n=sc.nextInt();
  for(int i=0;i<n;i++)
  {   
	  System.out.print("enter key:");
	  int key=sc.nextInt();
	  
	  System.out.print("enter value:");
	  String val=sc.next();
	  
	  map1.put(key, val);
  }


  System.out.println("Orginal TreeMap content: " + map1);
  System.out.println("Reverse order view of the keys: " +map1.descendingKeySet());
 }
}
