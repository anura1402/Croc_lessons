package ru.anura.crochomework.homework3.model;

import java.awt.*;

public abstract class AirTransport extends Transport {
    /**
     * Мощность двигателя.
     */
    private Integer enginePower;

    /**
     * Объем топливного бака.
     */
    private Integer fuelCapacity;

    /**
     * Тип транспорта(пассажирский,военный,государственный).
     */
    private Types type;

    public AirTransport(Integer id, String name, Integer capacity, Types type, Integer age,Boolean repairStatus, Integer enginePower, Integer fuelCapacity) {
        super(id, name, capacity, age,repairStatus);
        this.enginePower = enginePower;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
}
