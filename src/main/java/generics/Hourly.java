package generics;

public class Hourly extends Employee {
    private double rate = 50.0;
    private double hours = 40;

    public Hourly() {}

    public Hourly(int id, String name, double rate, double hours) {
        super(id, name);
        this.rate = rate;
        this.hours = hours;
    }

    @Override
    public double getPay() {
        return rate * hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "rate=" + rate +
                ", hours=" + hours +
                "} " + super.toString();
    }
}
