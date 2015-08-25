package curso.microforum.jee.spring;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
 
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
 
public class Alumno {
 
    @Size(min=3, max=30)
    private String firstName;
 
    @Size(min=3, max=30)
    private String lastName;
 
    @NotEmpty
    private String sex;
 
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Past @NotNull
    private Date cumple;
 
    @Email @NotEmpty
    private String email;
 
    private boolean firstAttempt;
 
    @NotEmpty
    private List<String> subjects = new ArrayList<String>();
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getSex() {
        return sex;
    }
 
    public void setSex(String sex) {
        this.sex = sex;
    }
 
    public Date getCumple() {
        return cumple;
    }
 
    public void setCumple(Date fnac) {
        this.cumple = fnac;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
 
    public boolean isFirstAttempt() {
        return firstAttempt;
    }
 
    public void setFirstAttempt(boolean firstAttempt) {
        this.firstAttempt = firstAttempt;
    }
 
    public List<String> getSubjects() {
        return subjects;
    }
 
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
 
    @Override
    public String toString() {
        return "Alumno [Nombre=" + firstName + ", Apellidos=" + lastName
                + ", Sexo=" + sex + ", Cumple=" + cumple + ", Correo=" + email
                + ", Primera matricula=" + firstAttempt + ", asignaturas=" + subjects
                + "]";
    }
 
}