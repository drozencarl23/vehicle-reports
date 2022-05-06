package com.vehicle.reports.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    private final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static String formatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static Date getCurrentDate() {
        return new Date();
    }
}
