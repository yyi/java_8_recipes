package tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class UseTasks {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task(1, true, 3, "Defeat the Black Knight"),
                new Task(2, true, 5, "Answer the Bridgekeeper"),
                new Task(3, false, 6, "Run away from killer rabbit"),
                new Task(4, true, 4, "Lobbeth thou thy Holy Hand Grenade"),
                new Task(5, false, 5, "Give a shrubbery to the Knights Who Say Ni!")
        );

        double averageDuration = tasks.stream()
                .filter(Task::isActive)
                .mapToInt(Task::getDuration)
                .average()
                .orElse(0.0);

        Map<Boolean, List<Task>> taskMap = tasks.stream()
                .collect(partitioningBy(Task::isActive));

        System.out.println(taskMap);

        System.out.printf(
                "The average duration of the active tasks is %s%n",
                averageDuration);
    }
}

