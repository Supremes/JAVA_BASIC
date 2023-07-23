package org.dododo.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {
    public static String getCurrentTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
