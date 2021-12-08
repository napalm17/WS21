package kit.edu.informatik.u3.b2.PersonRelated;

public class Person {
    enum Role {
        STUDENT,
        LECTURER,
        SECURITY
    }
    enum CovidProof {
        VACCINATED,
        RECOVERED,
        TESTED,
        NO_CERTIFICATE
    }
    private int id;
    private String firstName;
    private String lastName;
    private Role role;
    private int proofdate;
    private CovidProof covidProof;

    public Person(int id, String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.id = id;
        this.covidProof = CovidProof.NO_CERTIFICATE;
    }
    public int getId () {
        return this.id;
    }
    public String getRole () {
        return this.role.name().toLowerCase();
    }
    public String getFullInfo () {
        return this.id + ", " + this.firstName + " " + this.lastName + ", " + this.role.name().toLowerCase() + ", "
                + this.covidProof.name().toLowerCase().replaceAll("_"," ");
    }
    public void setCertificate (String proof, int date) {
        this.covidProof = CovidProof.valueOf(proof.toUpperCase());
        this.proofdate = date;
    }
    public String getProoftype () {
        return this.covidProof.name();
    }
    public int getProofdate () {
        return this.proofdate;
    }
}
