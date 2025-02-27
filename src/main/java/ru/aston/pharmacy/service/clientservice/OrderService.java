package ru.aston.pharmacy.service.clientservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pharmacy.domain.client.Order;
import ru.aston.pharmacy.dto.clientDTO.OrderDTO;
import ru.aston.pharmacy.dto.mappers.clientmappers.OrderMapper;
import ru.aston.pharmacy.repository.clientrepositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private static final String DELETE_ORDER = "Delete order: {}";
    private static final String ACCEPTED_TO_DELETE_ORDER_DTO = "Accepted to delete orderDTO: {}";
    private static final String UPDATE_ORDER = "Update order: {}";
    private static final String ACCEPTED_TO_UPDATE = "Accepted to update orderDTO: {}";
    private static final String FIND_ORDER_BY_ID = "Find order: {} by id: {}";
    private static final String FIND_ALL_ORDERS = "Find all orders: {}";
    private static final String SAVE_ORDER_WITH_ID = "Save order: {} with id: {}";
    private static final String ACCEPTED_TO_SAVE = "Accepted to save orderDTO: {}";
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    /**
     * Accept the orderDTO, map to an order, save, and return its primary key
     */
    @Transactional
    public Integer save(OrderDTO orderDTO) {
        logger.debug(ACCEPTED_TO_SAVE, orderDTO);
        Order saved = orderRepository.save(orderMapper.toOrder(orderDTO));
        Integer id = saved.getId();
        logger.debug(SAVE_ORDER_WITH_ID, saved, id);
        return id;
    }

    /**
     * Find all orders, map to DTOs, and get
     */
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        logger.debug(FIND_ALL_ORDERS, orders);
        return orderMapper.toOrderDTOList(orders);
    }

    /**
     * Find an order by id, map to DTO, and get
     */
    public Optional<OrderDTO> findById(Integer id) {
        Optional<Order> maybeOrder = orderRepository.findById(id);
        Optional<OrderDTO> optionalOrderDTO = Optional.empty();
        if (maybeOrder.isPresent()) {
            Order order = maybeOrder.get();
            logger.debug(FIND_ORDER_BY_ID, order, id);
            optionalOrderDTO = Optional.ofNullable(orderMapper.toOrderDTO(order));
        }
        return optionalOrderDTO;
    }

    /**
     * Accept the orderDTO, map to an order, and update
     */
    @Transactional
    public void update(OrderDTO orderDTO) {
        logger.debug(ACCEPTED_TO_UPDATE, orderDTO);
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        logger.debug(UPDATE_ORDER, order);
    }

    /**
     * Accept the orderDTO, map to an order, and delete
     */
    @Transactional
    public void delete(OrderDTO orderDTO) {
        logger.debug(ACCEPTED_TO_DELETE_ORDER_DTO, orderDTO);
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.delete(order);
        logger.debug(DELETE_ORDER, order);
    }
}
