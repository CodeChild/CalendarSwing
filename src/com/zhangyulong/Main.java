package com.zhangyulong;

import javax.swing.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        CalendarModel calendarModel = new CalendarModel();
        calendarModel.setCalendarDate(new Date());
        for (Date[] i : calendarModel.getCalendarDate()) {
            for (Date j : i) {
                System.out.println(j);
            }
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void createAndShowGUI() throws Exception {
        new CalendarView();
    }
}
