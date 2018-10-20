package kz.phobos.tm.core.service.UserService;

import kz.phobos.tm.core.model.User;
import kz.phobos.tm.core.repository.UserJpaRepo;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService implements IUserService{


    @Autowired
    UserJpaRepo userJpaRepo;

    @Override
    public List<User> getAllUser() {

        return userJpaRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {

        return userJpaRepo.findOne(id);
    }

    @Override
    public void addUser(User user) throws DataException {
        userJpaRepo.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) throws DataAccessException {
        userJpaRepo.delete(user);
    }




}
