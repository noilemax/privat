package taskivanitsyarest.service;

import org.springframework.stereotype.Component;
import taskivanitsyarest.dao.entity.User;

import java.util.List;

/**
 * Created by Администратор on 23.06.2016.
 */
@Component
public interface UserService {
    List<User> getAllUsers();

    User getUser(String userName);

    void createUser(String userName, String password, Byte isActive);

    void deleteUser(String userName);
}
