package taskivanitsyarest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import taskivanitsyarest.dao.entity.Role;
import taskivanitsyarest.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import taskivanitsyarest.dao.entity.enums.UserRoleEnum;

import java.util.HashSet;
import java.util.Set;
/**
 * Created by Администратор on 29.06.2016.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUser("user1");
        Role rolee =roleService.getRole("USER");
        Set<GrantedAuthority> role = new HashSet<>();
//        role.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
        role.add(new SimpleGrantedAuthority(rolee.getName().toString()));
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(),
                        user.getPassword(),
                        role);

        return userDetails;
    }
}
