package taskivanitsyarest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taskivanitsyarest.dao.entity.User;
import taskivanitsyarest.dao.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired(required = false)
    private UserRepository userRepository;


    @Override
    public void createUser(String userName, String password, Byte isActive) {
        User newUser = new User();
        newUser.setUsername(userName);
        newUser.setPassword(password);
        newUser.setIsactive(isActive);
        List<User> listUser = new ArrayList<>();
        listUser.add(newUser);

        userRepository.save(listUser);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = (List<User>) userRepository.findAll();

        return result;
    }

    @Override
    public User getUser(Long id) {
        User result = userRepository.findOne(id);
        return result;
    }


    @Override
    public void deleteUser(String userName) {
        //TODO Verify for null and empty values
        User user = userRepository.findByUserName(userName);

        userRepository.delete(user.getUsername());
    }

    @Override
    public User getUser(String login) {
        User user = new User();
        user.setUsername(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }


//
//    @Resource(name = "sessionFactory")
//    private SessionFactory sessionFactory;
//
//    /**
//     * возврат всех юзеров
//     */
//    public List<User> getAll() {
//
//        // сессия для Hibernate
//        Session session = sessionFactory.getCurrentSession();
//
//
//        Query query = session.createQuery("FROM User");
//
//        // получаем всех юзеров
//        return query.list();
//    }
//
//    /**
//     * возврат одного юзера
//     */
//    public User get(Integer id) {
//        // сессия для Hibernate
//        Session session = sessionFactory.getCurrentSession();
//
//        // получаем существующих пользователей
//        // запрос Hibernate (HQL)
//        Query query = session.createQuery("FROM User as p.roleEntity WHERE p.id=" + id);
//
//        return (User) query.uniqueResult();
//    }
//
//    /**
//     * добавляем нового юзера
//     */
//    public void add(User user) {
//
//        // сессия для хибернейта Hibernate
//        Session session = sessionFactory.getCurrentSession();
//
//        // сохраняем в db
//        session.save(user);
//    }
//
//    /**
//     * удаляем существующего юзера
//     */
//    public void delete(Integer id) {
//
//        // откр сессию для Hibernate
//        Session session = sessionFactory.getCurrentSession();
//
//        // запрос Hibernate
//        Query query = session.createQuery("FROM User as p.roleEntity WHERE p.id=" + id);
//
//        // получаем
//        User user = (User) query.uniqueResult();
//
//        Set<Role> roleEntities = user.getRole();
//
//        // удаляем юзера
//        session.delete(user);
//
//        // удоляем его роль
//        for (Role role : roleEntities) {
//            session.delete(role);
//        }
//    }
//
//    /**
//     * изменяем существующего юзера
//     */
//    public void edit(User user) {
//
//        // Retrieve session from Hibernate
//        Session session = sessionFactory.getCurrentSession();
//
//        // получаем юзера по ID
//        User existingUser = (User) session.get(User.class, user.getId());
//
//        // обновления по данному юзеру
//        existingUser.setUsername(user.getUsername());
//        existingUser.setPassword(user.getPassword());
//        existingUser.setIsactive(user.getIsactive());
//        existingUser.setRole(user.getRole());
//        // сохранить изменения
//        session.save(existingUser);
//    }
}


