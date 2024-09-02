package com.NewApplication.ExpenseTrackerAPI.controller;

import com.NewApplication.ExpenseTrackerAPI.entity.Expense;
import com.NewApplication.ExpenseTrackerAPI.entity.User;
import com.NewApplication.ExpenseTrackerAPI.service.ExpenseService;
import com.NewApplication.ExpenseTrackerAPI.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenseVale")
public class ExpenseController {
   @Autowired
   private ExpenseService expenseService;

   @Autowired
   private UserService userService;

   @GetMapping
   public List<Expense> getAllExpenseOfUser(){
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String username = authentication.getName();
      User user = userService.findByUserName(username);
      List<Expense> all = user.getExpenseDetails();
      return all;
   }

   @PostMapping
   public void saveExpense(@RequestBody Expense expense) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String username = authentication.getName();
      expenseService.saveEntry(expense, username);
   }

   @DeleteMapping("/{username}/{id}")
   public void deleteExpense(@PathVariable ObjectId id, @PathVariable String username){
      expenseService.deleteById(id, username);
   }

}
