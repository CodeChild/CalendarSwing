package com.zhangyulong;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarController {
    private JLabel[][] dayText;
    private CalendarModel calendarModel;
    private JLabel dateText;
    private CalendarView view;

    CalendarController(CalendarView view) {
        super();
        this.view = view;
        this.dayText = view.dayText;
        this.calendarModel = new CalendarModel();
        this.dayText = view.dayText;
    }

    public void refreshCalendar(Date date) {
        calendarModel.setCalendarDate(date);
        updateYearMonthText();
        updateDayText();
        updateDayOfWeekText();
    }

    public void updateDayOfWeekText() {
        String[] dayOfWeek = calendarModel.getDayOfWeek();
        if (dayOfWeek.length != view.dayOfWeekText.length) {
            return;
        }
        for (int i = 0; i < dayOfWeek.length; i++) {
            view.dayOfWeekText[i].setText(dayOfWeek[i]);
        }
    }

    public void updateYearMonthText() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年 MM月");
        view.currentYearMonthText.setText(simpleDateFormat.format(calendarModel.getCurrentDate()));
    }

    public void updateDayText() {
        Date[][] calendarDate = calendarModel.getCalendarDate();
        if (dayText.length != calendarDate.length ||
                dayText[0].length != calendarDate[0].length) {
            return;
        }
        view.calendarPanel.setVisible(false);
        view.clearDayText();
        for (int row = 0; row < calendarDate.length; row++) {
            for (int column = 0; column < calendarDate[0].length; column++) {
                if (calendarDate[row][column] == null) {
                    continue;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(calendarDate[row][column]);
                dayText[row][column].setText(String.valueOf(calendar.get(Calendar.DATE)));
            }
        }
        view.calendarPanel.setVisible(true);
    }

    public void changeNextMonth() {
        Calendar calendar = getCurrentDateCalendar();
        calendar.add(Calendar.MONTH, 1);
        refreshCalendar(calendar.getTime());
    }

    public void changePreviousMonth() {
        Calendar calendar = getCurrentDateCalendar();
        calendar.add(Calendar.MONTH, -1);
        refreshCalendar(calendar.getTime());
    }

    public void changeNextYear() {
        Calendar calendar = getCurrentDateCalendar();
        calendar.add(Calendar.YEAR, 1);
        refreshCalendar(calendar.getTime());
    }

    public void changePreviousYear() {
        Calendar calendar = getCurrentDateCalendar();
        calendar.add(Calendar.YEAR, -1);
        refreshCalendar(calendar.getTime());
    }


    public Calendar getCurrentDateCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendarModel.getCurrentDate());
        return calendar;
    }
}
