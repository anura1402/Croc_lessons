package com.company.zoo;

public class Cages {
    /**
     * Запись вольеров {@link Zoo}.
     */

    /** Данные. */
    private final String number;
    private boolean pollutionStatus;

    /**
     * Создаем запись вольера.
     * @param number данные
     */
    public Cages(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setPollutionStatus(boolean pollutionStatus) {
        this.pollutionStatus = pollutionStatus;
    }

    public boolean isCageDirty() {
        return pollutionStatus;
    }

    /**
     * Возвращает текстовое представление класса.
     * @return текст
     */
    public String toString() {
        return number;
    }
}
