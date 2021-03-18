package ru.anura.crochomework.homework3.model;

public class Car extends MotorTransport implements Rent, Repair {
    /**
     * Класс автомобиля.
     */
    private AutoClass autoClass;

    public Car(Integer id, String name, Integer capacity, Integer horsepower, Integer age, Boolean repairStatus, Integer fuelCapacity, AutoClass autoClass) {
        super(id, name, capacity, horsepower, age, repairStatus, fuelCapacity);
        this.autoClass = autoClass;
    }

    public AutoClass getAutoClass() {
        return autoClass;
    }

    public void setAutoClass(AutoClass autoClass) {
        this.autoClass = autoClass;
    }

    @Override
    public String rented() {
        return "Автомобиль " +this.name + " арендован";
    }

    @Override
    public void sendToRepair() {
        System.out.println("Автомобиль "+this.name + " нуждается в ремонте");
        System.out.println("Автомобиль " +this.name + " отправлен в сервисный центр автомобилей");
        this.repairStatus = true;
    }

    @Override
    public String licenseCategory() {
        return "Для аренды "+this.name + " требуются водительские права категории B";
    }


}
