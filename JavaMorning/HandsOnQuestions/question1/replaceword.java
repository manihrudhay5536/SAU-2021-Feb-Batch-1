package HandsOnQuestions;
import java.util.Scanner;

public class replaceword {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String");
		String str=sc.nextLine();
		
		System.out.println("Enter regex you want to replace");
		String rep=sc.next();
		
		System.out.println("Enter word you want to replace with");
		String repw=sc.next();
		
		String res=str.replaceAll(rep,repw);
		System.out.println("String after replacement:");
		
		System.out.println(res);
		
		
		
		
	}
	
}
