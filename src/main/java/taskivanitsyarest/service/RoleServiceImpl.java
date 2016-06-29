package taskivanitsyarest.service;

import org.springframework.beans.factory.annotation.Autowired;
import taskivanitsyarest.dao.entity.Role;
import taskivanitsyarest.dao.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 29.06.2016.
 */
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleRepository roleRepository;


    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role getRole(Long id) {
        Role result = roleRepository.findOne(id);
        return result;
    }

    @Override
    public Role getRole(String userRole) {
        Role role = new Role();
        role.setName(userRole);
        return role;
    }

    @Override
    public void createRole(String userRole) {
        Role newRole = new Role();
        newRole.setName(userRole);
        List<Role> listRole = new ArrayList<>();
        listRole.add(newRole);

        roleRepository.save(listRole);
    }

    @Override
    public void deleteRole(String roleName) {
        Role role = roleRepository.findByRoleName(roleName);

        roleRepository.delete(role.getName());
    }
}
