import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. View Total Expenses by Category");
            System.out.println("5. View Monthly Summary");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    handleAddExpense(scanner, tracker);
                    break;

                case 2:
                    handleViewExpenses(tracker);
                    break;

                case 3:
                    handleViewTotal(tracker);
                    break;

                case 4:
                    handleFilterByCategory(scanner, tracker);
                    break;

                case 5:
                    handleMonthlySummary(tracker);
                    break;

                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void handleAddExpense(Scanner scanner, ExpenseTracker tracker) {

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Expense not added.");
            return;
        }

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Expense expense = tracker.addExpense(description, amount, category);
        System.out.println("Expense added: " + expense);
    }

    private static void handleViewExpenses(ExpenseTracker tracker) {
        List<Expense> expenses = tracker.getAllExpenses();

        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private static void handleViewTotal(ExpenseTracker tracker) {
        double total = tracker.getTotalExpenses();
        System.out.println("Total expenses: R" + total);
    }

    private static void handleFilterByCategory(Scanner scanner, ExpenseTracker tracker) {
        System.out.print("Enter category to filter by: ");
        String category = scanner.nextLine();

        List<Expense> filtered = tracker.getExpensesByCategory(category);
        if (filtered.isEmpty()) {
            System.out.println("No expense found for category: " + category);
            return;
        }

        for (Expense expense : filtered) {
            System.out.println(expense);
        }
    }

    private static void handleMonthlySummary(ExpenseTracker tracker) {
        Map<YearMonth, Double> monthlySummary = tracker.getMonthlySummary();

        if (monthlySummary.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (Map.Entry<YearMonth, Double> entry : monthlySummary.entrySet()) {
            System.out.println(entry.getKey() + ": R" + entry.getValue());
        }
    }
}