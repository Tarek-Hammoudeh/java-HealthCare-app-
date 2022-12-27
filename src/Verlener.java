import java.time.LocalDate;

public class Verlener {
    private String firstName;
    private String lastName;
    private String afdeling;
    private String expertise;
    private LocalDate verlenerBod;

    public Verlener() {
    }

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

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public LocalDate getVerlenerBod() {
        return verlenerBod;
    }

    public void setVerlenerBod(LocalDate verlenerBod) {
        this.verlenerBod = verlenerBod;
    }
}