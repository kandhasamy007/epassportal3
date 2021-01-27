package virtusa.project.epass;


import javax.persistence.*;

@Entity
public class Userform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    private String reason;
    private String date;
    private String applicant_name;
    private String gender;
    private String parent_name;
    private String age;

    private String count;
    private String id_proof;
    private String id_proof_num;
    @Lob
    private  byte[] idproof;
    private String idproof_type;
    private String travel_on;
    private String travel_distance;

    private String from_state;
    private String from_district;
    private String from_flatno;
    private String from_street;
    private String from_lacality;
    private String from_pincode;

    private String to_state;
    private String to_district;
    private String to_flatno;
    private String to_street;
    private String to_lacality;
    private String to_pincode;

    @Lob
    private  byte[] documentproof;
    private String documentproof_type;
    private String add_remarks;
    private String result;
    public Userform()
    {

    }
    public Userform(String email, String reason, String date, String applicant_name, String gender, String parent_name, String age, String count, String id_proof, String id_proof_num, byte[] idproof, String travel_on, String travel_distance, String from_state, String from_district, String from_flatno, String from_street, String from_lacality, String from_pincode, String to_state, String to_district, String to_flatno, String to_street, String to_lacality, String to_pincode, byte[] documentproof, String add_remarks, String result)
    {
        this.setEmail(email);
        this.setReason(reason);
        this.setDate(date);
        this.setApplicant_name(applicant_name);
        this.setGender(gender);
        this.setParent_name(parent_name);
        this.setAge(age);
        this.setCount(count);
        this.setId_proof(id_proof);
        this.setId_proof_num(id_proof_num);
        this.setIdproof(idproof);
        this.setIdproof_type(idproof_type);
        this.setTravel_on(travel_on);

        this.setTravel_distance(travel_distance);
        this.setFrom_state(from_state);
        this.setFrom_district(from_district);
        this.setFrom_flatno(from_flatno);
        this.setFrom_street(from_street);
        this.setFrom_lacality(from_lacality);
        this.setFrom_pincode(from_pincode);
        this.setTo_state(to_state);
        this.setTo_district(to_district);
        this.setTo_flatno(to_flatno);
        this.setTo_street(to_street);
        this.setTo_lacality(to_lacality);
        this.setTo_pincode(to_pincode);
        this.setDocumentproof(documentproof);
        this.setDocumentproof_type(documentproof_type);
        this.setAdd_remarks(add_remarks);
        this.setResult(result);
    }
   /* public Userform(long id,String email, String reason, String date, String applicant_name, String gender, String parent_name, String age, String count, String id_proof, String id_proof_num, byte[] idproof,String idproof_type, String travel_on, String travel_distance, String from_state, String from_district, String from_flatno, String from_street, String from_lacality, String from_pincode, String to_state, String to_district, String to_flatno, String to_street, String to_lacality, String to_pincode, byte[] documentproof,String documentproof_type, String add_remarks,String result)
    {
        this.setId(id);
        this.setEmail(email);
        this.setReason(reason);
        this.setDate(date);
        this.setApplicant_name(applicant_name);
        this.setGender(gender);
        this.setParent_name(parent_name);
        this.setAge(age);
        this.setCount(count);
        this.setId_proof(id_proof);
        this.setId_proof_num(id_proof_num);
        this.setIdproof(idproof);
        this.setTravel_on(travel_on);

        this.setTravel_distance(travel_distance);
        this.setFrom_state(from_state);
        this.setFrom_district(from_district);
        this.setFrom_flatno(from_flatno);
        this.setFrom_street(from_street);
        this.setFrom_lacality(from_lacality);
        this.setFrom_pincode(from_pincode);
        this.setTo_state(to_state);
        this.setTo_district(to_district);
        this.setTo_flatno(to_flatno);
        this.setTo_street(to_street);
        this.setTo_lacality(to_lacality);
        this.setTo_pincode(to_pincode);
        this.setDocumentproof(documentproof);
        this.setAdd_remarks(add_remarks);
        this.setResult(result);
    }*/

    public String getIdproof_type() {
        return idproof_type;
    }

    public void setIdproof_type(String idproof_type) {
        this.idproof_type = idproof_type;
    }

    public String getDocumentproof_type() {
        return documentproof_type;
    }

    public void setDocumentproof_type(String documentproof_type) {
        this.documentproof_type = documentproof_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId_proof() {
        return id_proof;
    }

    public void setId_proof(String id_proof) {
        this.id_proof = id_proof;
    }

    public String getId_proof_num() {
        return id_proof_num;
    }

    public void setId_proof_num(String id_proof_num) {
        this.id_proof_num = id_proof_num;
    }

    public byte[] getIdproof() {
        return idproof;
    }

    public void setIdproof(byte[] idproof) {
        this.idproof = idproof;
    }

    public String getTravel_on() {
        return travel_on;
    }

    public void setTravel_on(String travel_on) {
        this.travel_on = travel_on;
    }

    public String getTravel_distance() {
        return travel_distance;
    }

    public void setTravel_distance(String travel_distance) {
        this.travel_distance = travel_distance;
    }

    public String getFrom_state() {
        return from_state;
    }

    public void setFrom_state(String from_state) {
        this.from_state = from_state;
    }

    public String getFrom_district() {
        return from_district;
    }

    public void setFrom_district(String from_district) {
        this.from_district = from_district;
    }

    public String getFrom_flatno() {
        return from_flatno;
    }

    public void setFrom_flatno(String from_flatno) {
        this.from_flatno = from_flatno;
    }

    public String getFrom_street() {
        return from_street;
    }

    public void setFrom_street(String from_street) {
        this.from_street = from_street;
    }

    public String getFrom_lacality() {
        return from_lacality;
    }

    public void setFrom_lacality(String from_lacality) {
        this.from_lacality = from_lacality;
    }

    public String getFrom_pincode() {
        return from_pincode;
    }

    public void setFrom_pincode(String from_pincode) {
        this.from_pincode = from_pincode;
    }

    public String getTo_state() {
        return to_state;
    }

    public void setTo_state(String to_state) {
        this.to_state = to_state;
    }

    public String getTo_district() {
        return to_district;
    }

    public void setTo_district(String to_district) {
        this.to_district = to_district;
    }

    public String getTo_flatno() {
        return to_flatno;
    }

    public void setTo_flatno(String to_flatno) {
        this.to_flatno = to_flatno;
    }

    public String getTo_street() {
        return to_street;
    }

    public void setTo_street(String to_street) {
        this.to_street = to_street;
    }

    public String getTo_lacality() {
        return to_lacality;
    }

    public void setTo_lacality(String to_lacality) {
        this.to_lacality = to_lacality;
    }

    public String getTo_pincode() {
        return to_pincode;
    }

    public void setTo_pincode(String to_pincode) {
        this.to_pincode = to_pincode;
    }

    public byte[] getDocumentproof() {
        return documentproof;
    }

    public void setDocumentproof(byte[] documentproof) {
        this.documentproof = documentproof;
    }

    public String getAdd_remarks() {
        return add_remarks;
    }

    public void setAdd_remarks(String add_remarks) {
        this.add_remarks = add_remarks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public  String  toString()
    {
        return "Userform{"+
                "id=" + id +
                "email ="+ email + '\''+
                ",reason =" + reason +"\'"+
        ",date ="+ date +"\'"+
        ",applicant_name =" + applicant_name +"\'"+
        ",gender =" + gender +"\'"+
        ",parent_name =" + parent_name +"\'"+
        ",age = " + age +"\'"+
        ",count ="+ count +"\'"+
        ",id_proof = " +id_proof +"\'"+
        ",id_proof_num =" + id_proof_num +"\'"+
        ",idproof =" +idproof +"\'"+
        ",travel_on =" + travel_on +"\'"+

        ",travel_distance = "+ travel_distance +"\'"+
        ",from_state =" + from_state +"\'"+
        ",from_district =" + from_district +"\'"+
        ",from_flatno = "+ from_flatno +"\'"+
        ",from_street =" + from_street +"\'"+
        ",from_lacality ="+ from_lacality +"\'"+
        ",from_pincode ="+ from_pincode +"\'"+
        ",to_state ="+ to_state +"\'"+
        ",to_district ="+ to_district +"\'"+

        ",to_flatno ="+ to_flatno +"\'"+
        ",to_street ="+ to_street +"\'"+
        ",to_lacality =" + to_lacality +"\'"+
        ",to_pincode =" + to_pincode +"\'"+
        ",documentproof =" + documentproof +"\'"+
        ",add_remarks =" + add_remarks +"\'"+
        ",result = "+result +"\'" + '}';
    }
}
