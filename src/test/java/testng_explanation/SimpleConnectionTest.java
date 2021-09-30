package testng_explanation;

import at.study.redmine.db.connection.DatabaseConnection;
import at.study.redmine.db.connection.PostgresConnection;
import at.study.redmine.db.requests.TokenRequests;
import at.study.redmine.model.Token;
import at.study.redmine.model.User;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;

public class SimpleConnectionTest {

    @Test
    @SneakyThrows // все проверяемы исключения делает в непроверяемые(анотация из ломбок)
    public void testConnection() {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://edu-at.dfu.i-teco.ru:5432/db";
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", "redmine_user");
        connectionProperties.setProperty("password", "redmine_pass");
/**
 * После установления соединения Connection с базой данных, оно может использоваться для выполнения SQL-запросов.
 * Объект Statement создается методом Connection.createStatement.
 */
        Connection connection = DriverManager.getConnection(url, connectionProperties);
        int filterId = 20000;
        String query = "SELECT * FROM users where id > ?";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setObject(1, filterId);
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
        System.out.println();

    }

//    @Test
//    public void postgresConnection() {
//        DatabaseConnection client = new PostgresConnection();
//        List<Map<String, Object>> result = client.executeQuery("SELECT * FROM tokens where id = ? OR id = ?", 24, 37618);
//    }

    @Test
    public void getUserTokensTest() {
        User user = new User();
        user.setId(37618);
        List<Token> userTokens = new TokenRequests(user).readAll();
    }


}
