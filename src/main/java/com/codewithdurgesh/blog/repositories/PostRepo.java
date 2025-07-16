package com.codewithdurgesh.blog.repositories;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Now here main method will be called ...
public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user); // Calling list of Post using User ...
    List<Post> findByCategory(Category category); // Calling list of Post using Category
}
