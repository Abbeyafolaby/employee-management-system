import java.util.ArrayList;

public class Company {

    String companyName;
    private final ArrayList<Department> departments = new ArrayList<>();

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
                boolean match = switch (type) {
                    case "FullTime" -> employee instanceof FullTimeEmployee;
                    case "PartTime" -> employee instanceof PartTimeEmployee;
                    case "Contractor" -> employee instanceof Contractor;
                    default -> false;
                };

                if (match) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    public String getEmployeeNamesByType(String type) {
        ArrayList<Employee> employees = getEmployeesByType(type);

        if (employees.isEmpty()) {
            return "No employees of type " + type;
        }

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
        if (departments.isEmpty()) {
            return null;  // Explicit check is clearer
        }

        Department highest = departments.getFirst();
        double maxPayroll = highest.getDepartmentPayroll();

        for (int i = 1; i < departments.size(); i++) {  // Start from index 1
            Department dept = departments.get(i);
            double payroll = dept.getDepartmentPayroll();

            if (payroll > maxPayroll) {
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
