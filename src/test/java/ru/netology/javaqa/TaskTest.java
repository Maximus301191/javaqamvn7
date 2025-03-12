package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void ShouldSearchWhenQueryInTitle() {
        String query = "позвонить";
        SimpleTask simpleTask = new SimpleTask(5, "позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchWhenQueryNotInTitle() {
        String query = "позвонить";
        SimpleTask simpleTask = new SimpleTask(5, "пойти гулять");

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchWhenQueryInSubtasks() {
        String query = "Молоко";
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchWhenQueryNotInSubtasks() {
        String query = "Яблоко";
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchWhenQueryInTopic() {
        String query = "версии";
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchWhenQueryInProject() {
        String query = "Нето";
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchWhenQueryNotInTopicOrProject() {
        String query = "Прогулка";
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}

