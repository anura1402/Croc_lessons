package com.company.zoo;

import java.util.Arrays;

/**
 * Зоопарк.
 */
public class Zoo {
    private static Animal[] animals = new Animal[]{};//животные
    private static Staff[] staff = new Staff[]{};//персонал
    private static Cages[] cages = new Cages[]{};//вольеры

    /**
     * Рождение или покупка животного.
     *
     * @param animal запись
     */
    public void addAnimal(Animal animal) {
        animals = Arrays.copyOf(animals, animals.length + 1);
        animals[animals.length - 1] = animal;
    }

    /**
     * Привязка животного к сотруднику и вольеру.
     *
     * @param person,cage запись
     */
    public void addOther(Staff person, Cages cage) {
        //запись сотрудника
        staff = Arrays.copyOf(staff, staff.length + 1);
        staff[staff.length - 1] = person;
        //запись вольера
        cages = Arrays.copyOf(cages, cages.length + 1);
        cages[cages.length - 1] = cage;
    }

    /**
     * Установка записи о болезни
     *
     * @param animal животное
     */
    public void animalIllness(Animal animal) {
        animal.setIllnessStatus(true);
    }

    /**
     * Установка записи о загрязнении
     *
     * @param cage вольер
     */
    public void cageStatus(Cages cage) {
        cage.setPollutionStatus(true);
    }

    /**
     * Установка записи о голоде животного
     *
     * @param animal животное
     */
    public void hungerStatus(Animal animal) {
        animal.setHungerStatus(true);
    }

    /**
     * Продажа или смерть животного.
     *
     * @param animal удаляемая запись
     */
    public void remove(Animal animal) {
        final Animal[] newAnimals = new Animal[animals.length - 1];
        int index = 0;
        for (Animal currentAnimal : animals) {
            if (currentAnimal != animal) {
                newAnimals[index++] = currentAnimal;
            }
        }
        animals = newAnimals;
    }

    /**
     * Освобождение вольера и закрепленного вольера с проданного или умершего сотрудника.
     *
     * @param staff,cage перебрасываемая в конец списка запись
     */
    public void changeForNewAnimal(Staff staff, Cages cage) {
        //перемещение сотрудника
        final Staff[] newStaff = new Staff[Zoo.staff.length];
        int index = 0;
        for (Staff currentStaff : Zoo.staff) {
            if (currentStaff != staff) {
                newStaff[index++] = currentStaff;
            }
        }
        newStaff[Zoo.staff.length - 1] = staff;
        Zoo.staff = newStaff;
        //перемещение вольера
        final Cages[] newCage = new Cages[cages.length];
        index = 0;
        for (Cages currentCage : cages) {
            if (currentCage != cage) {
                newCage[index++] = currentCage;
            }
        }
        newCage[cages.length - 1] = cage;
        cages = newCage;
    }

    /**
     * Возвращает животного с информацией о привязке сотрудника и вольера.
     *
     * @return информация о животном
     */
    public String getAnimalsInfo(int i) {
        String[] zooInfo = new String[animals.length];
        zooInfo[i] = "К животному " + animals[i].getData() + " привязан " + staff[i].getName() + " с вольером под номером " + cages[i].getNumber();
        return zooInfo[i];
    }

    /**
     * Возвращает статус болезни животного.
     */
    public static void illness(int i) {
        if (animals[i].isAnimalIll()) System.out.println("Животное " + animals[i].getData() + " болеет");
        else System.out.println("Животное " + animals[i].getData() + " не болеет");
    }

    /**
     * Возвращает информацию об уборке вольера.
     */
    public static void cleaning(int i) {
        if (cages[i].isCageDirty()) {
            System.out.println("Вольер " + cages[i].getNumber() + " грязный");
            staff[i].clean();
            cages[i].setPollutionStatus(false);
        } else System.out.println("Вольер " + cages[i].getNumber() + " чистый");
    }

    /**
     * Возвращает информацию о кормлении животного.
     */
    public static void feeding(int i) {
        if (animals[i].isAnimalHungry()) {
            System.out.println("Животное " + animals[i].getData() + " проголодалось");
            staff[i].feed();
            animals[i].setHungerStatus(false);
        } else System.out.println("Животное " + animals[i].getData() + " еще не голодное");
    }


    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        //добавление записей о зоопарке
        zoo.addAnimal(new Animal("Лев"));
        zoo.addOther(new Staff(("Миша")), new Cages("1"));
        zoo.addAnimal(new Animal("Волк"));
        zoo.addOther(new Staff(("Дима")), new Cages("2"));
        zoo.addAnimal(new Animal("Зебра"));
        zoo.addOther(new Staff(("Игорь")), new Cages("3"));

        //вывод записей
        for (int i = 0; i < animals.length; i++)
            System.out.println(zoo.getAnimalsInfo(i));
        System.out.println("\n");

        //запись о болезни
        zoo.animalIllness(animals[0]);
        illness(0);
        System.out.println("\n");

        //запись об уборке вольера
        zoo.cageStatus(cages[1]);
        cleaning(1);
        cleaning(1);
        System.out.println("\n");

        //запись об кормлении животного
        zoo.hungerStatus((animals[2]));
        feeding(2);
        feeding(1);
        feeding(2);
        System.out.println("\n");

        //смерть животного
        zoo.remove(animals[0]);
        zoo.changeForNewAnimal(staff[0], cages[0]);

        //данные зоопарка с учетом смерти животного
        for (int i = 0; i < animals.length; i++)
            System.out.println(zoo.getAnimalsInfo(i));

    }
}

