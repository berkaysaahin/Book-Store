package berkay.bookstore.business;

import berkay.bookstore.dataAccess.UserDao;
import berkay.bookstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService{

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String add(User user) {
         this.userDao.save(user);
         return "Kullanıcı kaydedildi.";

    }

    @Override
    public User findByEmail(String email) {
        return this.userDao.findByEmail(email);
    }
}
