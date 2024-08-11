import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Rechner {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        System.out.println("Willkommen");
        System.out.println();

        System.out.print("Geben Sie Ihren Benutzernamen ein: ");
        String userName = scan.nextLine();

        System.out.println("Bitte geben Sie Zahl 1 ein:");
        double a = 0.0;
        try {
            a = scan.nextDouble();
        } catch (Exception err) {
            System.out.println("Invalid");
        }


        System.out.println("Bitte geben Sie Zahl 2 ein:");
        double b = scan.nextDouble();

        System.out.println("Was möchten Sie machen? Z.b '+', '-', '*', '/' ");
        char userInput = scan.next().charAt(0);
        double result =  berechungResult(a, b, userInput);

        String rechnung = a + " " + userInput + " " + b + " = " + result;

        if (!Double.isNaN(result)) {
            System.out.println("Das Ergebnis ist: " + result);
            logErgebnis(userName, rechnung);
        }
    }

    public static double berechungResult(double a, double b, char userInput) {
        boolean gultigeOperation= true;
        double result=0;
        switch (userInput) {

            case '+':
                result = addier(a,b);
                break;
            case '-':
                result = subtrahier(a,b);
                break;
            case '*':
                result = multiplizier(a,b);
                break;
            case '/':
                result = dividier(a,b);
                break;
            default:
                System.out.println("Sorry, das geht nicht!");
                gultigeOperation= false;
                break;
        }
        if (!gultigeOperation) {
            result = Double.NaN;
        }
        return  result;
    }

    public static double addier(double a, double b) {
        return a + b;
    }

    public static double subtrahier(double a, double b) {
        return a - b;
    }

    public static double multiplizier(double a, double b) {
        return a * b;
    }

    public static double dividier(double a, double b) {
        if (b == 0) {
            System.out.println("Fehler: Division durch Null ist nicht erlaubt.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void logErgebnis(String userName, String rechnung) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write("User: " + userName+ " => " + rechnung + "\n");
        } catch (IOException e) {
            System.out.println("Fehler : " + e.getMessage());
        }
    }

}
