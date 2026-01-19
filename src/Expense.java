import java.time.LocalDate;

public class Expense {
    // Fields
    private final int id;
    private final String description;
    private final double amount;
    private final String category;
    private final LocalDate date;

    // Constructor
    public Expense(int id, String description, double amount, String category, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString(){
        return "Expense{" +
                "id= " + id +
                ", description= '" + description + '\'' +
                ", amount= R" + amount +
                ", category= '" + category + '\'' +
                ", date= " + date +
                '}';
    }
}
