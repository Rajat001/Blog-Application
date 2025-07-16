package com.codewithdurgesh.blog.services;

import com.codewithdurgesh.blog.payloads.UserDto;

import java.util.List;

public interface UserService {
        UserDto createUser(UserDto userDto); // using UserDto bcz return type is UserDto
        UserDto updateUser(UserDto userDto , Integer userId);
        UserDto getUserById(Integer userId);
        List<UserDto> getAllUsers();
        void deleteUser(Integer userId); // using void bcz we r not printing any return type

}
