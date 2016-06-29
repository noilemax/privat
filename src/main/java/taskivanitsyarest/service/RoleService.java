package taskivanitsyarest.service;

import org.springframework.stereotype.Component;
import taskivanitsyarest.dao.entity.Role;
import taskivanitsyarest.dao.entity.User;

import java.util.List;

/**
 * Created by Администратор on 23.06.2016.
 */

@Component
public interface RoleService {

    List<Role> getAllRoles();

    Role getRole(Long id);

    Role getRole(String userRole);

    void createRole(String userRole);

    void deleteRole(String roleName);


}
