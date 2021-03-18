package ru.anura.crochomework.homework3;

import ru.anura.crochomework.homework3.model.Rent;
import ru.anura.crochomework.homework3.model.Repair;

public class TransportManager {
    public void sendingToRepair(Repair repair) {repair.sendToRepair();}
    public String sendingToRent(Rent rent) { return rent.rented(); }
}
