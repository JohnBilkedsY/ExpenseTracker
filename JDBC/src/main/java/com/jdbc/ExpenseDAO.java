package com.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseDAO {
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses (amount, description, date) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, expense.getAmount());
            pstmt.setString(2, expense.getDescription());
            pstmt.setDate(3, new java.sql.Date(expense.getDate().getTime()));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
        	System.out.println("---------Expenses------------");
        	System.out.println();
            while (rs.next()) {
            	
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                expenses.add(new Expense(id, amount, description, date));
                
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenses;
    }

    public void updateExpense(Expense expense) {
        String sql = "UPDATE expenses SET amount = ?, description = ?, date = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	System.out.println();
        	System.out.println("---------Update Expenses------------");
        	System.out.println();
            pstmt.setDouble(1, expense.getAmount());
            pstmt.setString(2, expense.getDescription());
            pstmt.setDate(3, new java.sql.Date(expense.getDate().getTime()));
            pstmt.setInt(4, expense.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	System.out.println();
        	System.out.println("---------Delete------------");
        	
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getTotalExpenses() {
        double total = 0;
        String sql = "SELECT SUM(amount) AS total FROM expenses";
        System.out.println();
        System.out.println("---------Total Expenses------------");
        System.out.println();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
