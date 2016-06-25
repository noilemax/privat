package taskivanitsyarest.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import taskivanitsyarest.dao.entity.User;

import java.io.Serializable;

/**
 * Created by Администратор on 23.06.2016.
 */


@Component
public interface UserRepository extends CrudRepository<User, Long> {        // TODO: 24.06.2016 разобраться почему не проходит метод?
//    User findByUserName(String userName);
}