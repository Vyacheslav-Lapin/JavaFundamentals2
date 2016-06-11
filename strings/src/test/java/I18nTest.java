import org.junit.Test;

import java.util.Locale;

public class I18nTest {
    @Test
    public void displayCountry() {
        Locale defaultLocale = Locale.getDefault();
        Locale rusLocale = new Locale("ru","RU");
        Locale usLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");

        System.out.println(defaultLocale.getDisplayCountry());
        System.out.println(defaultLocale.getDisplayCountry(Locale.FRENCH));
        System.out.println(frLocale.getDisplayCountry(defaultLocale));
    }
}
