package ru.anura.crochomework.homework3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import ru.anura.crochomework.homework3.model.AutoClass;
import ru.anura.crochomework.homework3.model.Car;

public class TransportManagerTest {
    @Test
    @DisplayName("Тест метода аренды автомобиля")
    public void testRentingCar(){
        TransportManager transportManager = new TransportManager();
        Car car = new Car(1,
                "Hyundai Solaris",
                5,
                100,
                3,
                false,
                50,
                AutoClass.C);
        Assertions.assertEquals("Автомобиль Hyundai Solaris арендован",
                transportManager.sendingToRent(car));
    }

}
