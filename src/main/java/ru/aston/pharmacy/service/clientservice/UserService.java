package ru.aston.pharmacy.service.clientservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pharmacy.domain.client.Gender;
import ru.aston.pharmacy.domain.client.Role;
import ru.aston.pharmacy.domain.client.User;
import ru.aston.pharmacy.dto.clientDTO.UserDTO;
import ru.aston.pharmacy.dto.mappers.clientmappers.UserMapper;
import ru.aston.pharmacy.repository.clientrepositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private static final String DELETE_USER = "Delete user: {}";
    private static final String ACCEPTED_TO_DELETE_USER_DTO = "Accepted to delete userDTO: {}";
    private static final String UPDATE_USER = "Update user: {}";
    private static final String ACCEPTED_TO_UPDATE = "Accepted to update userDTO: {}";
    private static final String FIND_USERS_BY_LAST_NAME = "Find users: {} by last name: {}";
    private static final String FIND_USERS_BY_FIRST_NAME = "Find users: {} by first name: {}";
    private static final String FIND_USERS_BY_ROLE = "Find users: {} by role: {}";
    private static final String FIND_USERS_BY_GENDER = "Find users: {} by gender: {}";
    private static final String FIND_USER_BY_EMAIL = "Find user: {} by email: {}";
    private static final String FIND_USER_BY_ID = "Find user: {} by id: {}";
    private static final String FIND_ALL_USERS = "Find all users: {}";
    private static final String SAVE_USER_WITH_ID = "Save user: {} with id: {}";
    private static final String ACCEPTED_TO_SAVE = "Accepted to save userDTO: {}";
    private UserRepository userRepository;
    private UserMapper userMapper;
    private Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Accept the userDTO, map to a user, save, and return its primary key
     */
    @Transactional
    public Integer save(UserDTO userDTO) {
        logger.debug(ACCEPTED_TO_SAVE, userDTO);
        User saved = userRepository.save(userMapper.toUser(userDTO));
        Integer id = saved.getId();
        logger.debug(SAVE_USER_WITH_ID, saved, id);
        return id;
    }

    /**
     * Find all users, map to DTOs, and get
     */
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        logger.debug(FIND_ALL_USERS, users);
        return userMapper.toUserDTOList(users);
    }

    /**
     * Find a user by id, map to DTO, and get
     */
    public Optional<UserDTO> findById(Integer id) {
        Optional<User> maybeUser = userRepository.findById(id);
        Optional<UserDTO> optionalUserDTO = Optional.empty();
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            logger.debug(FIND_USER_BY_ID, user, id);
            optionalUserDTO = Optional.ofNullable(userMapper.toUserDTO(user));
        }
        return optionalUserDTO;
    }

    /**
     * Find user by email, map to userDTO, and get
     */
    public Optional<UserDTO> loadUserByUsername(String username) {
        Optional<User> maybeUser = userRepository.findByEmail(username);
        Optional<UserDTO> optionalUserDTO = Optional.empty();
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            logger.debug(FIND_USER_BY_EMAIL, user, username);
            optionalUserDTO = Optional.ofNullable(userMapper.toUserDTO(user));
        }
        return optionalUserDTO;
    }

    /**
     * Find all users by gender, map to DTOs, and get
     */
    public List<UserDTO> findByGender(Gender gender) {
        List<User> users = userRepository.findByGender(gender);
        logger.debug(FIND_USERS_BY_GENDER, users, gender);
        return userMapper.toUserDTOList(users);
    }

    /**
     * Find all users by role, map to DTOs, and get
     */
    public List<UserDTO> findByRole(Role role) {
        List<User> users = userRepository.findByRole(role);
        logger.debug(FIND_USERS_BY_ROLE, users, role);
        return userMapper.toUserDTOList(users);
    }

    /**
     * Find all users by first name, map to DTOs, and get
     */
    public List<UserDTO> findByFirstName(String firstName) {
        List<User> users = userRepository.findByName(firstName);
        logger.debug(FIND_USERS_BY_FIRST_NAME, users, firstName);
        return userMapper.toUserDTOList(users);
    }

    /**
     * Find all users by last name, map to DTOs, and get
     */
    public List<UserDTO> findByLastName(String lastName) {
        List<User> users = userRepository.findBySurName(lastName);
        logger.debug(FIND_USERS_BY_LAST_NAME, users, lastName);
        return userMapper.toUserDTOList(users);
    }

    /**
     * Accept the userDTO, map to a user, and update
     */
    @Transactional
    public void update(UserDTO userDTO) {
        logger.debug(ACCEPTED_TO_UPDATE, userDTO);
        User user = userMapper.toUser(userDTO);
        userRepository.save(user);
        logger.debug(UPDATE_USER, user);
    }

    /**
     * Accept the userDTO, map to a user, and delete
     */
    @Transactional
    public void delete(UserDTO userDTO) {
        logger.debug(ACCEPTED_TO_DELETE_USER_DTO, userDTO);
        User user = userMapper.toUser(userDTO);
        userRepository.delete(user);
        logger.debug(DELETE_USER, user);
    }
}
