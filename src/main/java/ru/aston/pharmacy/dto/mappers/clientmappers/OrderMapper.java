package ru.aston.pharmacy.dto.mappers.clientmappers;

import org.mapstruct.Mapper;
import ru.aston.pharmacy.domain.client.Order;
import ru.aston.pharmacy.dto.clientDTO.OrderDTO;
import ru.aston.pharmacy.dto.mappers.BaseMapper;

import java.util.List;

@Mapper(uses = BaseMapper.class)
public interface OrderMapper {
    OrderDTO orderDto(Order order);
    List<OrderDTO> mapTpOrderDtoList(List<Order> orders);
}

