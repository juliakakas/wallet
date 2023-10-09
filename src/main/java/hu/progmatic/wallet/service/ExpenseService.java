package hu.progmatic.wallet.service;

import hu.progmatic.wallet.model.Expense;
import hu.progmatic.wallet.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepo expenseRepo;

    @Autowired
    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepo.findById(id).orElse(null);
    }

    public void addNewExpense(Expense expense) {
        expenseRepo.save(expense);
    }
}
