import java.util.ArrayList;
import java.util.Arrays;
class Police extends Person {
    String post; 
    int salary; 
    String department; 
    int weaponNum; 
    String cases; 

    public Police(String name, int age, boolean gender, int ID,  String post, int salary, String department, int weaponNum, String cases) {
		super(name, age, gender, ID);
        this.post = post;
        this.salary = salary;
        this.department = department;
        this.weaponNum = weaponNum;
        this.cases = cases;
    }

    public String getClassName() {
        return "Police";
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getWeaponNum() {
        return weaponNum;
    }

    public void setWeaponNum(int weaponNum) {
        this.weaponNum = weaponNum;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    @Override
    public String toString() {
        return "Police [post=" + post + ", salary=" + salary + ", department=" + department + ", weaponNum=" + weaponNum
                + ", cases=" + cases + "]";
    }


	
}