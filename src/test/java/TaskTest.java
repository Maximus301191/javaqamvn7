import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {


@Test
public void ShouldSearchContainsWord() {
    String query = "Молоко";
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

    Task task = new Task();

    task.matches(String.valueOf(simpleTask));
    task.matches(String.valueOf(epic));
    task.matches(String.valueOf(meeting));

    boolean expected = true;

    boolean actual = task.matches(query);
    Assertions.assertEquals(expected, actual);
}
}

