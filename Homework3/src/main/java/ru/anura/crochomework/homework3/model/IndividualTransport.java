package ru.anura.crochomework.homework3.model;

public abstract class IndividualTransport extends Transport{

    /**
     * Тип транспорта(электро,механический).
     */
    private Types type;


    public IndividualTransport(Integer id, String name, Integer capacity, Integer age,Boolean repairStatus,Types type) {
        super(id, name, capacity, age,repairStatus);
        this.type=type;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    @Override
    public String licenseCategory() {
        return "Для аренды "+this.name + " не требуются водительские права";
    }
}
