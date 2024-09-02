package com.NewApplication.ExpenseTrackerAPI.service;

import com.NewApplication.ExpenseTrackerAPI.ExpenseRepository;
import com.NewApplication.ExpenseTrackerAPI.entity.Expense;
import com.NewApplication.ExpenseTrackerAPI.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserService userService;
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    public void saveEntry(Expense expense, String username) {
        User user = userService.findByUserName(username);
        Expense saved = expenseRepository.save(expense);
        user.getExpenseDetails().add(saved);
        userService.saveUser(user);
    }

    public void deleteById(ObjectId id, String username){
        User user = userService.findByUserName(username);
        user.getExpenseDetails().removeIf(x -> x.getId().equals(id));
        userService.saveUser(user);
        expenseRepository.deleteById(id);
    }

}
