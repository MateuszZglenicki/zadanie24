
import java.util.Scanner;

public class TransactionDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id do usunięcia");
        int id = scanner.nextInt();
        scanner.nextLine();

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.deleteById(id);
        System.out.println("Usunięto pozycję nr " + id);
    }
}
