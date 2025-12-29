public class Contractor extends Employee{

    private final double projectPayment;

    public Contractor (String name, String employeeId, double projectPayment) {
        super(name, employeeId);
        this.projectPayment = projectPayment;
    }

    @Override
    public double calculateSalary () {
        return projectPayment;
    }

    @Override
    public String getType() {
        return "Contractor";
    }

}
