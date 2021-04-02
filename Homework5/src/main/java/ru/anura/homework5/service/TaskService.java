package ru.anura.homework5.service;


import ru.anura.homework5.model.Task;
import ru.anura.homework5.model.TaskStatus;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class TaskService {
    /**
     * Чтение задач из файла
     *
     * @return список задач
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public HashMap<Integer, Task> input() throws IOException, ClassNotFoundException {
        HashMap<Integer, Task> tasks = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Anna\\IdeaProjects\\Homework5\\tasks.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tasks = (HashMap<Integer, Task>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка, файл пуст или не существует");
        }
        return tasks;
    }

    /**
     * Запись задач в файл
     *
     * @param tasks - список задач
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void output(HashMap<Integer, Task> tasks) throws IOException, ClassNotFoundException {
        try {
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Anna\\IdeaProjects\\Homework5\\tasks.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(tasks);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создание новой задачи
     *
     * @return созданную задачу
     */
    public Task create() {
        Scanner scanner = new Scanner(System.in);
        Task task = new Task();
        System.out.println("Введите код задачи");
        task.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Введите наименование задачи");
        task.setName(scanner.nextLine());
        System.out.println("Введите описание задачи");
        task.setAbout(scanner.nextLine());
        System.out.println("Введите исполнителя задачи");
        task.setWorker(scanner.nextLine());
        System.out.println("Введите статус задачи");
        String status = scanner.nextLine();
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
        return task;
    }
}
