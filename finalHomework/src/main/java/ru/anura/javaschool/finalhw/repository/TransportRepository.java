package ru.anura.javaschool.finalhw.repository;

import org.apache.derby.jdbc.EmbeddedDataSource;
import ru.anura.javaschool.finalhw.model.Transport;
import ru.anura.javaschool.finalhw.model.Transports;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для доступа к таблице с данными о транспортах (Transport).
 */
public class TransportRepository {

    public static final String TABLE_NAME = "Transports";

    private EmbeddedDataSource dataSource;

    public TransportRepository(EmbeddedDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Метод очистки БД.
     */
    public void dropTable() {
        System.out.println("START DROP");
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE " + TABLE_NAME);
        } catch (SQLException e) {
            System.out.println("Error occurred during table initializing: " + e.getMessage());
        }
        System.out.println("END DROP");
    }

    /**
     * Метод инициализации БД.
     */
    public void initTable() {
        System.out.println(String.format("Start initializing %s table", TABLE_NAME));
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            DatabaseMetaData databaseMetadata = connection.getMetaData();
            ResultSet resultSet = databaseMetadata.getTables(
                    null,
                    null,
                    TABLE_NAME.toUpperCase(),
                    new String[]{"TABLE"});
            if (resultSet.next()) {
                System.out.println("Table has already been initialized");
            } else {
                statement.executeUpdate(
                        "CREATE TABLE "
                                + TABLE_NAME
                                + "("
                                + "id INT not null GENERATED ALWAYS as identity PRIMARY KEY , "
                                + "transport_type varchar(255),"
                                + "number int,"
                                + "coordinateX int,"
                                + "coordinateY int,"
                                + "date timestamp"
                                + ")");
                System.out.println("Table was successfully initialized");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during table initializing: " + e.getMessage());
        } finally {
            System.out.println("=========================");
        }
    }

    /**
     * Метод поиска всех задач в БД.
     *
     * @return список всех созданных задач
     */
    public List<Transport> getAll() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
            List<Transport> transportList = new ArrayList<>();
            while (resultSet.next()) {
                transportList.add(
                        new Transport(
                                resultSet.getInt("id"),
                                resultSet.getString("transport_type"),
                                resultSet.getInt("number"),
                                resultSet.getInt("coordinateX"),
                                resultSet.getInt("coordinateY"),
                                resultSet.getTimestamp("date")));
            }
            //LocalDateTime.of(resultSet.getDate("date").toLocalDate(),resultSet.getTime("time").toLocalTime())));}
            return transportList;
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Метод поиска одной задачи в БД по id.
     *
     * @return одной созданной задачи
     */
    public Transport getById(Integer id) throws SQLException {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) return new Transport(
                    resultSet.getInt("id"),
                    resultSet.getString("transport_type"),
                    resultSet.getInt("number"),
                    resultSet.getInt("coordinateX"),
                    resultSet.getInt("coordinateY"),
                    resultSet.getTimestamp("date")
            );
            else return null;
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return new Transport();
    }

    /**
     * Метод создания записи в БД о новой задаче.
     *
     * @param transport транспорт
     */
    public Integer createNew(Transport transport) {
        String sqlQuery = "INSERT INTO " + TABLE_NAME + " (" + "transport_type, number, coordinateX, coordinateY, date)" +
                " VALUES(?,?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, transport.getTransport_type());
            statement.setInt(2, transport.getNumber());
            statement.setInt(3, transport.getX());
            statement.setInt(4, transport.getY());
            statement.setTimestamp(5, Timestamp.valueOf(transport.getDateOfLocation()));
            System.out.println(sqlQuery);
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) return resultSet.getInt(1);
            else return null;
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
            return null;
        }
    }

    /**
     * Обновление записи базы данных
     *
     * @param transport транспорт
     */
    public Integer update(Transport transport) {
        if (transport.getID() == null) {
            return createNew(transport);
        }
        String sqlQuery = "update " + TABLE_NAME + " set transport_type = ?," +
                "number = ?, " +
                "coordinateX = ?, " +
                "coordinateY = ?, " +
                "date = ? " +
                "where id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, transport.getTransport_type());
            statement.setInt(2, transport.getNumber());
            statement.setInt(3, transport.getX());
            statement.setInt(4, transport.getY());
            statement.setTimestamp(5, Timestamp.valueOf(transport.getDateOfLocation()));
            statement.setInt(6, transport.getID());
            statement.execute();
            return transport.getID();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
            return null;
        }
    }

    /**
     * Удаление записи по ее ID
     *
     * @param id ID
     */
    public void deleteById(Integer id) {
        String sqlQuery = "delete from " + TABLE_NAME + " where id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Полная очистка таблицы
     */
    public void deleteAll() throws SQLException {
        String sqlQuery = "DELETE FROM " + TABLE_NAME;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw e;
        }
    }
}