public abstract class Employee implements Payable {

    protected String name;
    protected String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }


    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + name + " (" + employeeId + ") - Salary: $" + calculateSalary();
    }


}
