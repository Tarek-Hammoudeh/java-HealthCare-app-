import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MeerderePatient {

    public void allPatientsList() {
        ArrayList<Patient> patientsList = new ArrayList<>();
        DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Patient patient1 = new Patient();
        patient1.setFirstName("Johan");
        patient1.setLastName("Ivan");
        patient1.setAge(57);
        patient1.setLength(1.80);

        patient1.addMedicine(new Medicine(500, "Paracetamol", 3));
        patient1.addMedicine(new Medicine(250, "Ibuprofen", 3));

        patient1.addWeight(new Weight(88, LocalDate.parse("02/02/2020",formatt)));
        patient1.addWeight(new Weight(86, LocalDate.parse("02/03/2020",formatt)));
        patient1.addWeight(new Weight(87, LocalDate.parse("02/04/2020",formatt)));
        patient1.addWeight(new Weight(84, LocalDate.parse("02/05/2020",formatt)));
        patient1.addWeight(new Weight(85.2, LocalDate.parse("02/06/2020",formatt)));
        patient1.addWeight(new Weight(84.1, LocalDate.parse("02/07/2020",formatt)));
        patient1.addWeight(new Weight(84, LocalDate.parse("02/08/2020",formatt)));
        patient1.addWeight(new Weight(83, LocalDate.parse("02/09/2020",formatt)));
        patient1.addWeight(new Weight(84, LocalDate.parse("02/10/2020",formatt)));
        patient1.addWeight(new Weight(83, LocalDate.parse("02/11/2020",formatt)));
        patient1.addWeight(new Weight(83.2, LocalDate.parse("02/12/2020",formatt)));
        patient1.addWeight(new Weight(82.6, LocalDate.parse("02/01/2021",formatt)));
        patient1.addWeight(new Weight(82.2, LocalDate.parse("02/02/2021",formatt)));
        patient1.addWeight(new Weight(81.9, LocalDate.parse("02/03/2021",formatt)));
        patient1.addWeight(new Weight(81, LocalDate.parse("02/04/2021",formatt)));

        Patient patient2 = new Patient();
        patient2.setFirstName("Karoline");
        patient2.setLastName("Henk");
        patient2.setAge(60);
        patient2.setLength(1.72);
        patient2.addMedicine(new Medicine(125, "Valerian", 4));
        patient2.addMedicine(new Medicine(150, "Parasol", 3));
        patient2.addWeight(new Weight(78, LocalDate.parse("02/05/2020",formatt)));
        patient2.addWeight(new Weight(77.2, LocalDate.parse("02/06/2020",formatt)));
        patient2.addWeight(new Weight(76.9, LocalDate.parse("02/07/2020",formatt)));


        Patient patient3 = new Patient();
        patient3.setFirstName("Jake ");
        patient3.setLastName("Bond");
        patient3.setAge(62);
        patient3.setLength(1.68);

        patient3.addMedicine(new Medicine(400, "Parasol", 2));
        patient3.addMedicine(new Medicine(300, "ORS", 4));


        patientsList.add(patient1);
        patientsList.add(patient2);
        patientsList.add(patient3);

//        int weightListSize=patient1.getWeightLijst().size();
//        Weight lastWeight=patient1.getWeightLijst().get(weightListSize-1);
//        System.out.println("Last Weight");
//        System.out.println(lastWeight.getWeight());
//first list (patient)
        while (true){
            System.out.println("You have "+ patientsList.size()+" patienst");
            System.out.println("Choose the patient number you want to view: [1] for patient one.. etc | press 0 to go back  ");
            Scanner input = new Scanner(System.in);
            int number=input.nextInt();
            if (number==0)
                break;
            else {
                Patient p = patientsList.get(number-1);
                System.out.println(p.getFirstName() + " " + p.getLastName());
                System.out.println("Age: " + p.getAge() + " Years old ");
                System.out.println("Length is : " + p.getLength() + " M ");
                //second list Weight
                System.out.println("Weight Registrations: ==>");
                System.out.println("=========================");
                for (int z = 0; z < p.getWeightLijst().size(); z++) {
                    Weight wed = p.getWeightLijst().get(z);

                    System.out.println("Weight: " + wed.getWeight() + " KG | Register date :" + wed.getRegisterDate());

                }
                System.out.println("Medicines : ==>");
                System.out.println("=========================");
                for (int i = 0; i < p.getMedicijnLijst().size(); i++) {
                    Medicine med = p.getMedicijnLijst().get(i);

                    System.out.print(med.getName() + ", ");
                    System.out.print(med.getDossier() + " MG, ");
                    System.out.println(med.getKeer() + " Times per day");
                    System.out.println("****");

                }
                System.out.println("---------------");
            }
        }

//        for (int x = 0; x <patientsList.size(); x++) {
//            Patient p = patientsList.get(x);
//            System.out.println(p.getFirstName() + " " + p.getLastName());
//            System.out.println("Age: " + p.getAge() + " Years old ");
//            System.out.println("Length is : " + p.getLength() + " M ");
//            //second list Weight
//            System.out.println("Weight Registrations: ==>");
//            System.out.println("=========================");
//            for (int z = 0; z < p.getWeightLijst().size(); z++) {
//                Weight wed = p.getWeightLijst().get(z);
//
//                System.out.println("Weight: " + wed.getWeight() + " KG | Register date :" + wed.getRegisterDate());
//
//            }
//            System.out.println("Medicines : ==>");
//            System.out.println("=========================");
//            for (int i = 0; i < p.getMedicijnLijst().size(); i++) {
//                Medicine med = p.getMedicijnLijst().get(i);
//
//                System.out.print(med.getName() + ", ");
//                System.out.print(med.getDossier() + " MG, ");
//                System.out.println(med.getKeer() + " Times per day");
//                System.out.println("****");
//
//            }
//            System.out.println("---------------");
//        }

    }
}
