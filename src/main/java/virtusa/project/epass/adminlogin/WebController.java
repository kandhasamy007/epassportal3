package virtusa.project.epass.adminlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import virtusa.project.epass.Userform;
import virtusa.project.epass.UserformRepository;
import virtusa.project.epass.adminlogin.models.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {
    @Autowired
    UserformRepository userformRepository;
    @GetMapping("/adminlogin")
    public String login()
    {
        return "admin/adminlogin";
    }
    @GetMapping("/adminhome")
    public  String admin(Model model, Principal principal)
    {
        try {
            List<Userform> adminform = userformRepository.findAll();
            List<Userform> adform = new ArrayList<>();
            String[] admindist = principal.getName().split("@");
            for (Userform k1 : adminform) {
                if (k1.getResult().equals("APPLIED") && k1.getTo_district().equalsIgnoreCase(admindist[1])) {
                    adform.add(k1);
                }
            }
            model.addAttribute("show", adform);
            model.addAttribute("message", principal.getName());
        }
        catch(Exception e)
        {
            return "/admin/adminhome";
        }
        return "/admin/adminhome";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id,Model model,Principal principal)
    {
        Optional<Userform> viewform=userformRepository.findById(id);
        Userform viewadmin=viewform.get();
        String email2 =viewadmin.getEmail();
        List<Userform> uform= userformRepository.findAll();
        List<Userform> newform = new ArrayList<>();
        String[] useradmin=principal.getName().split("@");
        if(useradmin[1].equalsIgnoreCase(viewadmin.getTo_district()) && viewadmin.getResult().equals("APPLIED")) {
            for (Userform get : uform) {
                if ((get.getEmail()).equals(email2)) {
                    newform.add(get);
                }
            }
            model.addAttribute("viewuserdetails", viewadmin);
            model.addAttribute("message", principal.getName());
            model.addAttribute("show", newform);
            return "/admin/viewadmin";
        }
        return "redirect:/adminhome";
    }
}
