package time.capsule.api.core.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static final Locale LOCALE_BRAZIL = new Locale("pt", "BR");

    public static Date getDate() {
        return getCalendar().getTime();
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance(LOCALE_BRAZIL);
    }

}
