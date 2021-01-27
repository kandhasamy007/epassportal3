package virtusa.project.epass.adminlogin;

import virtusa.project.epass.Userform;
import virtusa.project.epass.adminlogin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);

}
