package com.example.ecommerce.mapper;

import com.example.ecommerce.domain.dto.CommentDto;
import com.example.ecommerce.domain.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "userId", source = "user.id")
    CommentDto toDto(Comment comment);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "product", ignore = true)
    Comment fromDto(CommentDto commentDto);
}
