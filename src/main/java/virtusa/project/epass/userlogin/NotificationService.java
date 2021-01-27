package virtusa.project.epass.userlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import virtusa.project.epass.Userform;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    public NotificationService(JavaMailSender emailSender)
    {
        this.emailSender=emailSender;
    }
    public void sendNotification(Mail user)  throws MailException
    {
        String msg="\t\t\tcovid19 ePass portal \n\n \t Your one time login OTP is "+String.valueOf(user.getOtp())+".";
        SimpleMailMessage sendmessage=new SimpleMailMessage();
        sendmessage.setSubject("One Time Password ");
        sendmessage.setText(msg);
        sendmessage.setTo(user.getEmail());
        sendmessage.setFrom("kandhasamy946@gamil.com");
        System.out.println("start" + user+ sendmessage);
        emailSender.send(sendmessage);
        System.out.println("start" + user+ sendmessage);
    }

    public void accept(Userform email) throws MailException {
        SimpleMailMessage sendmessage=new SimpleMailMessage();
        sendmessage.setSubject("covid19 ePass portal");
        sendmessage.setText("Congratulations,\n"
                        +"\n\t"+"Hi! "+email.getApplicant_name()+", Your ePass Application is Accepted.\n"
                        +"\n\t\t\tApplicant Details \n"
                        +"\n\tApplicant Name  : "+ email.getApplicant_name()
                        +"\n\tID Proof                : "+email.getId_proof()+" "+email.getId_proof_num()
                        +"\n\tGender                  : "+email.getGender()
                        +"\n\tReason                  : "+email.getReason()
                        +"\n\tDate                       : "+email.getDate()
                        +"\n\tTravel On              : "+email.getTravel_on()
                        +"\n\tTravellers Count  : "+email.getCount()
                        +"\n\tFrom                      : "+email.getFrom_district()
                        +"\n\tTo                           : "+email.getTo_district());
        sendmessage.setTo(email.getEmail());
        sendmessage.setFrom("kandhasamy6820@gamil.com");
        emailSender.send(sendmessage);
    }

    public void denied(String email) throws MailException {
        SimpleMailMessage sendmessage=new SimpleMailMessage();
        sendmessage.setSubject("covid19 ePass portal");
        sendmessage.setText("Your ePass Application is Rejected.");
        sendmessage.setTo(email);
        sendmessage.setFrom("kandhasamy6820@gamil.com");
        emailSender.send(sendmessage);
    }
}

