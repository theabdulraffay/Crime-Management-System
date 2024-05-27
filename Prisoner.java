class Prisoner extends Person{
	String crime; 
	int tenure; 
	int cellNum; 
	Prisoner(String name, int age, boolean gender, String crime, int tenure, int cellNum) {
		super(name, age, gender);
		this.crime = crime;
		this.cellNum = cellNum;
		this.tenure = tenure;
	}
	

}