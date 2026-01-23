package com.practice.blog.mapper;

import com.practice.blog.dto.UserDto;
import com.practice.blog.entity.User;

public class UserMapperImpl implements Mapper<User,UserDto>{
    @Override
    public UserDto mapFromEntityToDto(User user){
        if(user == null) return null;
        UserDto tempUser = new UserDto();
        tempUser.setUserId(user.getId());
        tempUser.setName(user.getName());
        tempUser.setUserName(user.getUserName());
        return tempUser;
    }

    @Override
    public User mapFromDtoToEntity(UserDto userDto){
        if(userDto == null) return null;
        User tempUser = new User();
        tempUser.setId(userDto.getUserId());
        tempUser.setName(userDto.getName());
        tempUser.setUserName(userDto.getUserName());
        return tempUser;
    }
}
