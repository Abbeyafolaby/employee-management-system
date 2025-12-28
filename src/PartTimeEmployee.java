public class PartTimeEmployee extends Employee {

    double hourlyRate;
    int hoursWorked;

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
