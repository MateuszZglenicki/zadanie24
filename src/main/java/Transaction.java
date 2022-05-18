import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private String type;
    private String description;
    private BigDecimal amount;
    private LocalDate date; //zmiana na ty Date?

    public Transaction(Integer id, String type, String description, BigDecimal amount, LocalDate date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(String type, String description, BigDecimal amount, LocalDate date) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "id = " + id +
                ", typ = '" + type + '\'' +
                ", opis = '" + description + '\'' +
                ", koszt = " + amount +
                ", data = " + date +
                '}';
    }

}
