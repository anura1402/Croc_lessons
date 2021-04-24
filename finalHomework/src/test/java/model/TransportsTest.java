package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.anura.javaschool.finalhw.model.Transport;
import ru.anura.javaschool.finalhw.model.Transports;
import ru.anura.javaschool.finalhw.service.XmlService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportsTest {

    @Test
    public void convertingDateTest() throws ParseException {
        //проверка парсинга
        LocalDateTime dateTime = LocalDateTime.parse("01/01/2021 10:11:14", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println(dateTime);

        //проверка записи в экземпляр класса
        Transports transports = new Transports();
        List<Transport> transport = new ArrayList<>();
        transport.add(new Transport("bus", 7, 10, 20, "01/01/2021 10:11:14"));
        transports.setTransports(transport);
        System.out.println(transports);

        Assertions.assertEquals("01/01/2021 10:11:14", transports.getTransports().get(0).getDateOfLocationString());
        Assertions.assertEquals(dateTime, transports.getTransports().get(0).getDateOfLocation());
    }

    @Test
    public void creatingTransportFromAllXML() throws IOException {
        Transports transports = new Transports();
        XmlService xmlService = new XmlService();

        String xmlFile = "C:\\Users\\Anna\\IdeaProjects\\croc-java-school-2021\\finalHomework\\bus.xml";
        String xmlFile1 = "C:\\Users\\Anna\\IdeaProjects\\croc-java-school-2021\\finalHomework\\trolley.xml";
        //Десериализация из файла
        String xmlBus = xmlService.fromFileToString(xmlFile);
        String xmlTrolley = xmlService.fromFileToString(xmlFile1);
        //проверка десериализации
        System.out.println(xmlBus);

        //проверка записи в общий экземпляр класса из двух файлов
        transports = transports.creatingTotalTransport(xmlBus, xmlTrolley);
        System.out.println(transports.getTransports().get(0).getDateOfLocation());
    }

}
