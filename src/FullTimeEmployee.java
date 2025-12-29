public class FullTimeEmployee extends Employee {

    private final double monthlySalary;


    public FullTimeEmployee(String name, String employeeId, double monthlySalary) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary () {
        return monthlySalary;
    }

    @Override
    public String getType() {
        return "FullTimeEmployee";
    }

}
