package virtusa.project.epass.userlogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    Mail findByEmail(String email);
    /*spring.datasource.url=jdbc:mysql://${MySQL_HOST:localhost}:3306/virtusa
spring.datasource.username=root
spring.datasource.password=kandha007
spring.datasource.url=jdbc:mysql://db4free.net:3306/kandha007
spring.datasource.username=kandha07
spring.datasource.password=kandha007*/
}
