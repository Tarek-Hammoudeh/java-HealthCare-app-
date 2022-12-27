public class Medicine {
    private  String name;
    private int dossier;
    private int keer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDossier() {
        return dossier;
    }

    public void setDossier(int dossier) {
        this.dossier = dossier;
    }

    public int getKeer() {
        return keer;
    }

    public void setKeer(int keer) {
        this.keer = keer;
    }

    // Student class constructor
    Medicine(int dossier, String name, int keer)
    {
        this.dossier = dossier;
        this.name = name;
        this.keer = keer;
    }


}
