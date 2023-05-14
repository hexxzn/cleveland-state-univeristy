package pkg260midproject;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String firstName, lastName;
    private int employeeID;
    private double salary;
    public static ArrayList<Employee> employees = new ArrayList<>();
    
    Employee() {}
    
    Employee(String firstName, String lastName, int employeeID, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.salary = salary;
        employees.add(this);
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String firstName) {
        this.lastName = firstName;
    }
    
    public int getEmployeeID() {
        return this.employeeID;
    }
    
    public void setEmployeeID(int employeeID, Scanner input) {
        int tempID = employeeID;
        
        while(!isFiveDigits(tempID) || !isAvailable(tempID)) {
            if(!isFiveDigits(tempID)) {
                System.out.println("ID must be 5 digits in length.");
            }
            if(!isAvailable(tempID)) {
                System.out.println("ID already in use.");
            }
            System.out.print("ID: ");
            tempID = input.nextInt();
        }
        
        this.employeeID = tempID;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    private boolean isFiveDigits(int employeeID) {
        return Integer.toString(employeeID).length() == 5;
    }
    
    private boolean isAvailable(int employeeID) {
        for(Employee employee : Employee.employees) {
            if(employee.employeeID == employeeID) {
                return false;
            }
        }
        
        return true;
    }
    
    public void sortBySalary() {
        employees.sort((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()));
    }
    
    public void sortByFirstName() {
        employees.sort((emp1, emp2) -> emp1.getFirstName().compareToIgnoreCase(emp2.getFirstName()));
    }
    
    public void sortByLastName() {
        employees.sort((emp1, emp2) -> emp1.getLastName().compareToIgnoreCase(emp2.getLastName()));
    }
    
    public void sortByID() {
        employees.sort((emp1, emp2) -> Integer.compare(emp1.getEmployeeID(), emp2.getEmployeeID()));
    }
    
    public void clearData() {
        employees.clear();
    }
    
    public static String headerString() {
        return String.format(
            "\n| %-25s | %-25s | %-15s | %-20s |", 
            "FIRST NAME",
            "LAST NAME",
            "ID", 
            "SALARY") + 
                "\n--------------------------------------------------------------------------------------------------";
    }
    
    public String toString() {
        return String.format(
            "| %-25s | %-25s | %-15s | %-20s |", 
            this.firstName,
            this.lastName,
            this.employeeID, 
            "$" + String.format("%1$,.2f", this.salary));
    }
}
