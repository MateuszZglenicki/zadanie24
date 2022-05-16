import java.math.BigDecimal;
import java.sql.*;

public class TransactionDao {

    void insert(Transaction transaction) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO transaction(type, description, amount, date) VALUES(?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setBigDecimal(3, transaction.getAmount());
            preparedStatement.setInt(4, transaction.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd zapisu " + e.getMessage());
        }

        connectionClose(connection);
    }

    private void connectionClose(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Transaction findByChoice(String choice) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM transaction WHERE type = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, choice);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String typeFromDb = resultSet.getString("type");
                String description = resultSet.getString("description");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                int date  = resultSet.getInt("date");
                Transaction transaction = new Transaction(id, typeFromDb, description, amount, date);
                System.out.println(transaction);
            }
        } catch (SQLException e) {
            System.out.println("Błąd odczytu " + e.getMessage());
        }

        connectionClose(connection);
        return null;
    }

    public void update(Transaction transaction) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setBigDecimal(3, transaction.getAmount());
            preparedStatement.setInt(4, transaction.getDate());
            preparedStatement.setInt(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd podczas aktualizacji " + e.getMessage());
        }

        connectionClose(connection);
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/transactions?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM transaction WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd podczas usuwania " + e.getMessage());
        }
        connectionClose(connection);
    }
}
