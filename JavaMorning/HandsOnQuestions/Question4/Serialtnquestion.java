package HandsOnQuestions;
import java.io.*;

 public class serialtnquestion{ 
	 public static void display(Data d){
		 System.out.println("ID Data: " + d.id);
		 System.out.println("Name Data: " + d.name);
		 System.out.println("Age Data: " + d.age);		 
	 }
	 public static void main(String []args){
		 Data d1 = new Data(1, "manihrudhay", 20);
		 try {
			 System.out.println("\nSerializing\n");
			 FileOutputStream file = new FileOutputStream("dataFile.txt");
			 ObjectOutputStream out = new ObjectOutputStream(file);
			 out.writeObject(d1);
			 out.close();
			 file.close();
			 System.out.println("Data before deserialization:\n ");
			 display(d1);
		 }
		 catch (Exception e) {
			 System.out.println("Exception Caught");
		 }
		 d1 = null;
		 try {
			 System.out.println("\nDeserializing\n");
			 FileInputStream file = new FileInputStream("dataFile.txt");
			 ObjectInputStream in = new ObjectInputStream(file);
			 d1 = (Data) in.readObject();
			 in.close();
			 file.close();
			 System.out.println("\n\nData after deserialization:\n ");
			 display(d1);
		 }
		 catch (Exception e) { 
			 System.out.println("Exception Caught");
		 }
	 }
	 
 }
