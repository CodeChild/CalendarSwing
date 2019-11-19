package com.zhangyulong;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class CalendarController implements ActionListener {
    private JLabel[][] dayText;
    private CalendarModel calendarModel;
    private JLabel dateText;

    CalendarController(JLabel[][] dayText, JLabel dateText, CalendarModel calendarModel) {
        super();
        this.dayText = dayText;
        this.calendarModel = calendarModel;
        this.dayText = dayText;
    }

    public void refreshCalendar(Date date) {
        calendarModel.setCalendarDate(date);
        updateDayText();
    }

    public void updateDayText() {
        Date[][] calendarDate = calendarModel.getCalendarDate();
        if (dayText.length != calendarDate.length ||
                dayText[0].length != calendarDate[0].length) {
            return;
        }
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
