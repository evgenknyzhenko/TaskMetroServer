package app.dao;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User getByAge(int Age);

    User getBymobileNo(Long mobileNo);

    User save(User user);
}
