package optionals;

import java.util.Optional;

public class Company {
    private Department department;

    public Optional<Department> getDepartment() {
        return Optional.of(department);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
