import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   int id,salary,choice;
   String name,position;
   Scanner sc = new Scanner(System.in);
   EmployeeManagement management =new EmployeeManagement();
   while(true){
       System.out.println("Enter 1 to add employess. 2 to exit");
        choice=sc.nextInt();
       if(choice!=1){
           break;
       }
       System.out.println("Enter Employee ID: ");
       id= sc.nextInt();
       sc.nextLine();
       System.out.println("Name: ");
       name= sc.nextLine();
       System.out.println("position :");
       position=sc.nextLine();
       System.out.println("Salary :");
       salary= sc.nextInt();
       Employee a1 = new Employee(id,salary,name,position);
       management.addEmployee(a1);
   }
   management.sorting();
   management.display();
    }
}
class Employee{
    int employee_id;
    String name;
    String position;
    int salary;

    Employee(int e,int s,String n,String p){
        this.employee_id=e;
        this.name=n;
        this.position=p;
        this.salary=s;
    }
    public int getEmployeeId(){
        return employee_id;
    }
    public String getEmployeeName(){
        return name;
    }
    public String getEmployeePosition(){
        return position;
    }
    public int getEmployeeSalary(){
        return salary;
    }


}

class EmployeeManagement{
    ArrayList<Employee> employee;
    EmployeeManagement(){
        employee = new ArrayList<Employee>();
    }
    public void addEmployee(Employee list){
       employee.add(list);
    }

    public void sorting(){
        for(int i=0;i< employee.size();i++){
              for(int j=1;j<employee.size()-i;j++){
                  if(employee.get(j).getEmployeeSalary()<employee.get(j-1).getEmployeeSalary()){
                      Collections.swap(employee,j,j-1);
                  }
              }
        }
    }
    public void display(){
        for(Employee a : employee){
            System.out.println("Employee");
            System.out.println("ID: "+a.getEmployeeId());
            System.out.println("Name: "+a.getEmployeeName());
            System.out.println("Position: "+a.getEmployeePosition());
            System.out.println("Salary: "+a.getEmployeeSalary());
        }
    }
}

