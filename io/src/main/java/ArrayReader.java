import java.util.Locale;
import java.util.Scanner;

public class ArrayReader {

    public static void main(String[] args) {
        double sum = 0.0;
        Scanner scan =
                new Scanner("1,3;2,0; 8,5; 4,8; 9,0; 1; 10");
        scan.useLocale(new Locale("ru"));
        scan.useDelimiter(";\\s*");
        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                sum += scan.nextDouble();
            } else {
                System.out.println(scan.next());
            }
        }
        System.out.printf("Сумма чисел = " + sum);

    }
}