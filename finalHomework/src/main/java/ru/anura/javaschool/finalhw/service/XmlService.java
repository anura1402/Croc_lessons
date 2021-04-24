package ru.anura.javaschool.finalhw.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import ru.anura.javaschool.finalhw.model.Transports;

import java.io.*;
import java.util.stream.IntStream;

public class XmlService {


    /**
     * Сериализует объект в xml.
     *
     * @param data объект
     * @return xml
     */
    public String toXml(Object data) throws JsonProcessingException {
        return createXmlMapper().writeValueAsString(data);
    }

    /**
     * Десериализация из xml.
     *
     * @param xml  xml
     * @param type тип объекта
     * @param <T>  тип
     * @return объект
     */
    public <T> T fromXml(String xml, Class<T> type) throws IOException {
        return createXmlMapper().readValue(xml, type);
    }

    public String fromFileToString(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line.trim());
        }
        return sb.toString();
    }

    /**
     * Создаём настроенный mapper JAXB.
     *
     * @return mapper
     */
    private XmlMapper createXmlMapper() {
        final XmlMapper mapper = new XmlMapper();
        mapper.setDefaultUseWrapper(false);
        mapper.registerModule(new JaxbAnnotationModule()); // модуль jaxb
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // форматирование вывода
        return mapper;
    }

    /**
     * Подсчет транспорта в  xml
     *
     * @param xml xml с транспортом
     * @return
     */
    public int countTransport(String xml) {
        int countBus = (int) IntStream.iterate(
                xml.indexOf("<transport>"), // начинаем с первого вхождения
                i -> i != -1, // пока не получим негативный ответ
                i -> xml.indexOf("<transport>", i + 1)) // ищем следующее вхождение
                .count(); // считаем вхождения
        return countBus;
    }

}
