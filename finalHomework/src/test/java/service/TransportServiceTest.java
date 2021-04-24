package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.anura.javaschool.finalhw.dbprovider.DataSourceProvider;
import ru.anura.javaschool.finalhw.model.Transport;
import ru.anura.javaschool.finalhw.model.Transports;
import ru.anura.javaschool.finalhw.repository.TransportRepository;
import ru.anura.javaschool.finalhw.service.TransportService;
import ru.anura.javaschool.finalhw.service.XmlService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransportServiceTest {
    String xmlFile = "bus.xml";
    String xmlFile1 = "trolley.xml";
    XmlService xmlService = new XmlService();
    DataSourceProvider provider;
    TransportRepository repository;
    TransportService service;
    Transports transports = new Transports();

    @BeforeEach
    void setUp() throws IOException {
        String xmlBus = xmlService.fromFileToString(xmlFile);
        String xmlTrolley = xmlService.fromFileToString(xmlFile1);
        transports = transports.creatingTotalTransport(xmlBus, xmlTrolley);
    }

    //Демотест работы с базой данных
    @Test
    public void testTable() throws IOException, SQLException {
        this.provider = new DataSourceProvider();
        this.repository = new TransportRepository(this.provider.getDataSource());

        // удаление базы данных для нового теста
        //repository.dropTable();

        repository.initTable();
        this.service = new TransportService(this.repository);
        //Тест service.createNew();
        service.createNew(transports.getTransports().get(0));

        //Тест service.getAll()
        List<Transport> transportsFromDB = service.getAll();
        System.out.println("Все записи " + service.getAll());

        //Тест service.getById()
        System.out.println("Запись по ID " + service.getById(transportsFromDB.get(0).getID()));

        //Тест service.update()
        //Получаем 1 элемент из базы для просмотра его полей
        System.out.println(transportsFromDB.get(0));
        //Изменяем у 1 элемента номер
        transportsFromDB.get(0).setNumber(99999);
        //Обновляем значение номера в базе данных
        System.out.println("Обновленная запись " + service.update(transportsFromDB.get(0)));
        //Получаем значения из базы данных для проверки
        System.out.println("Все записи " + service.getAll());

        //Тест service.deleteById()
        service.deleteByID(transportsFromDB.get(0).getID());
        //Получаем значения из базы данных для проверки
        System.out.println("Новые записи с удаленной записью " + service.getAll());

        //Тест service.deleteAll()
        service.deleteAll();
        //Получаем значения из базы данных для проверки
        System.out.println(service.getAll());
    }
}
