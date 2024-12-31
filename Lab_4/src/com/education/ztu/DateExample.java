package com.education.ztu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

public class DateExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2024, 10, 28, 2, 41, 13);
        System.out.println("Дата та час початку лабораторної: " + now);

        String dayOfWeek = now.getDayOfWeek().toString();
        int dayOfYear = now.getDayOfYear();
        String month = now.getMonth().toString();
        int year = now.getYear();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        System.out.println("День тижня: " + dayOfWeek);
        System.out.println("День року: " + dayOfYear);
        System.out.println("Місяць: " + month);
        System.out.println("Рік: " + year);
        System.out.println("Години: " + hour);
        System.out.println("Хвилини: " + minute);
        System.out.println("Секунди: " + second);

        boolean isLeapYear = Year.isLeap(year);
        System.out.println("Рік високосний: " + isLeapYear);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Поточний час: " + currentDateTime);

        if (currentDateTime.isAfter(now)) {
            System.out.println("Поточний час після початку лабораторної.");
        } else if (currentDateTime.isBefore(now)) {
            System.out.println("Поточний час перед початком лабораторної.");
        } else {
            System.out.println("Поточний час збігається з початком лабораторної.");
        }

        LocalDateTime modifiedDateTime = now.plusDays(2).minusHours(3).withMinute(30);
        System.out.println("Змінена дата та час: " + modifiedDateTime);
    }
}
