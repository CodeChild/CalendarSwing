package com.zhangyulong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarModel {
    private final int ROWS = 5;
    private final int COLUMNS = 7;
    private final int DAY_MONTH_LENGTH = 2;
    private final int YEAR_LENGTH = 4;
    private Date[][] calendarDate = new Date[ROWS][COLUMNS];
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    CalendarModel() {
    }

    public void setCalendarDate(int year, int month) {
        int startOffset = 0;
        String yearMonth = String.format("%04d", year) +
                String.format("%02d", month);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        try {
            calendar.setTime(simpleDateFormat.parse(
                    yearMonth +
                            String.format("%02d", 1)));
            startOffset = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int row = 0; row < calendarDate.length; row++) {
            for (int column = 0; column < calendarDate[0].length; column++) {
                int day = row * calendarDate[0].length + column + 1 - startOffset;
                if (day > 0 && day <= 31) {
                    try {
                        calendarDate[row][column] = simpleDateFormat.parse(yearMonth + String.format("%02d", day));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Date[][] getCalendarDate() {
        return calendarDate;
    }
}
