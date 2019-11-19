package com.zhangyulong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarModel {
    public static final int ROWS = 5;
    public static final int COLUMNS = 7;
    private final String DAY_MONTH_LENGTH = "%02d";
    private final String YEAR_LENGTH = "%04d";
    private Date[][] calendarDate = new Date[ROWS][COLUMNS];
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    CalendarModel() {
    }

    public void setCalendarDate(int year, int month) {
        int startOffset = 0;
        String yearMonth = String.format(YEAR_LENGTH, year) +
                String.format(DAY_MONTH_LENGTH, month);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        try {
            calendar.setTime(simpleDateFormat.parse(
                    yearMonth +
                            String.format(DAY_MONTH_LENGTH, 1)));
            startOffset = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int row = 0; row < calendarDate.length; row++) {
            for (int column = 0; column < calendarDate[0].length; column++) {
                int day = row * calendarDate[row].length + column + 1 - startOffset;
                if (day > 0 && day <= 31) {
                    try {
                        calendarDate[row][column] = simpleDateFormat.parse(yearMonth + String.format(DAY_MONTH_LENGTH, day));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setCalendarDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        setCalendarDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
    }

    public Date[][] getCalendarDate() {
        return calendarDate;
    }
}
