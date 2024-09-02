package com.NewApplication.ExpenseTrackerAPI;

import com.NewApplication.ExpenseTrackerAPI.entity.Expense;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, ObjectId> {
}
