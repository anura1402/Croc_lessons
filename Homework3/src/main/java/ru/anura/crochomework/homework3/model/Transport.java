package ru.anura.crochomework.homework3.model;

public abstract class Transport {
    /**
     * Идентификатор.
     */
    private Integer id;

    /**
     * Наименование.
     */
    protected String name;

    /**
     * Возраст транспорта
     */
    private Integer age;

    /**
     * Вместимость
     */
    private Integer capacity;

    /**
     * Статус ремонта
     */
    public Boolean repairStatus;

    public Transport(Integer id, String name, Integer capacity,Boolean repairStatus) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.repairStatus = repairStatus;
    }

    public Transport(Integer id, String name, Integer capacity, Integer age,Boolean repairStatus) {
        this(id, name, capacity,repairStatus);
        this.age = age;
    }

    /**
     * Требуемая категория прав
     */
    public abstract String licenseCategory();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}

