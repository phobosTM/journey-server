package kz.phobos.tm.core.service.UserService;

import kz.phobos.tm.core.model.User;
import org.hibernate.exception.DataException;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();
    User getUserById(Integer id);

    //Post Method
    void addUser(User user) throws DataException;

    void deleteUser(User user) throws DataException;





}
