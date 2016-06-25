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

    User getUser(Long id);

    void createUser(String userName, String password, Byte isActive);

    void deleteUser(Long id);
}
