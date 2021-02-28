package HandsOnQuestions;

import java.io.Serializable;
import java.util.UUID;

class Data implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UUID serialversionUID = new UUID(100,10);
	 transient int id;
	 transient int age;
	 String name;
	 
	 
	 public Data(int id, String name, int age)
	 {
		 this.id = id;
		 this.name = name;
		 this.age = age;
	 }
}
