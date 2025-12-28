import java.util.ArrayList;

public class Company {

    String companyName;
    ArrayList<Department> departments = new ArrayList<>();

    public Company (String companyName) {
        this.companyName = companyName;
    }

    public void addDepartment (Department department) {
        departments.add(department);
    }

    public double getTotalPayroll () {
        double total = 0;

        for (Department department : departments) {
            total += department.getDepartmentPayroll();
        }
        return total;

    }


    public ArrayList<Employee> getEmployeesByType(String type) {
        ArrayList<Employee> result = new ArrayList<>();

        for (Department department : departments) {
            for (Employee employee : department.employees) {

                if (type.equals("FullTime") && employee instanceof FullTimeEmployee ||
                    type.equals("PartTime") && employee instanceof PartTimeEmployee ||
                        type.equals("Contractor") && employee instanceof  Contractor
                ) {
                    result.add(employee);
                }

            }
        }
        return result;
    }

    public String getEmployeeNamesByType(String type) {
        ArrayList<Employee> employees = getEmployeesByType(type);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < employees.size(); i++) {
            result.append(employees.get(i).getName());
            if (i < employees.size() - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }


    public Department getDepartmentWithHighestPayroll() {
        Department highest = null;
        double maxPayroll = 0;

        for (Department dept : departments) {
            double payroll = dept.getDepartmentPayroll();

            if (highest == null || payroll > maxPayroll) {
                highest = dept;
                maxPayroll = payroll;
            }
        }

        return highest;
    }

    public void displayCompanyPayroll() {
        for (Department dept : departments) {
            dept.displayDepartment();
        }

        System.out.println("\nTotal Company Payroll: $" + getTotalPayroll());

        Department highest = getDepartmentWithHighestPayroll();
        System.out.println(
                "Department with Highest Payroll: " +
                        highest.departmentName +
                        " ($" + highest.getDepartmentPayroll() + ")"
        );
    }



}
