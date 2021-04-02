package ru.anura.homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.anura.homework5.model.Task;
import ru.anura.homework5.model.TaskStatus;
import ru.anura.homework5.service.TaskService;

import java.io.IOException;
import java.util.HashMap;

public class TaskServiceTest {
    private TaskService taskService = new TaskService();
    private HashMap<Integer, Task> tasks1 = new HashMap<>();

    /**
     * Проверка чтения из файла
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void taskInputTest() throws IOException, ClassNotFoundException {
        try {
            Task task = new Task(1,
                    "Отчет",
                    "Сделать",
                    "Иванов И.И.",
                    TaskStatus.NEW);
            tasks1 = taskService.input();
            Task task1 = tasks1.get(1);
            Assertions.assertEquals(task1.getId(), task.getId());
            Assertions.assertEquals(task1.getName(), task.getName());
            Assertions.assertEquals(task1.getAbout(), task.getAbout());
            Assertions.assertEquals(task1.getWorker(), task.getWorker());
            Assertions.assertEquals(task1.getStatus(), task.getStatus());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
