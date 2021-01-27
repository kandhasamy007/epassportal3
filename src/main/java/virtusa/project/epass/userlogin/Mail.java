package virtusa.project.epass.userlogin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String email;
    private int otp;
    public Mail(){}
    public Mail(String email,int otp)
    {
        this.setEmail(email);
        this.setOtp(otp);
    }
    public  Mail(long id,String email,int otp)
    {
        this.setId(id);
        this.setEmail(email);
        this.setOtp(otp);
    }
    public long getId() {return id; }

    private void setId(long id) { this.id=id;
    }
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public int getOtp(){ return otp;}
    public void setOtp(int otp){this.otp=otp;}
    @Override
    public String toString(){
        return "Mail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}

