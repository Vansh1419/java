package com.practice.blog.mapper;

import com.practice.blog.dto.UserDto;
import com.practice.blog.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<User,UserDto>{
    private ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto mapFromEntityToDto(User user){
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public User mapFromDtoToEntity(UserDto userDto){
        return modelMapper.map(userDto,User.class);
    }
}
