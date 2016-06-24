package taskivanitsyarest.dao.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import taskivanitsyarest.dao.entity.User;

/**
 * Created by Администратор on 23.06.2016.
 */

@Component
public interface UserRepository /*extends CrudRepository<User, Long>*/   // TODO: 24.06.2016  разобраться почему не хочет наследоваться
{

    User findByUserName(String userName);
}

