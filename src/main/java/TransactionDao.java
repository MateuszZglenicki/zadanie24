import java.math.BigDecimal;
import java.sql.*;
import java.util.Optional;

public class TransactionDao {
    private final Connection connection;

    public TransactionDao() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions?serverTimezone=UTC", "root", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void save(Transaction transaction) {
        final String sql = String.format("INSERT INTO transaction (type, description, amount, date) VALUES ('%s', %s, '%s', '%s')",
                transaction.getType(), transaction.getDescription(), transaction.getAmount(), transaction.getDate());
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                transaction.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Optional<Transaction> findByType(String searchType) {
        final String sql = "SELECT id, type , description, amount, date FROM transaction WHERE type = '" + searchType + "'";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                Integer date = resultSet.getInt("date");
                return Optional.of(new Transaction(id, type, description, amount, date));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    boolean delete(int id) {
        final String sql = "DELETE FROM transaction WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            int updatedRows = statement.executeUpdate(sql);
            return updatedRows != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    boolean update(Transaction transaction) {
        final String sql = String.format("""
            UPDATE
                transaction
            SET
                type = '%s',
                description = '%s',
                amount = '%s',
                date = %s
            WHERE
                id = %d
            """,
                transaction.getType(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getDate(),
                transaction.getId());
        try (Statement statement = connection.createStatement()) {
            int updatedRows = statement.executeUpdate(sql);
            return updatedRows != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
