package pkg260midproject;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int userInput;
        Employee employee = new Employee();
        
        while(running) {
            System.out.println("");
            System.out.println(
                """
                1.  Load employee data
                2.  Add new employee
                3.  Remove employee
                4.  Display all employees
                5.  Retrieve employee by id
                6.  Retrieve employees by salary range
                7.  Sort employees by salary
                8.  Sort employees by first name
                9.  Sort employees by last name
                10. Sort employees by ID
                11. Clear all employee data
                12. Exit program
                """
            );
            
            System.out.print("Enter 1 through 12: ");
            
            userInput = input.nextInt();
            switch(userInput) {
                case 1 -> loadEmployeeData(input);
                case 2 -> addNewEmployee(input);
                case 3 -> removeEmployee(input, employee);
                case 4 -> displayAllEmployees();
                case 5 -> getEmployeeByID(input, employee);
                case 6 -> getEmployeesBySalary(input);
                case 7 -> employee.sortBySalary();
                case 8 -> employee.sortByFirstName();
                case 9 -> employee.sortByLastName();
                case 10 -> employee.sortByID();
                case 11 -> employee.clearData();
                case 12 -> running = false;
            }
        }
    }
    
    // Add single employee
    public static void addNewEmployee(Scanner input) {
        System.out.println("\nEnter employee data");
        Employee employee = new Employee();
        System.out.print("First name: ");
        employee.setFirstName(input.next());
        System.out.print("Last name: ");
        employee.setLastName(input.next());
        System.out.print("ID: ");
        employee.setEmployeeID(input.nextInt(), input);
        System.out.print("Salary: ");
        employee.setSalary(input.nextDouble());
        Employee.employees.add(employee);
    }
    
    // Add multiple employees
    public static void loadEmployeeData(Scanner input) {
        System.out.print("\nEnter number of employees to add: ");
        int numEmployees = input.nextInt();
        
        for(int i = 0; i < numEmployees; i++) {
            addNewEmployee(input);
        }
    }
    
    // Remove employee by ID
    public static void removeEmployee(Scanner input, Employee employee) {
        System.out.print("\nEnter ID of employee to remove: ");
        int tempID = input.nextInt();
        
        for(Employee emp : Employee.employees) {
            if(emp.getEmployeeID() == tempID) {
                Employee.employees.remove(emp);
                break;
            }
        }
        
        System.out.println("\nEmployee not found.");
    }
    
    // Display all employee data
    public static void displayAllEmployees() {
        boolean employeesFound = false;
        System.out.println(Employee.headerString());
        for(Employee emp : Employee.employees) {
            employeesFound = true;
            System.out.println(emp.toString());
        }
        
        if(!employeesFound) {
            System.out.println(
                "|                                       " +
                "NO EMPLOYEES FOUND" +
                "                                       |"
            );
        }
    }
    
    // Retrieve employee by ID
    public static void getEmployeeByID(Scanner input, Employee employee) {
        System.out.print("\nEnter employee ID: ");
        int tempID = input.nextInt();
        
        for(Employee emp : Employee.employees) {
            if(emp.getEmployeeID() == tempID) {
                System.out.println(Employee.headerString());
                System.out.println(emp.toString());
                break;
            }
        }
    }
    
    // Retrieve employees in given salary range
    public static void getEmployeesBySalary(Scanner input) {
        System.out.print("\nEnter minimum salary: ");
        double salaryMin = input.nextDouble();
        System.out.print("Enter maximum salary: ");
        double salaryMax = input.nextDouble();
        
        System.out.println(Employee.headerString());
        
        boolean employeesFound = false;
        for(Employee emp : Employee.employees) {
            if(emp.getSalary() >= salaryMin && emp.getSalary() <= salaryMax) {
                System.out.println(emp.toString());
                employeesFound = true;
            }
        }
        if(!employeesFound) {
            System.out.println(
                "|                            " +
                "NO EMPLOYEES FOUND IN GIVEN SALARY RANGE" +
                "                            |"
            );
        }
    }
}
