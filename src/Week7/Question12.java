package Week7;

public class Question12 {

    public record Employee( String lastName, String firstName, double hourlyWage, int yearWithCompany){

    }
/*
    public static void main(String[] args) {

        Employee[] employeeData = new Employee[100];

        for(int i = 0; i < 100; i++){
            if (employeeData[i].yearsWithCompany >= 20){
                System.out.println("Employee who has been with the company for 20 years or more is " + employeeData[i].firstName() + " " + employeeData[i].lastName()  + ", hourly wage is " + employeeData[i].hourlyWage() );
            }
        }

        for(Employee employee : employeeData){
            if (employee.yearsWithCompany >= 20){
                System.out.println("Employee who has been with the company for 20 years or more is " + employee.firstName()  + " " + employee.lastName()  + ", hourly wage is " + employee.hourlyWage() );
            }
        }
    }

 */
}
