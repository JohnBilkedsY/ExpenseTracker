package com.jdbc;

import java.util.Date;

public class Expense {
    private int id;
    private double amount;
    private String description;
    private Date date;

    public Expense(int id, double amount, String description, Date date) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { 
    	return id; }
    public double getAmount() { 
    	return amount; }
    public String getDescription() { 
    	return description; }
    public Date getDate() { 
    	return date; }

    public void setId(int id) { 
    	this.id = id; }
    public void setAmount(double amount) { 
    	this.amount = amount; }
    public void setDescription(String description) { 
    	this.description = description; }
    public void setDate(Date date) { 
    	this.date = date; }
}
