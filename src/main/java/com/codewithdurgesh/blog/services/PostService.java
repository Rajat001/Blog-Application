package com.codewithdurgesh.blog.services;

import com.codewithdurgesh.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    // create
    PostDto createPost(PostDto postDto , Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto , Integer postId);

    // Delete
    void deletePost(Integer postId);

    // Get all list
    List<PostDto> getAllPost();

    // Get single post
    PostDto getPostById(Integer postId);

    // Get All Post By Category (categoryId)
    List<PostDto> getPostsByCategory(Integer categoryId);

    // Get All Post By User (userId)
    List<PostDto> getPostsByUser(Integer userId);

    // search posts
    List<PostDto> searchPosts(String Keyword);

}
