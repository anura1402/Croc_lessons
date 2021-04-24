package ru.anura.javaschool.finalhw.model;

import ru.anura.javaschool.finalhw.service.XmlService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@XmlRootElement(name = "transports")
public class Transports {
    @XmlElement(name = "transport")
    public List<Transport> transports = new ArrayList<>();

    public Transports() {
    }

    public Transports(List<Transport> transports) {
        this.transports = transports;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    /**
     * Сбор двух файлов в один класс
     * @param xmlBus xml, содержащий данные об автобусах
     * @param xmlTrolley xml, содержащий данные о троллейбусах
     * @return класс
     * @throws IOException
     */
    public Transports creatingTotalTransport(String xmlBus,String xmlTrolley) throws IOException {
        XmlService xmlService = new XmlService();

        int countBus = xmlService.countTransport(xmlBus);
        int countTrolley = xmlService.countTransport(xmlTrolley);

        Transports transportsBus = xmlService.fromXml(xmlBus, Transports.class);
        Transports transportsTrolley = xmlService.fromXml(xmlTrolley, Transports.class);
        List<Transport> totalTransport = new ArrayList<>();
        Transports totalTransports = new Transports();
        for (int i = 0; i < countBus; i++) {
            totalTransport.add(transportsBus.getTransports().get(i));
            totalTransport.get(i).setDateOfLocation(LocalDateTime.parse(totalTransport.get(i).getDateOfLocationString(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        }
        for (int i = 0; i < countTrolley; i++) {
            totalTransport.add(transportsTrolley.getTransports().get(i));
            totalTransport.get(i).setDateOfLocation(LocalDateTime.parse(totalTransport.get(i).getDateOfLocationString(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        }
        totalTransports.setTransports(totalTransport);
        return totalTransports;
    }
    @Override
    public String toString() {
        return "Transports{" +
                "transports=" + transports +
                '}';
    }
}
