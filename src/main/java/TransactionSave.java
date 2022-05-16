import java.math.BigDecimal;
import java.util.Scanner;

public class TransactionSave {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj typ transakcji");
        String type = scanner.nextLine();
        System.out.println("Podaj opis transakcji");
        String description = scanner.nextLine();
        System.out.println("Podaj kwotę");
        BigDecimal amount = scanner.nextBigDecimal();
        System.out.println("Podaj datę");
        int date = scanner.nextInt();
        scanner.nextLine();

        Transaction transaction = new Transaction(type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.insert(transaction);
    }
}
