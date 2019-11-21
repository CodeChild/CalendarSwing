package com.zhangyulong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CalendarView {
    public JLabel[][] dayText;
    public JLabel[] dayOfWeekText;
    public JLabel dateText;
    public CalendarController controller;
    public JFrame frame = new JFrame("Calendar");
    public JPanel calendarPanel = new JPanel();
    public JPanel yearMonthPanel = new JPanel();
    public JButton previousYearButton = new JButton("上一年");
    public JButton nextYearButton = new JButton("下一年");
    public JButton previousMonthButton = new JButton("上一月");
    public JButton nextMonthButton = new JButton("下一月");
    public JLabel currentYearMonthText = new JLabel("", JLabel.CENTER);
    public JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

    CalendarView() {
        dayText = new JLabel[CalendarModel.ROWS][CalendarModel.COLUMNS];
        dayOfWeekText = new JLabel[CalendarModel.COLUMNS];
        dateText = new JLabel();
        initDayOfWeekText();
        initDayText();
        initMonthYearChangeButton();
        controller = new CalendarController(this);
        initPanel();
        initFrame();
        controller.refreshCalendar(new Date());
    }

    private void initDayOfWeekText() {
        for (int i = 0; i < dayOfWeekText.length; i++) {
            dayOfWeekText[i] = new JLabel("", JLabel.CENTER);
        }
    }
    private void initDayText() {
        for (int row = 0; row < dayText.length; row++) {
            for (int column = 0; column < dayText[0].length; column++) {
                dayText[row][column] = new JLabel("", JLabel.CENTER);
            }
        }
    }

    public void clearDayText() {
        for (JLabel[] i : dayText) {
            for (JLabel j : i) {
                j.setText("");
            }
        }
    }

    private void initMonthYearChangeButton() {
        previousMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changePreviousMonth();
            }
        });
        previousYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changePreviousYear();
            }
        });
        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeNextMonth();
            }
        });
        nextYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeNextYear();
            }
        });
    }
    private void initPanel() {
        yearMonthPanel.setLayout(new GridLayout(1, 5, 5, 5));
        yearMonthPanel.add(previousYearButton);
        yearMonthPanel.add(previousMonthButton);
        yearMonthPanel.add(currentYearMonthText);
        yearMonthPanel.add(nextMonthButton);
        yearMonthPanel.add(nextYearButton);
        calendarPanel.setLayout(new GridLayout(CalendarModel.ROWS + 1, CalendarModel.COLUMNS, 5, 5));
        for (JLabel i : dayOfWeekText) {
            calendarPanel.add(i);
        }
        for (JLabel[] i : dayText) {
            for (JLabel j : i) {
                calendarPanel.add(j);
            }
        }
    }

    private void initFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jSplitPane.setTopComponent(yearMonthPanel);
        jSplitPane.setBottomComponent(calendarPanel);
        frame.add(jSplitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBounds(300, 200, 600, 400);
        frame.setVisible(true);
    }
}
