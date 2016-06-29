package taskivanitsyarest.dao.repository;

import org.springframework.data.repository.CrudRepository;
import taskivanitsyarest.dao.entity.Role;

/**
 * Created by Администратор on 23.06.2016.
 */


public interface RoleRepository extends CrudRepository<Role, Long> {
        Role findByRoleName(String userRole);

        void delete(String RoleName);
}
