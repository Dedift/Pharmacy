package ru.aston.pharmacy.dto.mappers.clientmappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.client.User;
import ru.aston.pharmacy.dto.clientDTO.UserDTO;
import ru.aston.pharmacy.dto.mappers.BaseMapper;

import java.util.List;

@Mapper(uses = BaseMapper.class)
public interface UserMapper {
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOList(List<User> users);
    User toUser(UserDTO userDTO);
    List<User> toUserList(List<UserDTO> userDTOs);
}