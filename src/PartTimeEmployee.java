public class PartTimeEmployee extends Employee {

    private final double hourlyRate;
    private final int hoursWorked;

    public PartTimeEmployee(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary () {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getType() {
        return "PartTimeEmployee";
    }

}
