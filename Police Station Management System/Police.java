import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
class Police extends Person implements Serializable{
    String post; 
    double salary; 
    //String department; 
    int weaponNum; 
    String cases; 

    public Police(String name, int age, String gender, int ID,  String post, double salary, int weaponNum, String cases) {
		super(name, age, gender, ID);
        this.post = post;
        this.salary = salary;
        this.weaponNum = weaponNum;
        this.cases = cases;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nPost : " + post + "\nsalary : " + salary +  "\nWeaponNum : " + weaponNum
                + "\nCases : " + cases);
    }

    public static void writeFile(Police p) {
        try {
            File f = new File("Police.ser");
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


    public static ArrayList<Police> readFromFile() {
        ObjectInputStream in;
        ArrayList<Police> lines = new ArrayList<>();
        try {
            in = new ObjectInputStream(new FileInputStream("Police.ser"));

            while (true) {
                Police police = (Police) in.readObject();
                lines.add(police);

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

    public static void delete(int id) {
        ArrayList<Police> temp = readFromFile();
        for(int i = 0; i < temp.size();i++) {
            if(temp.get(i).ID == id) {
                temp.remove(i);
                break;
            }
        }

        try {
            File f = new File("Police.ser");
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


    public static void update(int id, String changed, double salary) {
        ArrayList<Police> temp = readFromFile();
        for(int i = 0; i < temp.size();i++) {
            if(temp.get(i).ID == id) {
                    temp.get(i).post = changed;
                    temp.get(i).salary = salary;
                    break;
            }
        }

        try {
            File f = new File("Police.ser");
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


    public static Police searchByID(int id) {
        ArrayList<Police> temp = readFromFile();
        for(int i = 0; i < temp.size();i++) {
            if(temp.get(i).ID == id) {
                return temp.get(i);
            }
        }
        return null;
    }


	
}