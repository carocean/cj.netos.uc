package cj.netos.uc.model;

/**
 * Table: phone_verifycode
 */
public class PhoneVerifycode {
    /**
     * Column: person
     */
    private String person;

    /**
     * Column: verifycode
     */
    private String verifycode;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode == null ? null : verifycode.trim();
    }
}