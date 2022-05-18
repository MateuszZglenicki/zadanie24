import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id transakcji, którą chcesz zaktualizować");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj typ transakcji");
        String type = scanner.nextLine();
        System.out.println("Podaj opis transakcji");
        String description = scanner.nextLine();
        System.out.println("Podaj kwotę");
        BigDecimal amount = scanner.nextBigDecimal();
        System.out.println("Podaj datę w formacie (yyyy-MM-dd)");
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput, datePattern);

        Transaction transaction = new Transaction(id, type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.update(transaction);
    }
}
