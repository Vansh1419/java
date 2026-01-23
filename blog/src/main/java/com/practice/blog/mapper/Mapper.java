package com.practice.blog.mapper;

public interface Mapper<E,D> {
    public D mapFromEntityToDto(E entity);
    public E mapFromDtoToEntity(D dto);
}
