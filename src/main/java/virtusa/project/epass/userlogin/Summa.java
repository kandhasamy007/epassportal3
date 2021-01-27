package virtusa.project.epass.userlogin;

import antlr.ASTNULLType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import virtusa.project.epass.Userform;
import virtusa.project.epass.UserformRepository;

import java.util.List;

@RestController
public class Summa {
    @Autowired
    UserformRepository userformRepository;
    @Autowired
    MailRepository mailRepository;
    @GetMapping("/k007")
    public List<Mail> bdsb()
    {
        return mailRepository.findAll();
    }
}
