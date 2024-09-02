package com.NewApplication.ExpenseTrackerAPI;

import com.NewApplication.ExpenseTrackerAPI.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.Authentication;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
    void deleteByUsername(Authentication authentication);
}
