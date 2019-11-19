package com.zhangyulong;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class CalendarView {
    public JLabel[][] dayText;
    public JLabel dateText;
    public CalendarController controller;
    public CalendarModel model;
    public JFrame frame = new JFrame("Calendar");
    public JPanel panel = new JPanel();

    CalendarView() {
        dayText = new JLabel[CalendarModel.ROWS][CalendarModel.COLUMNS];
        dateText = new JLabel();
        model = new CalendarModel();
        initDayText();
        controller = new CalendarController(dayText, dateText, model);
        initPanel();
        initFrame();
        controller.refreshCalendar(new Date());
    }

    private void initDayText() {
        for (int row = 0; row < dayText.length; row++) {
            for (int column = 0; column < dayText[0].length; column++) {
                dayText[row][column] = new JLabel("",JLabel.CENTER);
            }
        }
    }

    private void initPanel() {
        panel.setLayout(new GridLayout(CalendarModel.ROWS, CalendarModel.COLUMNS, 5, 5));
        for (JLabel[] i : dayText) {
            for (JLabel j : i) {
                panel.add(j);
            }
        }
    }

    private void initFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
    }
}
