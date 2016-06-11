import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;
import java.util.Timer;

public class FormatterExamples {
    public static void main(String[] args) {
        appending();
        positioning();
        hexOctDecimal();
        aligning();
        dateFormatting();
        dateLocaleFormatting();
    }

    private static void dateLocaleFormatting() {
        Calendar cal = Calendar.getInstance();
        System.out.printf(Locale.FRANCE, "%1$tB %1$tA%n", cal);
        System.out.printf(Locale.getDefault(), "%1$tB %1$tA%n", cal);
    }

    private static void dateFormatting() {
        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance();

        formatter.format("%tr", calendar);
        System.out.println(formatter);
    }

    private static void aligning() {
        Formatter formatter = new Formatter();
        int i1 = 345;
        double d1 = 16.78967;
        formatter.format("- %-7dok%n", i1);
        formatter.format("- %+7dok%n", i1);
        formatter.format("- % 7dok%n", i1);
        formatter.format("- %07dok%n", i1);
        formatter.format("- %#fok%n", d1);
        formatter.format("- %.2fok%n", d1);
        System.out.println(formatter);
    }

    private static void hexOctDecimal() {
        Formatter formatter = new Formatter();

        int i1 = 17;
        double d1 = 16.78967;
        formatter.format("1. (%%o) %o%n", i1);
        formatter.format("2. (%%a) %a%n", d1);
        formatter.format("3. (%%x) %x%n", i1);

        formatter.format("4. (%%#o) %#o%n", i1);
        formatter.format("5. (%%#a) %#a%n", d1);
        formatter.format("6. (%%#x) %#x%n", i1);
        System.out.println(formatter);
    }

    private static void positioning() {
        Formatter formatter = new Formatter();
        double d1 = 16.78967;
        formatter.format("%1$e, %<f, %<g, %<a\n", d1);
        System.out.println(formatter);
    }

    private static void appending() {
        Formatter formatter = new Formatter();
        boolean b1 = true;
        Boolean b2 = null;
        formatter.format("1. - %b, %b\n", b1, b2);
        System.out.print(formatter);
        System.out.println("-------------------------------");
        Timer t = new Timer();
        formatter.format("2. - %h", t);
        System.out.println(formatter);
        System.out.println(Integer.toHexString(t.hashCode()));
    }
}
