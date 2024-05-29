import java.io.*;
import java.util.ArrayList;
class Vehicle implements Serializable{
	int number; 
	String type; 
	int chasiNum;

	Vehicle(int number, String type, int chasiNum) {
		this.number = number;
		this.type = type;
		this.chasiNum = chasiNum;
	}

	public String toString() {
		return number + " " + type + " " + chasiNum;
	}

	public static void writeFile(Vehicle p) {
		try {
			File f = new File("Vehicle.ser");
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


	public static ArrayList<Vehicle> readFromFile() {
		ObjectInputStream in;
		ArrayList<Vehicle> lines = new ArrayList<>();
		try {
			in = new ObjectInputStream(new FileInputStream("Vehicle.ser"));

			while (true) {
				Vehicle vehicle = (Vehicle) in.readObject();
				lines.add(vehicle);

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

	public static void delete(int name) {
		ArrayList<Vehicle> temp = readFromFile();
		for(int i = 0; i < temp.size();i++) {
			if(temp.get(i).number == name) {
				temp.remove(i);
				break;
			}
		}

		try {
			File f = new File("Vehicle.ser");
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


	public static Vehicle searchByID(int id) {
		ArrayList<Vehicle> temp = readFromFile();
		for(int i = 0; i < temp.size();i++) {
			if(temp.get(i).chasiNum == id) {
				return temp.get(i);
			}
		}
		return null;
	}





}