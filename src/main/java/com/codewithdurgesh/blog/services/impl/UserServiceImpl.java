package com.codewithdurgesh.blog.services.impl;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.entities.User;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.repositories.UserRepo;
import com.codewithdurgesh.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // UserRepo is calling bcz we are saving into database...
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.userDtoToUser(userDto); // conversion required as data stored into database via dto to entity data
        User savedUser = this.userRepo.save(user);
        return this.userTOUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User" , " Id " , userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.userTOUserDto(updatedUser); // After save User data send to UserDto Data
        return  userDto1;

    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(" User " , "User Id ", userId ));
        return this.userTOUserDto(user); // directly calling User data to User Dto as for not exposing Entity data ...
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user->this.userTOUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(" User " , "User Id ", userId ));
        this.userRepo.delete(user);
    }

    public User userDtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto , User.class);
        return user;
    }

    public UserDto userTOUserDto(User user){
        UserDto userDto = this.modelMapper.map(user , UserDto.class);
        return userDto;
    }


    // Below process is used for conversion from Entity to DTO without using ModelMapper ...

    // conversion from UserDto to User , bcz we take UserDTO instead of User Entity name for privacy .
    //    public User userDtoToUser(UserDto userDto){
    //        User user = new User();
    //        user.setId(userDto.getId());
    //        user.setName(userDto.getName());
    //        user.setEmail(userDto.getEmail());
    //        user.setPassword(userDto.getPassword());
    //        user.setAbout(userDto.getAbout());
    //        return user;
    //    }

    // conversion form User Entity to UserDto
    //    public UserDto userTOUserDto (User user){
    //        UserDto userDto = new UserDto();
    //        userDto.setId(user.getId());
    //        userDto.setName(user.getName());
    //        userDto.setEmail(user.getEmail());
    //        userDto.setPassword(user.getPassword());
    //        userDto.setAbout(user.getAbout());
    //        return userDto;
    //    }
}
