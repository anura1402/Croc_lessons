package com.company.zoo;

public class Staff {
    /**
     * Запись сотрудников {@link Zoo}.
     */

    /** Данные. */
    private final String name;

    /**
     * Создаем запись сотрудника.
     * @param name данные
     */
    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Возвращает текстовое представление класса.
     * @return текст
     */
    public void feed() {
        System.out.println("Сотрудник " + this.name + " покормил животное ");
    }

    public void clean() {
        System.out.println("Сотрудник " + this.name + " почистил вольер ");
    }

    /**
     * Возвращает текстовое представление класса.
     * @return текст
     */
    public String toString() {
        return name;
    }
}
