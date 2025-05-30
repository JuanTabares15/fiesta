package com.mycompany.fiesta;

public class FinanceManagement {
    private double budget;
    private double income;
    private double expenses;

    public FinanceManagement(double budget) {
        this.budget = budget;
        this.income = 0;
        this.expenses = 0;
    }

    public void addIncome(double amount) {
        this.income += amount;
    }

    public void addExpense(double amount) {
        this.expenses += amount;
    }

    public double calculateProfit() {
        return income - expenses;
    }

    // Getters and Setters
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }

    public double getExpenses() { return expenses; }
    public void setExpenses(double expenses) { this.expenses = expenses; }

    @Override
    public String toString() {
        return "FinanceManagement [Budget=" + budget + ", Income=" + income + ", Expenses=" + expenses + ", Profit=" + calculateProfit() + "]";
    }
}
