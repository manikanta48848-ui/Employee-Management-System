package com.Project.Modules;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 EmployeeService service=new EmployeeService();
		boolean ch=true;
		while(ch)
		{
			displayMenu();
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
                  int id =service.getUniqueId(sc);
                  sc.nextLine();

                  String name=InputValidator.getString(sc, "Enter Employee Name: "); 
                
                  String department = InputValidator.getString(sc, "Enter Employee Department: "); 

                  double salary =InputValidator.getDouble(sc, "Enter Salary: ");

                  Employee emp =new Employee(id, name, salary,department);
                  //Passing Employee emp Object to AddEmployee Method
                  service.addEmployee(emp);

                  System.out.println("Employee Added Successfully.");
                  break;
                  
			case 2:
				int searchid=InputValidator.getInt(sc, "Enter Employee ID To Search: ");
				service.searchEmployee(searchid);
			break;
			
			case 3:
				  System.out.println("1. Delete By ID");
				  System.out.println("2. Delete By Name");
				    int deleteChoice = InputValidator.getInt(sc, "Enter your choice: ");
				    switch(deleteChoice) {
				        case 1:
				            int d = InputValidator.getInt(sc, "Enter Employee ID: ");
				            service.deleteEmployee(d);
				            break;
				        case 2:
				        	sc.nextLine();
				            String n = InputValidator.getString(sc, "Enter Employee Name: ");
				            service.deleteEmployee(n);
				            break;
				        default:
				            System.out.println("Invalid Choice");
				    }

				    break;
				    
			case 4:System.out.println("Updating  Salary...");
			int sid=InputValidator.getInt(sc,"Enter The ID Where The Salary To Be Updated");
			double ssal=InputValidator.getDouble(sc,"Enter The New Salary");
			service.updateSalary(sid, ssal);
			break;
			
			case 5:System.out.println("Sorting The Choice to Sortby");
             System.out.println("1. Sort By ID");
             System.out.println("2. Sort By Name");
             System.out.println("3. Sort By Salary");
             int sortChoice = InputValidator.getInt(sc, "Enter choice: ");
             switch(sortChoice) {
             case 1:
                 System.out.println("1. Ascending");
                 System.out.println("2. Descending");
                 int idOrder = InputValidator.getInt(sc, "Enter order: ");
                 service.sortById(idOrder == 1);
                 break;

             case 2:
                 service.sortByName();
                 break;

             case 3:
                 System.out.println("1. Ascending");
                 System.out.println("2. Descending");
                 int salaryOrder = InputValidator.getInt(sc, "Enter order: ");
                 service.sortBySalary(salaryOrder == 1);

                 break;

             default:
                 System.out.println("Invalid choice");
             }
             break;

			case 6:
				service.highSalary();
			break;
			
			case 7:System.out.println("Displaying Department Wise Employees...");
			String dept=InputValidator.getString(sc, "Enter The Department Name");
			service.displayEmployeesByDepartment(dept);
			break;
			
			case 8:System.out.println("Showing Employee Detailes");
			service.displayEmployees();
			break;
			
			case 9:System.out.println("Thank You For Using The Application..");
			ch=false;
			break;
			default:
				System.out.println("Please Enter The Valid Choice");
			}
		}

	}
	private static void displayMenu() {
	    System.out.println("\n========================================");
	    System.out.println("      EMPLOYEE MANAGEMENT SYSTEM");
	    System.out.println("========================================");
	    System.out.println("1. Add Employee");
	    System.out.println("2. Search Employee");
	    System.out.println("3. Delete Employee");
	    System.out.println("4. Update Salary");
	    System.out.println("5. Sort Employees");
	    System.out.println("6. Display Highest Salary Employee");
	    System.out.println("7. Display Department-wise Employees");
	    System.out.println("8. Display Complete Employee Detailes");
	    System.out.println("9. Exit");
	    System.out.println("========================================");
	    System.out.print("Enter your choice: ");
	}

}
