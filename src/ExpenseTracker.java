import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {

    // Fields
    private final List<Expense> expenses;
    private int nextId;

    // Constructor
    public ExpenseTracker(){
        this.expenses = new ArrayList<Expense>();
        this.nextId = 1;
    }

    //Unique Methods
    public Expense addExpense(String description, double amount, String category){
        Expense expense = new Expense(nextId, description, amount, category, LocalDate.now());

        expenses.add(expense);
        nextId++;

        return expense;
    }

    public List<Expense> getAllExpenses(){
        return new ArrayList<>(expenses);
    }

    public double getTotalExpenses(){
        double total = 0.0;

        for(Expense expense : expenses){
            total += expense.getAmount();
        }

        return total;
    }
}

