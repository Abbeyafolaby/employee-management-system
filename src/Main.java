public class Main {

    public static void main(String[] args) {

        Company company = new Company("NorthStar");

        Department department1 = new Department("Engineering Department");
        Department department2 = new Department("Sales Department");
        Employee employee1 = new FullTimeEmployee("Alice", "E001", 5000);
        Employee employee2 = new PartTimeEmployee("Bob", "E002", 150,8);
        Employee employee3 = new Contractor("Charlie", "E0003", 3000);
        Employee employee4 = new FullTimeEmployee("Diana", "E004", 4500);


        company.addDepartment(department1);
        company.addDepartment(department2);
        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        department2.addEmployee(employee3);
        department2.addEmployee(employee4);


        company.displayCompanyPayroll();

        System.out.println(
                "\nAll FullTime Employees: " +
                        company.getEmployeeNamesByType("FullTime")
        );


    }
}
