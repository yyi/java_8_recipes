package optionals;

import java.util.Optional;

public class Department {
    private Manager boss;

    public Optional<Manager> getBoss() {
        return Optional.of(boss);
    }

    public void setBoss(Manager boss) {
        this.boss = boss;
    }
}
