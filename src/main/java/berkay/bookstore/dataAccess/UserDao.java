package berkay.bookstore.dataAccess;

import berkay.bookstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
