package ee.ttu.vorgurakendused.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(int id);

    User findByUsername(String username);
}
