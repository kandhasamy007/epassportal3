package virtusa.project.epass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import virtusa.project.epass.userlogin.NotificationService;


import java.util.List;
import java.util.Optional;

@Controller
public class UserAddminService {
    @Autowired
    UserformRepository userformRepository;
    @Autowired
    NotificationService notificationService;
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadfile(@PathVariable long id)
    {
        Optional<Userform> userdown=userformRepository.findById(id);
        Userform getdown= userdown.get();
        String[] type=getdown.getIdproof_type().split("/");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(getdown.getIdproof_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + getdown.getId_proof_num()+"."+type[1] + "\"")
                .body(new ByteArrayResource(getdown.getIdproof()));
    }
    @GetMapping("/download1/{id}")
    public ResponseEntity<Resource> downloadfile1(@PathVariable long id)
    {
        Optional<Userform> userdown1=userformRepository.findById(id);
        Userform getdown1= userdown1.get();
        String[] type=getdown1.getDocumentproof_type().split("/");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(getdown1.getDocumentproof_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + getdown1.getReason()+"document."+type[1] + "\"")
                .body(new ByteArrayResource(getdown1.getDocumentproof()));
    }
    @GetMapping("/accepted/{id}")
    public String accept(@PathVariable long id)
    {
        Optional<Userform> userdown1=userformRepository.findById(id);
        Userform getdown1= userdown1.get();
        getdown1.setResult("ACCEPTED");
        userformRepository.save(getdown1);
        notificationService.accept(getdown1);
        return "redirect:/adminhome";
    }
    @GetMapping("/denied/{id}")
    public String  denied(@PathVariable long id)
    {
        Optional<Userform> userdown1=userformRepository.findById(id);
        Userform getdown1= userdown1.get();
        getdown1.setResult("DENIED");
        userformRepository.save(getdown1);
        notificationService.denied(getdown1.getEmail());
        return "redirect:/adminhome";
    }
}
