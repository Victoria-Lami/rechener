import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Taschenrechner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie Ihren Benutzernamen ein: ");
        String benutzername = scanner.nextLine();

        boolean conutiue = true;

        while (conutiue) {
            try {

                System.out.println("Willkommen beim Taschenrechner!");

                System.out.print("Geben Sie die erste Zahl ein: ");
                double zahl1 = scanner.nextDouble();
                //double zahl1 = getNummber();

                System.out.print("Geben Sie die zweite Zahl ein: ");
                double zahl2 = scanner.nextDouble();

                System.out.print("Wählen Sie die Operation (+, -, *, /): ");
                char operation = scanner.next().charAt(0);

                double ergebnis = berechneErgebnis(zahl1, zahl2, operation);
                if (Double.isNaN(ergebnis)) {
                    System.out.println("Programm wird beendet .");
                    return;
                }

                String rechnung = zahl1 + " " + operation + " " + zahl2 + " = " + ergebnis;

                System.out.println("Das Ergebnis ist: " + ergebnis);
                logErgebnis(benutzername, rechnung);
            } catch (InputMismatchException e) {
                System.out.println("Ungultige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
            } catch (Exception e) {
                System.out.println("Ein Fehler ist : " + e.getMessage());
            }
            System.out.print("Möchten Sie weitere Berechnung ? (ja/nein): ");
            String antwort = scanner.next();

            if (!antwort.equalsIgnoreCase("ja")) {
                conutiue = false;
            }
        }

    }

   /* public static double getNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean conutiue = true;
        while (conutiue) {
            try {
                System.out.println("Willkommen beim Taschenrechner!");

                System.out.print("Geben Sie die erste Zahl ein: ");
                double zahl1 = scanner.nextDouble();

                System.out.print("Geben Sie die zweite Zahl ein: ");
                double zahl2 = scanner.nextDouble();

                System.out.print("Wählen Sie die Operation (+, -, *, /): ");
                char operation = scanner.next().charAt(0);

                double ergebnis = berechneErgebnis(zahl1, zahl2, operation);
                if (Double.isNaN(ergebnis)) {
                    System.out.println("Programm wird beendet .");
                    return;
                }

                String rechnung = zahl1 + " " + operation + " " + zahl2 + " = " + ergebnis;

                System.out.println("Das Ergebnis ist: " + ergebnis);
                logErgebnis(benutzername, rechnung);
            } catch (InputMismatchException e) {
                System.out.println("Ungultige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
            } catch (Exception e) {
                System.out.println("Ein Fehler ist : " + e.getMessage());
            }
            System.out.print("Möchten Sie weitere Berechnung ? (ja/nein): ");
            String antwort = scanner.next();

            if (!antwort.equalsIgnoreCase("ja")) {
                conutiue = false;
            }
        }
    }

    */


        public static double berechneErgebnis( double zahl1, double zahl2, char operation){
            double ergebnis = 0;
            boolean gultigeOperation = true;

            if (operation == '+') {
                ergebnis = addiere(zahl1, zahl2);
            } else if (operation == '-') {
                ergebnis = subtrahiere(zahl1, zahl2);
            } else if (operation == '*') {
                ergebnis = multipliziere(zahl1, zahl2);
            } else if (operation == '/') {
                ergebnis = dividiere(zahl1, zahl2);
            } else {
                System.out.println("Ungultige Operation.");
                gultigeOperation = false;
            }

            if (!gultigeOperation) {
                ergebnis = Double.NaN;
            }

            return ergebnis;
        }

        public static double addiere ( double a, double b){
            return a + b;
        }

        public static double subtrahiere ( double a, double b){
            return a - b;
        }

        public static double multipliziere ( double a, double b){
            return a * b;
        }

        public static double dividiere ( double a, double b){
            if (b == 0) {
                System.out.println("Fehler: ");
                return Double.NaN;
            }
            return a / b;
        }

        public static void logErgebnis (String benutzername, String rechnung){
            try (FileWriter writer = new FileWriter("log.txt", true)) {
                writer.write("User: " + benutzername + " => " + rechnung + "\n");
            } catch (IOException e) {
                System.out.println("Fehler : " + e.getMessage());
            }
        }
    }


/*while
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Geben Sie die erste Zahl ein: ");
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ungultige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
            System.out.print("Geben Sie die erste Zahl ein: ");
            return scanner.nextDouble();
        }
    }

    */