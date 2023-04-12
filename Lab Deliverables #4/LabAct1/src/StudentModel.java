/**
 * @brief Student Model
 */

public class StudentModel {
    /**
     * properties
     */
    private String name, number, degree, year, contactNum, email,pos;

    /**
     * constructors
     */
    public StudentModel() {
    }

    public StudentModel(String name, String number, String degree, String year, String contactNum, String email, String pos) {
        this.name = name;
        this.number = number;
        this.degree = degree;
        this.year = year;
        this.contactNum = contactNum;
        this.email = email;
        this.pos = pos;
    }

    /**
     * behaviors
     */
    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ("[" + name + "," + number + "," + degree + "," + year + "," + contactNum + "," + email + "]");
    }
}
