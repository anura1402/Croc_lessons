package com.company.zoo;

public class Animal {
/**
 * Запись животных {@link Zoo}.
 */

    /** Данные. */
    private final String data;
    private boolean illnessStatus;
    private boolean hungerStatus;

    /**
     * Создаем запись животного.
     * @param data данные
     */
    public Animal(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setIllnessStatus(boolean illnessStatus) {
        this.illnessStatus = illnessStatus;
    }

    public boolean isAnimalIll() {
        return illnessStatus;
    }
    public void setHungerStatus(boolean hungerStatus) {
        this.hungerStatus = hungerStatus;
    }

    public boolean isAnimalHungry() {
        return hungerStatus;
    }

    /**
     * Возвращает текстовое представление класса.
     * @return текст
     */
    public String toString() {
        return data;
    }
}
