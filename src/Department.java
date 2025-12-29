import java.util.ArrayList;

public class Department {

    final String departmentName;
    final ArrayList<Employee> employees = new ArrayList<>();

    public Department (String departmentName) {
        this.departmentName = departmentName;
    }

    public void addEmployee (Employee employee) {
        employees.add(employee);
    }

    public double getDepartmentPayroll () {
        double total = 0;

        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }
        return total;
    }

    public void displayDepartment() {
        System.out.println("\n=== " + departmentName + " ===");

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }


}
