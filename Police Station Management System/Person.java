import java.util.IdentityHashMap;
import java.io.*;

class Person implements Serializable{
	String name; 
	int age; 
	String gender; 
	int ID;
	Person(String name, int age, String gender, int ID) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.ID = ID;
	}

	public String toString() {
		return (" ID " + ID+"\nName : "+name + "\nAge : " + age + "\nGender : " + gender);
	}
}