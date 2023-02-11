package capstone.agora.Repository;

import capstone.agora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserIdentifier(String userId);

    boolean existsUserByUserIdentifier(String userId);

}
