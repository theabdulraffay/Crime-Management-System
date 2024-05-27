class Person {
	String name; 
	int age; 
	String gender; 
	Person(String name, int age, boolean gender) {
		this.name = name;
		this.age = age;
		this.gender = gender ? "Male" : "Female";
	}

	public String toString() {
		return name + " " + age + " " + gender;
	}
}