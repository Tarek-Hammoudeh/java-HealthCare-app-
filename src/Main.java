import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("                                                 |--------------------------|");
        System.out.println("                                                 |        WELCOME IN        |");
        System.out.println("                                                 |    THE HEAlT CARE APP    |");
        System.out.println("                                                 |--------------------------|");

        Scanner input = new Scanner(System.in);
        System.out.println("            Voor Nederlands druk op [ 1 ]" + "                                          For English press [ 2 ]");


            ResourceBundle bundle;

            int language = input.nextInt();
            if (language == 1) {
                Locale.setDefault(new Locale("Dutch"));
            } else {
                Locale.setDefault(new Locale("English"));
            }


            bundle = ResourceBundle.getBundle("Language");
        while (true) {


            System.out.println("                       ******************* "+bundle.getString("Menu01")+" ********************** ");
            System.out.println("======================================================================================================================");
            System.out.println("                                              "+bundle.getString("Menu02")+" ");
            System.out.println();
            System.out.println("  "+bundle.getString("Menu03") + "                                              " + bundle.getString("Menu04"));
            int choice = input.nextInt();
            VerlenerMenu verlener = new VerlenerMenu();
            switch (choice) {
                case 1:
                    verlener.vMenu(language);
                    break;
                case 2:
                    PatientMenu patient = new PatientMenu();

                    break;
                default:
                    System.out.println(bundle.getString("Menu05"));


            }
        }
    }
}

















