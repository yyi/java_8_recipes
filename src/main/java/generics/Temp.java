package generics;

public class Temp extends Hourly {
    public Temp() {}

    public Temp(int id, String name, double rate, double hours) {
        super(id, name, rate, hours);
    }

    @Override
    public String toString() {
        return "Temp{} " + super.toString();
    }
}
