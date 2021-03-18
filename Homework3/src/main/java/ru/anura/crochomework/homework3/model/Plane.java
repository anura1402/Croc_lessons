package ru.anura.crochomework.homework3.model;

public class Plane extends AirTransport implements Rent,Repair{
    /**
     * Преодолеваемое расстояние(До 2 000 км; 4 000 км; до 11 000 км)
     */
    private Integer distance;

    public Plane(Integer id, String name, Integer capacity, Types type, Integer age, Boolean repairStatus, Integer enginePower, Integer fuelCapacity,Integer distance) {
        super(id, name, capacity, type, age, repairStatus, enginePower, fuelCapacity);
        this.distance = distance;
    }


    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String rented() {
        return "Самолет " +this.name + " арендован";
    }

    @Override
    public void sendToRepair() {
        System.out.println("Самолет " +this.name + " нуждается в ремонте");
        System.out.println("Самолет " +this.name + " задерживается в авиапарке для устранения поломок");
        this.repairStatus = true;
    }

    @Override
    public String licenseCategory() {
        return "Для аренды "+this.name + " требуется лицензия частного пилота";
    }
}
