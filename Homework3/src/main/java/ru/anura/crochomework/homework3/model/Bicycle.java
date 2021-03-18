package ru.anura.crochomework.homework3.model;

public class Bicycle extends IndividualTransport implements Rent,Repair{
    /**
     * Вид тормоза.
     */
    private String brake;

    public Bicycle(Integer id, String name, Integer capacity, Integer age, Boolean repairStatus, Types type,String brake) {
        super(id, name, capacity, age, repairStatus, type);
        this.brake = brake;
    }


    public String getBrake() {
        return brake;
    }

    public void setBrake(String brake) {
        this.brake = brake;
    }

    @Override
    public String rented() {
        return "Велосипед " +this.name + " арендован";
    }

    @Override
    public void sendToRepair() {
        System.out.println("Велосипед " +this.name + " нуждается в ремонте");
        System.out.println("Велосипед " +this.name + " отдан местным ремонтникам для починки");
        this.repairStatus = true;
    }
}
