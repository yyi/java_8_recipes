package generics;

public class Salaried extends Employee {
    private double salary = 104_000;

    public Salaried() {}

    public Salaried(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    @Override
    public double getPay() {
        return salary / 26;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salaried{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
