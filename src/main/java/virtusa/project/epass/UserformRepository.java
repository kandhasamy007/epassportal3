package virtusa.project.epass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserformRepository extends JpaRepository<Userform, Long> {
    Userform findByEmail(String email);
}
