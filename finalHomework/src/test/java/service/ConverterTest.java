package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.anura.javaschool.finalhw.model.Transport;
import ru.anura.javaschool.finalhw.model.Transports;
import ru.anura.javaschool.finalhw.service.XmlService;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ConverterTest {
    final String bus = "<transports>\n" +
            "    <transport>\n" +
            "        <type>bus</type>\n" +
            "        <number>7</number>\n" +
            "        <coordinateX>1</coordinateX>\n" +
            "        <coordinateY>13</coordinateY>\n" +
            "        <datetime>01/01/2021 10:11:14</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>bus</type>\n" +
            "        <number>7</number>\n" +
            "        <coordinateX>6</coordinateX>\n" +
            "        <coordinateY>16</coordinateY>\n" +
            "        <datetime>01/01/2021 10:12:03</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>bus</type>\n" +
            "        <number>20</number>\n" +
            "        <coordinateX>5</coordinateX>\n" +
            "        <coordinateY>13</coordinateY>\n" +
            "        <datetime>01/01/2021 10:13:30</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>bus</type>\n" +
            "        <number>20</number>\n" +
            "        <coordinateX>11</coordinateX>\n" +
            "        <coordinateY>17</coordinateY>\n" +
            "        <datetime>01/01/2021 10:12:02</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>bus</type>\n" +
            "        <number>20</number>\n" +
            "        <coordinateX>20</coordinateX>\n" +
            "        <coordinateY>13</coordinateY>\n" +
            "        <datetime>01/01/2021 10:13:11</datetime>\n" +
            "    </transport>\n" +
            "</transports>";
    String trolley = "<transports>\n" +
            "    <transport>\n" +
            "        <type>trolley</type>\n" +
            "        <number>11</number>\n" +
            "        <coordinateX>10</coordinateX>\n" +
            "        <coordinateY>11</coordinateY>\n" +
            "        <datetime>01/01/2021 10:11:31</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>trolley</type>\n" +
            "        <number>11</number>\n" +
            "        <coordinateX>10</coordinateX>\n" +
            "        <coordinateY>16</coordinateY>\n" +
            "        <datetime>01/01/2021 10:12:40</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>trolley</type>\n" +
            "        <number>11</number>\n" +
            "        <coordinateX>10</coordinateX>\n" +
            "        <coordinateY>21</coordinateY>\n" +
            "        <datetime>01/01/2021 10:13:15</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>trolley</type>\n" +
            "        <number>15</number>\n" +
            "        <coordinateX>20</coordinateX>\n" +
            "        <coordinateY>1</coordinateY>\n" +
            "        <datetime>01/01/2021 10:12:21</datetime>\n" +
            "    </transport>\n" +
            "    <transport>\n" +
            "        <type>trolley</type>\n" +
            "        <number>15</number>\n" +
            "        <coordinateX>25</coordinateX>\n" +
            "        <coordinateY>1</coordinateY>\n" +
            "        <datetime>01/01/2021 10:13:53</datetime>\n" +
            "    </transport>\n" +
            "</transports>";

    @Test
    public void convertTest() throws IOException, ParseException {
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        XmlService xmlService = new XmlService();

        //проверка сериализации
        Transports transports = new Transports();
        List<Transport> transport = new ArrayList<>();
        //transport.add(new Transport("bus", 7, 10, 20, dateTime));
        transports.setTransports(transport);
        String xml2 = xmlService.toXml(transports);
        System.out.println(xml2);

        //проверка десериализации
        Transports transports1 = xmlService.fromXml(bus, Transports.class);
        System.out.println(transports1.getTransports().get(0));

        //проверка десериализации из файла
        String xmlFile = "C:\\Users\\Anna\\IdeaProjects\\croc-java-school-2021\\finalHomework\\bus.xml";
        String xmlFile1 = "C:\\Users\\Anna\\IdeaProjects\\croc-java-school-2021\\finalHomework\\trolley.xml";
        String xmlBus = xmlService.fromFileToString(xmlFile);
        //String xmlTrolley = xmlService.fromFileToString(xmlFile1);
        //System.out.println(xmlBus);
        Transports transportsBus = xmlService.fromXml(xmlBus, Transports.class);
        Assertions.assertSame(transports1, transportsBus);
    }
}

