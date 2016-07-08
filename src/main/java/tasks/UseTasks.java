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
                new Task(5, false, 5, "Give a shrubbery to the Knights Who Say Ni!"),
                new Task(6, true, 1, "Get taunted by Frenchman"),
                new Task(7, true, 2, "Weigh a witch against a duck"),
                new Task(8, false, 4, "Dance and sing and imitate Clark Gable"),
                new Task(9, true, 3, "Build a giant wooden hare"),
                new Task(10, false, 2, "Attack Swamp Castle"),
                new Task(11, true, 1, "Applaud Tim the Enchanter"),
                new Task(12, false, 2, "Oppress peasant")
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

