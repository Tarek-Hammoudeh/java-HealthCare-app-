import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class VerlenerMenu {
    public void vMenu(int lang) {
        Scanner input = new Scanner(System.in);
        ResourceBundle bundle;
        if (lang == 1) {
            Locale.setDefault(new Locale("Dutch"));
        } else {
            Locale.setDefault(new Locale("English"));
        }
        bundle = ResourceBundle.getBundle("Language");
        while (true) {
            System.out.println(bundle.getString("MenuV01"));
            System.out.println(bundle.getString("MenuV02"));
            System.out.println(bundle.getString("MenuV03"));
            System.out.println(bundle.getString("MenuV04"));
            System.out.println(bundle.getString("MenuV05"));
            int choice = input.nextInt();
            VerlenerMenu menu = new VerlenerMenu();
            MeerderePatient meer = new MeerderePatient();
            switch (choice) {
                case 1:
                    menu.newPatientIfo(lang);
                    break;
                case 2:
                    meer.allPatientsList();
                    break;
                case 3:
                    // menu.newVerlener();
                    break;
                case 4:
                    break;

                default:
                    System.out.println(bundle.getString("MenuV06"));
            }
        }
    }

    public void newPatientIfo(int lang) {
        ResourceBundle bundle;

        if (lang == 1) {
            Locale.setDefault(new Locale("Dutch"));
        } else {
            Locale.setDefault(new Locale("English"));
        }
        bundle = ResourceBundle.getBundle("Language");

        // ArrayList<Patient> patientsList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate sysDate = LocalDate.now();
        Period diffrence = null;
        LocalDate dateOfBirth = null;
        LocalDate registerDate = null;
        LocalDate verlenerDob = null;
        String weightDate = null;
        String dob = null;
        //verlenerDob=LocalDate.parse(dob,formatter);
        //registerDate=LocalDate.parse(weightDate,formatter);


        System.out.println("                        =========PLEASE FILL IN THE FOLLOWING INFORMATION =========");
        System.out.println("");


        // Patient gegevens
        Patient p = new Patient();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the patient's First name => ");
        p.setFirstName(input.nextLine());

        System.out.println("Enter the patient's Second name => ");
        p.setLastName(input.nextLine());

        System.out.println("Enter the patient's Call name => ");
        p.setCallName(input.nextLine());

        // Geboortedatum controleren
        boolean isValid;
        String bDay;
        do {
            isValid = true;
            System.out.println("Enter the patient's birthdate  in the following sequence => dd/MM/yyyy");
            try {
                bDay = input.nextLine();

                // Geboortedatum omzetten naar datum
                dateOfBirth = LocalDate.parse(bDay, formatter);

                // Controleer of de datum in de toekomst
                if (dateOfBirth.isAfter(sysDate)) {
                    System.out.println("Future date !!");
                    isValid = false;
                }
                // Bereken het verschil tussen geboortedatum en huidige datum
                diffrence = Period.between(dateOfBirth, sysDate);

            } catch (Exception e) {
                System.out.println("Wrong date !!");
                isValid = false;
            }
        } while (!isValid);
        p.setAge(diffrence.getYears());
        p.setDateOfBirth(dateOfBirth);

        System.out.println("Enter the  patient's  Address ");
        p.setAdres(input.nextLine());

        int choice1 = 1;
        do {
            System.out.println("Enter the  patient's  medicines:.... ");
            System.out.println("Enter medicine name ");
            String name = input.nextLine();
            System.out.println("Enter medicine dossier ");
            int dossier = input.nextInt();
            int keer = input.nextInt();
            p.addMedicine(new Medicine(dossier, name, keer));
            System.out.println("To add more medicine press [1]. To stop adding medicines press any key ");
            try {
                choice1 = input.nextInt();
            } catch (Exception e) {
                break;
            }
            input.nextLine();
        } while (choice1 == 1);


        //***************************
        // while(!input.hasNextDouble()){
        // input.next();
        //*****************************
        System.out.println("What is the patient's height in M?");
        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.println("Please enter a valid number!! ");
        }
        p.setLength(input.nextDouble());

        int choice2 = 1;
        do {
            System.out.println("Enter the  patient's  weight info:.... ");
            System.out.println("Enter weight value ");
            double value = input.nextDouble();
            input.nextLine();
            System.out.println("Enter weight date ");
            String date = input.nextLine();
            p.addWeight(new Weight(value, LocalDate.parse(date, formatter)));
            System.out.println("To add more weight registers press [1]. To stop adding registers press any key ");
            try {
                choice2 = input.nextInt();
            } catch (Exception e) {
                break;
            }
            input.nextLine();
        } while (choice2 == 1);
        //patientsList.add(p);
        Verlener verlener = new Verlener();

        System.out.println("Enter Caregiver first name==>:");
        verlener.setFirstName(input.nextLine());
        System.out.println("Enter Caregiver last name==>:");
        verlener.setLastName(input.nextLine());
        System.out.println("Enter Caregiver department ==>:");
        verlener.setAfdeling(input.nextLine());

//        double bmi = p.getWeight() / (p.getLength() * p.getLength());

        System.out.println("=====THE PATIENT'S INFO ARE:========");
        System.out.println();
        System.out.println("The patient full  name is :" + p.getFirstName() + "  " + p.getLastName());
        // System.out.println("The last name is :"+ p.getLastName());
        System.out.println("The call name is :" + p.getCallName() + " . ");
        System.out.println("The birthdate is :" + p.getDateOfBirth());
        System.out.println("The age is: " + p.getAge() + " years old");
        System.out.println("The height is: " + p.getLength() + "M");
        System.out.println("Medicine List:");
        for (int i = 0; i < p.getMedicijnLijst().size(); i++) {
            Medicine med = p.getMedicijnLijst().get(i);
            System.out.print(med.getName() + " | " + med.getDossier() + " | " + med.getKeer() + " times per day");
            System.out.println("****");

        }
        System.out.println("---------------");
        System.out.println("Weight registrations:");
        for (int z = 0; z < p.getWeightLijst().size(); z++) {
            Weight wed = p.getWeightLijst().get(z);
            System.out.println("Weight: " + wed.getWeight() + " KG | Register date :" + wed.getRegisterDate());
            System.out.println("****");
        }
        // Get last weight
        int weightListSize = p.getWeightLijst().size();
        Weight lastWeight = p.getWeightLijst().get(weightListSize - 1);
        System.out.println("Last Weight");
        System.out.println(lastWeight.getWeight());

        //        double bmi = p.getWeight() / (p.getLength() * p.getLength());

        double bmi = lastWeight.getWeight() / (p.getLength() * p.getLength());
        //printf=(String %.2f) voor 2 decimal
        //System.out.printf("%.2f"+bmi);
        if (bmi < 18.50)
            System.out.printf("   BMI IS : %.2f     =====--|------|------| UNDER WEIGHT", bmi);
        else if ((bmi > 18.50) || (bmi < 24.90))
            System.out.printf("   BMI IS : %.2f     ======|===---|------| HEALTHY WEIGHT", bmi);
        else if (bmi > 25.00 || bmi < 29.90)
            System.out.printf("   BMI IS : %.2f ======|======|===---| OVER WEIGHT", bmi);


//        public void newVerlener () {
//            //Verlener verlener1 = new Verlener();
//            // Scanner input1 = new Scanner(System.in);
//            //DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//            System.out.println("Enter Caregiver first name==>:");
//            verlener.setFirstName(input.nextLine());
//            System.out.println("Enter Caregiver last name==>:");
//            verlener.setLastName(input.nextLine());
//            System.out.println("Enter Caregiver Date of birth in the following sequence dd/mm/yyyy ==>:");
//            String Dob = input.nextLine();
//            verlener.setVerlenerBod(LocalDate.parse(Dob, formatter));
//            System.out.println("Enter Caregiver department ==>:");
//            verlener.setAfdeling(input.nextLine());
//        }
    }
}
