package quantumleap.dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy");

    public static Date parseYear(String yearStr) throws ParseException {
        return DATE_FORMAT.parse(yearStr);
    }
}
