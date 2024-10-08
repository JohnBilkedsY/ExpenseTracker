package com.jdbc;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseDAO expenseDAO = new ExpenseDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. View Total Expenses");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    Date date = Date.valueOf(dateStr);
                    expenseDAO.addExpense(new Expense(0, amount, description, date));
                    break;
                case 2:
                    List<Expense> expenses = expenseDAO.getAllExpenses();
                    for (Expense expense : expenses) {
                        System.out.println(expense.getId() + ": " + expense.getDescription() + " - " + expense.getAmount() + " on " + expense.getDate());
                    }
                    break;
                case 3:
                    System.out.print("Expense ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("New Amount: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("New Description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("New Date (YYYY-MM-DD): ");
                    String newDateStr = scanner.nextLine();
                    Date newDate = Date.valueOf(newDateStr);
                    expenseDAO.updateExpense(new Expense(idToUpdate, newAmount, newDescription, newDate));
                    break;
                case 4:
                    System.out.print("Expense ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    expenseDAO.deleteExpense(idToDelete);
                    break;
                case 5:
                    double totalExpenses = expenseDAO.getTotalExpenses();
                    System.out.println("Total Expenses: " + totalExpenses);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
