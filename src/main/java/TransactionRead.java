
import java.util.Scanner;

public class TransactionRead {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj typ transakcji do wyświetlenia (wydatek, przychód)");
        String choice = scanner.nextLine();

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.findByChoice(choice);

    }
}
