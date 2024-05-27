import java.util.IdentityHashMap;
import java.io.*;

class Person implements Serializable{
	String name; 
	int age; 
	String gender; 
	int ID;
	Person(String name, int age, boolean gender, int ID) {
		this.name = name;
		this.age = age;
		this.gender = gender ? "Male" : "Female";
		this.ID = ID;
	}

	public String toString() {
		return name + " " + age + " " + gender + " " + ID;
	}
}