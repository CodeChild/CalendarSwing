package com.zhangyulong;

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
    }
}
