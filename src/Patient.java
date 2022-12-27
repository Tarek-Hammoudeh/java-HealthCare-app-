import java.time.LocalDate;
import java.util.ArrayList;


public class Patient {
    private String firstName;
    private String lastName;
    private String callName;
    private String adres;
    private double length;
    private int weight;
    private int age;
    private LocalDate dateOfBirth;
    private ArrayList<Medicine> medicijnLijst;
    private ArrayList<Weight> weightLijst;
    private ArrayList<Verlener> verlenersLijst;

    public Patient(ArrayList<Verlener> verlenersLijst) {
        this.verlenersLijst = verlenersLijst;
    }

    // Constructor
    public Patient() {
        medicijnLijst = new ArrayList<Medicine>();
        weightLijst = new ArrayList<Weight>();
    }

    public void addMedicine(Medicine medicine) {
        medicijnLijst.add(medicine);
    }

    public void addWeight(Weight weight) {

        weightLijst.add(weight);
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

    public String getCallName() {
        return callName;
    }

    public void setCallName(String callName) {
        this.callName = callName;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Medicine> getMedicijnLijst() {

        return medicijnLijst;
    }

    public void setMedicijnLijst(ArrayList<Medicine> medicijnLijst) {
        this.medicijnLijst = medicijnLijst;
    }

    public ArrayList<Weight> getWeightLijst() {
        return weightLijst;
    }

    public void setWeightLijst(ArrayList<Weight> weightLijst) {
        this.weightLijst = weightLijst;
    }
}




