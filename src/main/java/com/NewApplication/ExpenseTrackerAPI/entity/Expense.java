package com.NewApplication.ExpenseTrackerAPI.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expenses")
@Data
@NoArgsConstructor
public class Expense {
    @Id
    private ObjectId id;
    @NonNull
    private String description;
    private Category category;
}
