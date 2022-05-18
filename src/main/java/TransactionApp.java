import java.util.Scanner;

public class TransactionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Co chcsz zrobić: 1-dodawanie, 2- wyszukiwanie, 3-aktualizacje, 4-usuwa" +
                    "nie, 0-STOP ?");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1" -> TransactionSave.main(new String[0]);
                case "2" -> TransactionRead.main(new String[0]);
                case "3" -> TransactionUpdate.main(new String[0]);
                case "4" -> TransactionDelete.main(new String[0]);
                case "0" -> {
                    System.out.println("KONIEC");
                    return;
                }
                default -> System.out.println("Błędny wybór");
            }
        }
    }

}
