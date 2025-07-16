package com.codewithdurgesh.blog.repositories;

import com.codewithdurgesh.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// ek interface doosre interface ko extend kr rha h ...
public interface UserRepo extends JpaRepository<User, Integer> {

}
