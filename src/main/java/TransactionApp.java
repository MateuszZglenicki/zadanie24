import java.math.BigDecimal;
import java.util.function.Function;

public class TransactionApp {
    private static final TransactionDao DAO = new TransactionDao();

    public static void main(String[] args) {

//        create();
//        read();
//        update();
//        delete();
        DAO.close();
    }

//    private static void create() {
//        Transaction transaction = new Transaction("wydatek", "211232323", BigDecimal.valueOf(300), 1);
//        System.out.println("Zapisuję transakcję");
//        DAO.save(transaction);
//        System.out.println("Transakcja zapisana, jej id to: " + transaction.getId());
//    }
//
//    private static void read() {
//        DAO.findByType("przychód").ifPresentOrElse(
//                transaction -> System.out.println("transakcja:\n" + transaction),
//                () -> System.out.println("Brak transakcji o takiej nazwie"));
//    }
//
//    private static void update() {
//        Function<Transaction, Transaction> updateTransactionAmount = transaction -> {
//            transaction.setAmount(BigDecimal.valueOf(20));
//            return transaction;
//        };
//        DAO.findByType("wydatek")
//                .map(updateTransactionAmount)
//                .map(DAO::update)
//                .filter(b -> b)
//                .ifPresent(updated -> System.out.println("Wydatek został zaktualizowany"));
//    }
//
//    private static void delete() {
//        System.out.println("Usuwam");
//        DAO.findByType("przychód")
//                .map(Transaction::getId)
//                .map(DAO::delete)
//                .ifPresentOrElse(removed -> System.out.println("transakcja została usunięta"),
//                        () -> System.out.println("W bazie nie ma wybranej transakcji do usunięcia"));
//    }
}

