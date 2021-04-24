package ru.anura.javaschool.finalhw.service;

import ru.anura.javaschool.finalhw.model.Transport;
import ru.anura.javaschool.finalhw.repository.TransportRepository;

import java.sql.SQLException;
import java.util.List;

public class TransportService {
    private final TransportRepository repository;

    /**
     * @param repository TransportRepository
     */
    public TransportService(TransportRepository repository) {
        this.repository = repository;
    }

    /**
     * Получить все записи из БД
     *
     * @return cписок всех транпортов в БД
     * @throws SQLException
     */
    public List<Transport> getAll() throws SQLException {
        return repository.getAll();
    }

    /**
     * Создать новую запись в БД
     *
     * @param transport созданный транспорт
     * @return
     */
    public Transport createNew(Transport transport) {
        repository.createNew(transport);
        return transport;
    }

    /**
     * Обновить запись в БД
     *
     * @param transport обновленная запись
     * @return
     */
    public Transport update(Transport transport) {
        repository.update(transport);
        return transport;
    }

    /**
     * Получить запись по ID
     *
     * @param id ID
     * @return запись
     * @throws SQLException
     */
    public Transport getById(Integer id) throws SQLException {
        return repository.getById(id);
    }

    /**
     * Удалить запись по ID
     *
     * @param id ID
     */
    public void deleteByID(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Удалить все записи из БД
     *
     * @throws SQLException
     */
    public void deleteAll() throws SQLException {
        repository.deleteAll();
    }
}
