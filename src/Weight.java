import java.time.LocalDate;

public class Weight {
    private double weight;
    private LocalDate registerDate;


    // Student class constructor


    public Weight(double weight, LocalDate registerDate) {
        this.weight = weight;
        this.registerDate = registerDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}
