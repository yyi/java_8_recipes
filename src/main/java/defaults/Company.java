package defaults;

public interface Company {
    default String getName() {
        return "Company Name";
    }
}
