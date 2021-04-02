package ru.anura.homework5;

import ru.anura.homework5.model.Task;
import ru.anura.homework5.model.TaskStatus;
import ru.anura.homework5.service.TaskService;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    /**
     * Реализация меню
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TaskService taskService = new TaskService();
        HashMap<Integer, Task> tasks = new HashMap<>();
        Task task = new Task();
        int choice = -1;
        System.out.println();
        while (choice != 0) {
            System.out.println("Для создания новой задачи введите 1, для редактирования введите 2, для удаления - 3\nЧтобы посмотреть все созданные задачи введите 4\nДля выхода введите 0");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введено не число");
            }
            switch (choice) {
                //создание
                case 1:
                    System.out.println("Введите код задачи, ее наименование, описание, исполнителя и присвойте статус(new,in process or done):");
                    task = taskService.create();
                    tasks.put(task.getId(), task);
                    taskService.output(tasks);
                    //tasks = taskService.input();
                    break;
                //редактирование
                case 2:
                    tasks = taskService.input();
                    System.out.println("Введите код задачи, которую вы хотите изменить");
                    int editId = 0;
                    int editChoice = -1;
                    try {
                        editId = scanner.nextInt();
                        task.setId(editId);
                        task = tasks.get(editId);
                        System.out.println("Введите\n1, если хотите изменить имя задачи;\n2, если хотите изменить описание задачи;" +
                                "\n3, если хотите изменить исполнителя задачи;\n4, если хотите изменить статус задачи; ");
                        try {
                            editChoice = scanner.nextInt();
                            if (editChoice != -1) {
                                switch (editChoice) {
                                    //редактирование имени
                                    case 1:
                                        try {
                                            if (task.getId().equals(editId)) {
                                                System.out.println("Введите новое наименование(Вместо пробелов '_'):");
                                                task.setName(scanner.next());
                                                tasks.put(task.getId(), task);
                                                taskService.output(tasks);
                                            }

                                        } catch (NullPointerException e) {
                                            System.out.println("Ошибка, возможно задача, которую Вы хотите отредактировать, не существует");
                                        }
                                        break;
                                    //редактирование описания
                                    case 2:
                                        try {
                                            if (task.getId().equals(editId)) {
                                                System.out.println("Введите новое описание(Вместо пробелов '_'):");
                                                task.setAbout(scanner.next());
                                                scanner.nextLine();
                                                tasks.put(task.getId(), task);
                                                taskService.output(tasks);
                                            }

                                        } catch (NullPointerException e) {
                                            System.out.println("Ошибка, возможно задача, которую Вы хотите отредактировать, не существует");
                                        }
                                        break;
                                    //редактирование исполнителя
                                    case 3:
                                        try {

                                            if (task.getId().equals(editId)) {
                                                System.out.println("Введите нового исполнителя(Вместо пробелов '_'):");
                                                task.setWorker(scanner.next());
                                                tasks.put(task.getId(), task);
                                                taskService.output(tasks);
                                            }

                                        } catch (NullPointerException e) {
                                            System.out.println("Ошибка, возможно задача, которую Вы хотите отредактировать, не существует");
                                        }
                                        break;
                                    //редактирование статуса
                                    case 4:
                                        try {
                                            if (task.getId().equals(editId)) {
                                                System.out.println("Введите новый статус:");
                                                String status = scanner.next();
                                                status = status.toLowerCase();
                                                switch (status) {
                                                    case "new":
                                                        task.setStatus(TaskStatus.NEW);
                                                        break;
                                                    case "in process":
                                                        task.setStatus(TaskStatus.IN_PROCESS);

                                                        break;
                                                    case "done":
                                                        task.setStatus(TaskStatus.DONE);
                                                        break;
                                                }
                                                tasks.put(task.getId(), task);
                                            }
                                            taskService.output(tasks);
                                        } catch (NullPointerException e) {
                                            System.out.println("Ошибка, возможно задача, которую Вы хотите отредактировать, не существует");
                                        }
                                        break;
                                }
                                break;
                            } else break;
                        } catch (InputMismatchException e) {
                            System.out.println("ID введен не числом");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Введено не число");
                    }
                    break;
                //удаление
                case 3:
                    System.out.println("Введите код задачи, которую вы хотите удалить");
                    tasks = taskService.input();
                    int removeId = scanner.nextInt();
                    tasks.remove(removeId);
                    taskService.output(tasks);
                    break;
                //просмотр всех задач
                case 4:
                    System.out.println(taskService.input());
                    break;
            }
        }
    }


}
