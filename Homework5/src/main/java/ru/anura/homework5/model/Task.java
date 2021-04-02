package ru.anura.homework5.model;

import java.io.Serializable;

public class Task implements Serializable {
    /**
     * Код задачи
     */
    private Integer id;

    /**
     * Наименование
     */
    private String name;

    /**
     * Описание
     */
    private String about;

    /**
     * Исполнитель
     */
    private String worker;

    /**
     * Статус
     */
    private TaskStatus status;

    public Task(String name, String about, String worker, TaskStatus status) {
        this.name = name;
        this.about = about;
        this.worker = worker;
        this.status = status;
    }

    public Task(Integer id, String name, String about, String worker, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.worker = worker;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", worker='" + worker + '\'' +
                ", status=" + status +
                '}';
    }
}
