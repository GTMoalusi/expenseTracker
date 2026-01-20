import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Expense> getExpensesByCategory(String category){
        List<Expense> filteredExpenses = new ArrayList<>();

        for(Expense expense : expenses){
            if(expense.getCategory().equalsIgnoreCase(category)){
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public Map<YearMonth, Double> getMonthlySummary(){
        Map<YearMonth, Double> summary = new HashMap<>();

        for(Expense expense : expenses){
            YearMonth month = YearMonth.from(expense.getDate());
            summary.put(month, summary.getOrDefault(month, 0.0) + expense.getAmount());
        }
        return summary;
    }
}

