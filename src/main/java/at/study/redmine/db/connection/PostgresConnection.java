package at.study.redmine.db.connection;

import at.study.redmine.propertie.Property;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import static at.study.redmine.propertie.Property.*;
import static at.study.redmine.propertie.Property.getStringProperty;

public class PostgresConnection implements DatabaseConnection {
    public final static DatabaseConnection INSTANCE = new PostgresConnection();

    private String host = getStringProperty("db.host");
    private Integer port = getIntegerProperty("db.port");
    private String database = getStringProperty("db.database");
    private String user = getStringProperty("db.user");
    private String password = getStringProperty("db.password");
    private Connection connection;

    public PostgresConnection() {

        connect();
    }

    @SneakyThrows
    private void connect() {

        Class.forName("org.postgresql.Driver");
        String url = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", user);
        connectionProperties.setProperty("password", password);
        connection = DriverManager.getConnection(url, connectionProperties);

    }

    @Override
    @SneakyThrows
    public List<Map<String, Object>> executeQuery(String query, Object... parameters) {

        PreparedStatement stmt = connection.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            stmt.setObject(i + 1, parameters[i]);

        }

        ResultSet rs = stmt.executeQuery(); // Метод executeQuery используется в запросах,
        // результатом которых является один единственный набор значений, таких как запросов типа SELECT.

        List<Map<String, Object>> result = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> resultRow = new HashMap<>();
            int column = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= column; i++) {
                String key = rs.getMetaData().getColumnName(i);
                Object value = rs.getObject(key);
                resultRow.put(key, value);

            }
            result.add(resultRow);
        }

        return result;
    }
}
