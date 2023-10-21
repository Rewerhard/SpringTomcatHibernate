package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;
    private Validator validator;

    @Autowired
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }


    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }


    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }


    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
}
