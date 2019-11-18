package com.zhangyulong;

import java.text.NumberFormat;
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
    private NumberFormat yearFormat = NumberFormat.getInstance();
    private NumberFormat monthDayFormat = NumberFormat.getInstance();

    CalendarModel() {
        yearFormat.setMaximumIntegerDigits(YEAR_LENGTH);
        monthDayFormat.setMaximumIntegerDigits(DAY_MONTH_LENGTH);
    }

    public void setCalendarDate(int year, int month) {
        int startOffset = 0;
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(
                    yearFormat.format(year) +
                            monthDayFormat.format(month) +
                            monthDayFormat.format(1)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int row = 0; row < calendarDate.length; row++) {
            for (int column = 0; column < calendarDate[0].length; column++) {
                int day = row - startOffset + 1;
            }
        }
    }
}
