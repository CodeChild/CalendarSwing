package com.zhangyulong;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        CalendarModel calendarModel = new CalendarModel();
        calendarModel.setCalendarDate(2010, 7);
        for (Date[] i : calendarModel.getCalendarDate()) {
            for (Date j : i) {
                System.out.println(j);
            }
        }
    }
}
