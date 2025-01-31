package bad.pals.movies.service;

import bad.pals.movies.model.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByEmail(String email);
    User save(User user);
    User update(User user);
    void deleteById(Long id);
    void delete(User user);
}
