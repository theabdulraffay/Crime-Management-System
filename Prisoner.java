import java.io.*;
import java.util.ArrayList;
// import java.io.IOException;
// import java.io.ObjectOutputStream;

class Prisoner extends Person implements Serializable{
	String crime; 
	int tenure; 
	int cellNum; 
	Prisoner(String name, int age, boolean gender, int ID, String crime, int tenure, int cellNum) {
		super(name, age, gender, ID);
		this.crime = crime;
		this.cellNum = cellNum;
		this.tenure = tenure;
	}
	
	public static String getClassName() {
        return "Prisoner";
    }


	public String toString() {
		return super.toString() + " " + crime + " " + tenure + " " + cellNum;
	}

	public static void writeFile(Prisoner p) {
		try {
			File f = new File("Prisoner.ser");
			ObjectOutputStream os;
			if(f.exists()) {
				os = new MyObjectOutputStream(new FileOutputStream(f, true));
			}else {
				os = new ObjectOutputStream(new FileOutputStream(f));
			}

			os.writeObject(p);
			os.close();

		} 
		catch (IOException e) {
			System.out.println("Error in file writing");
		}
	}


	public static ArrayList<Prisoner> readFromFile() {
		ObjectInputStream in;
		ArrayList<Prisoner> lines = new ArrayList<>();
		try {
			in = new ObjectInputStream(new FileInputStream("Prisoner.ser"));

			while (true) {
				Prisoner prisoner = (Prisoner) in.readObject();
				lines.add(prisoner);

			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found");

		}
		catch(EOFException e) {
			return lines;
		}
		catch (IOException e) {
			System.out.println("File not found");
		}
		return lines;
	}

	public static void deletePatient(String name) {
		ArrayList<Prisoner> temp = readFromFile();
		for(int i = 0; i < temp.size();i++) {
			if(temp.get(i).name.equals(name)) {
				temp.remove(i);
				break;
			}
		}

		try {
			File f = new File("Prisoner.ser");
			ObjectOutputStream os;
			
			os = new ObjectOutputStream(new FileOutputStream(f));
			for(int i = 0; i < temp.size(); i++) {
				os.writeObject(temp.get(i));
			}
			os.close();
		}

		catch (IOException e) {
			System.out.println("Error in file writing");
		}
	}
}