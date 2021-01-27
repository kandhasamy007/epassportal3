package virtusa.project.epass.userlogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import virtusa.project.epass.Userform;
import virtusa.project.epass.UserformRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MailController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    MailRepository mailRepository;
    @Autowired
    UserformRepository userformRepository;

    @GetMapping("/login")
    public  String login()
    {
        return "user/login";
    }
    @GetMapping("/about")
    public String about()
    {
        return "user/about";
    }
    @GetMapping("/support")
    public String support()
    {
        return "user/support";
    }
    @PostMapping("/sendotp")
    public String add(Mail body, Model model,RedirectAttributes redirectAttributes) {
        int otp1;
        Mail k = mailRepository.findByEmail(body.getEmail());
        otp1 = (int) (Math.random() * (999999-000000) + 000000);
        try
        {
            Mail user=new Mail();
            user.setEmail(body.getEmail());
            user.setOtp(otp1);
            notificationService.sendNotification(user);
        }catch (MailException e)
        {
            return "redirect:/login?error2";
        }
        if (k == null) {
            mailRepository.save(body);
            Optional<Mail> edit1 = mailRepository.findById(body.getId());
            Mail editnow = edit1.get();
            editnow.setOtp(otp1);
            mailRepository.save(editnow);
        } else {
            long  m= (long) k.getId();
            Optional<Mail> edit1 = mailRepository.findById(m);
            Mail editnow1=edit1.get();
            editnow1.setOtp(otp1);
            mailRepository.save(editnow1);
        }
        redirectAttributes.addAttribute("emailid",body.getEmail());
        return "redirect:/otp";
    }
    @PostMapping("/sendform")
    public String sendform(@RequestParam("email") String email,
                           @RequestParam("reason") String reason,
                           @RequestParam("date") String date,
                           @RequestParam("applicant_name") String applicant_name,
                           @RequestParam("gender") String gender,
                           @RequestParam("parent_name") String parent_name,
                           @RequestParam("age") String age,
                           @RequestParam("count") String count,
                           @RequestParam("id_proof") String id_proof,
                           @RequestParam("id_proof_num") String id_proof_num,
                           @RequestParam("idproof")MultipartFile file1,
                           @RequestParam("travel_on") String travel_on,
                           @RequestParam("travel_distance") String travel_distance,
                           @RequestParam("from_state") String from_state,
                           @RequestParam("from_district") String from_district,
                           @RequestParam("from_flatno") String from_flatno,
                           @RequestParam("from_street") String from_street,
                           @RequestParam("from_lacality") String from_lacality,
                           @RequestParam("from_pincode") String from_pincode,
                           @RequestParam("to_state") String to_state,
                           @RequestParam("to_district") String to_district,
                           @RequestParam("to_flatno") String to_flatno,
                           @RequestParam("to_street") String to_street,
                           @RequestParam("to_lacality") String to_lacality,
                           @RequestParam("to_pincode") String to_pincode,
                           @RequestParam("documentproof") MultipartFile file2,
                           @RequestParam("add_remarks") String add_remarks,RedirectAttributes redirectAttributes) {
        try {
            Userform formbody = new Userform(email, reason, date, applicant_name, gender, parent_name, age, count, id_proof, id_proof_num, file1.getBytes(), travel_on, travel_distance, from_state, from_district, from_flatno, from_street, from_lacality, from_pincode, to_state, to_district, to_flatno, to_street, to_lacality, to_pincode, file2.getBytes(), add_remarks, "APPLIED");
            formbody.setIdproof_type(file1.getContentType());
            formbody.setDocumentproof_type(file2.getContentType());
            userformRepository.save(formbody);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        String[] l=email.split("@");
        redirectAttributes.addAttribute("message",l[0]);
        redirectAttributes.addAttribute("emailid",email);
        return "redirect:/userhome?success";
    }
    @RequestMapping("/otp")
    public String opt(@RequestParam("emailid") String email2,Model model){model.addAttribute("email",email2); return "user/otp";}
    @RequestMapping("/userhome")
    public String userhome(@RequestParam("message") String message,@RequestParam("emailid") String email2,Model model)
    {
        try
        {
            model.addAttribute("message", message);
            model.addAttribute("email", email2);
            List<Userform> uform = userformRepository.findAll();
            List<Userform> newform = new ArrayList<>();
            for (Userform get : uform) {
                if ((get.getEmail()).equals(email2)) {
                    newform.add(get);
                }
            }
            model.addAttribute("show", newform);
        }
        catch(Exception e)
        {
            return "/user/userhome";
        }
        return "/user/userhome";
    }
    @RequestMapping("/otpverification")
    public  String otpverifi(@RequestParam("otp") String otp, @RequestParam("email") String email2, Model model, RedirectAttributes redirectAttributes)
    {
        Mail p=mailRepository.findByEmail(email2);
        String[] l=email2.split("@");
        redirectAttributes.addAttribute("message",l[0]);
        redirectAttributes.addAttribute("emailid",email2);
        if(String.valueOf(p.getOtp()).equals(otp))
        {
            return "redirect:/userhome";
        }
        if(p.getEmail()!=null)
        return "redirect:/otp?error2";
        return "redirect:/login?error2";
    }
}
