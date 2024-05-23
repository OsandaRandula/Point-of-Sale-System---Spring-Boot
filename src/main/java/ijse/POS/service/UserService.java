package ijse.POS.service;

import java.util.List;


import ijse.POS.entity.User;


public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

    
}