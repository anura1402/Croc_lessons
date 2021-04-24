package ru.anura.javaschool.finalhw.model;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Transport<DateTime> {
    @XmlTransient
    private Integer ID = 1;

    @XmlElement(name = "type")
    private String transport_type;

    @XmlElement(name = "number")
    private Integer number;

    @XmlElement(name = "coordinateX")
    private Integer X;

    @XmlElement(name = "coordinateY")
    private Integer Y;

    @XmlTransient
    private LocalDateTime dateOfLocation;
    @XmlTransient
    private Timestamp dateOfLocationTS;
//    @XmlTransient
//    private Date dateOfLocation;
//    @XmlTransient
//    private LocalTime timeOfLocation;


    @XmlElement(name = "datetime")
    private String dateOfLocationString;

    /**
     * Формат времени в привычный вид
     */
    @XmlTransient
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Преобразование даты и времени в строку (формат - formatter)
     *
     * @param dateTime - {@link LocalDateTime}
     * @return String "dd/MM/yyyy HH:mm:ss"
     */
    private String convertToString(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }

    /**
     * Преобразование строки "dd/MM/yyyy HH:mm:ss" с датой и временем в LocalDateTime
     *
     * @param dateTimeString String "dd/MM/yyyy HH:mm:ss"
     * @return LocalDateTime
     */
    public LocalDateTime parseFromString(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    /**
     * Конструкторы
     */
    public Transport() {
    }

    public Transport(Integer ID, String transport_type, Integer number, Integer x, Integer y, String dateOfLocationString) throws ParseException {
        this.ID = ID;
        this.transport_type = transport_type;
        this.number = number;
        X = x;
        Y = y;
        this.dateOfLocation = parseFromString(dateOfLocationString);
        this.dateOfLocationString = dateOfLocationString;
    }

    public Transport(Integer ID, String transport_type, Integer number, Integer x, Integer y) {
        this.ID = ID;
        this.transport_type = transport_type;
        this.number = number;
        X = x;
        Y = y;
    }

    public Transport(Integer ID, String transport_type, Integer number, Integer x, Integer y, LocalDateTime dateOfLocation) {
        this.ID = ID;
        this.transport_type = transport_type;
        this.number = number;
        X = x;
        Y = y;
        this.dateOfLocation = dateOfLocation;
        this.dateOfLocationString = convertToString(dateOfLocation);
    }

    public Transport(String transport_type, Integer number, Integer x, Integer y, LocalDateTime dateOfLocation) {
        this.transport_type = transport_type;
        this.number = number;
        X = x;
        Y = y;
        this.dateOfLocation = dateOfLocation;
        this.dateOfLocationString = convertToString(dateOfLocation);
    }

    public Transport(Integer ID, String transport_type, Integer number, Integer x, Integer y, Timestamp dateOfLocationTS) {
        this.ID = ID;
        this.transport_type = transport_type;
        this.number = number;
        X = x;
        Y = y;
        this.dateOfLocation = dateOfLocationTS.toLocalDateTime();
        this.dateOfLocationString = convertToString(dateOfLocation);
    }

    public Transport(String transport_type, Integer number, Integer x, Integer y, String dateOfLocationString) throws ParseException {
        this.transport_type = transport_type;
        this.number = number;
        X = x;
        Y = y;
        this.dateOfLocation = parseFromString(dateOfLocationString);
        this.dateOfLocationString = dateOfLocationString;
    }

    /**
     * Геттеры сеттеры
     */
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public LocalDateTime getDateOfLocation() {
        return dateOfLocation;
    }

    public void setDateOfLocation(LocalDateTime dateOfLocation) {
        this.dateOfLocation = dateOfLocation;
    }

    public String getDateOfLocationString() {
        return dateOfLocationString;
    }

    public void setDateOfLocationString(String dateOfLocationString) {
        this.dateOfLocationString = dateOfLocationString;
    }

    /**
     * Override методы
     */
    @Override
    public String toString() {
        return "Transport{" +
                "ID=" + ID +
                ", transport_type='" + transport_type + '\'' +
                ", number=" + number +
                ", X=" + X +
                ", Y=" + Y +
                ", dateOfLocation=" + dateOfLocation +
                ", dateOfLocationString='" + dateOfLocationString + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return transport_type == transport.transport_type &&
                Objects.equals(number, transport.number) &&
                Objects.equals(X, transport.X) &&
                Objects.equals(Y, transport.Y) &&
                Objects.equals(dateOfLocationString, transport.dateOfLocationString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transport_type, number, X, Y, dateOfLocationString);
    }
}
