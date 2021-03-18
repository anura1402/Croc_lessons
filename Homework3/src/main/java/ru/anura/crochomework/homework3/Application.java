package ru.anura.crochomework.homework3;

import ru.anura.crochomework.homework3.model.*;

public class Application {
    public static void main(String[] args) {
        Car car = new Car(1,
                "Hyundai Solaris",
                5,
                100,
                3,
                false,
                50,
                AutoClass.C);
        System.out.println(car.licenseCategory());
        Motocycle moto = new Motocycle(11,
                "Yamaha FZ6",
                2,
                77,
                9,
                true,
                19);
        System.out.println(moto.licenseCategory());
        Bicycle bike = new Bicycle(15,
                "Stels Navigator-450",
                1,
                5,
                true,
                Types.MECHANICAL,
                "Ручной тормоз");
        System.out.println(bike.licenseCategory());
        Plane passengerPlane = new Plane(2,
                "Boeing 777",
                400,
                Types.PASSENGER,
                4,
                false,
                52200,
                117000,
                14680);
        System.out.println(passengerPlane.licenseCategory());
        TransportManager transportManager = new TransportManager();
        if (!car.repairStatus) transportManager.sendingToRepair(car);
        else System.out.println(car.getName() + " не нуждается в починке");

        if (!moto.repairStatus) transportManager.sendingToRepair(moto);
        else System.out.println(moto.getName() + " не нуждается в починке");

        if (!bike.repairStatus) transportManager.sendingToRepair(bike);
        else System.out.println(bike.getName() + " не нуждается в починке");

        if (!passengerPlane.repairStatus) transportManager.sendingToRepair(passengerPlane);
        else System.out.println(passengerPlane.getName() + " не нуждается в починке");
        if (!passengerPlane.repairStatus) transportManager.sendingToRepair(passengerPlane);
        else System.out.println(passengerPlane.getName() + " не нуждается в починке");

        System.out.println(transportManager.sendingToRent(car));
    }
}
