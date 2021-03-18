package ru.anura.crochomework.homework3.model;

public abstract class MotorTransport extends Transport {

    /**
     * Объем топливного бака.
     */
    private Integer fuelCapacity;

    /**
     * Количество лошадиных сил
     */
    private Integer horsepower;

    public MotorTransport(Integer id, String name, Integer capacity, Integer horsepower, Integer age,Boolean repairStatus, Integer fuelCapacity) {
        super(id, name, capacity, age,repairStatus);
        this.fuelCapacity = fuelCapacity;
        this.horsepower = horsepower;
    }


    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }
}
