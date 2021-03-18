package ru.anura.crochomework.homework3.model;

public class Motocycle extends MotorTransport implements Rent,Repair{


    public Motocycle(Integer id, String name, Integer capacity, Integer horsepower, Integer age, Boolean repairStatus, Integer fuelCapacity) {
        super(id, name, capacity, horsepower, age, repairStatus, fuelCapacity);
    }

    @Override
    public String rented() {
        return "Мотоцикл " +this.name + " арендован";
    }

    @Override
    public void sendToRepair() {
        System.out.println("Мотоцикл "+this.name + " нуждается в ремонте");
        System.out.println("Мотоцикл "+this.name + " отправлен в сервисный центр мотоциклов");
        this.repairStatus = true;
    }

    @Override
    public String licenseCategory() {
        return "Для аренды "+this.name + " требуются водительские права категории A";
    }
}
