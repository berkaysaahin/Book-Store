package berkay.bookstore.business;

import berkay.bookstore.entities.User;

import java.util.List;

public interface UserService {

    String add(User user);
    User findByEmail(String email);
}
