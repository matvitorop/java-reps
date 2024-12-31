package com.education.ztu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String employees = """
            Іванов Іван Іванович, 35 років, Дата народження: 20.05.1988, Посада: Менеджер, Досвід: 5 років, Адреса: Київ, Емейл: ivanov@example.com, Телефон: +380501234567
            Петров Петро Петрович, 29 років, Дата народження: 15.03.1994, Посада: Аналітик, Досвід: 3 роки, Адреса: Харків, Емейл: petrov@example.ua, Телефон: +380671234567
            Сидорова Світлана Олександрівна, 42 роки, Дата народження: 30.08.1981, Посада: Бухгалтер, Досвід: 10 років, Адреса: Львів, Емейл: sidorova@example.org, Телефон: +380631234567
            Коваленко Марія Петрівна, 25 років, Дата народження: 01.01.1998, Посада: Рекрутер, Досвід: 2 роки, Адреса: Одеса, Емейл: kovalenko@example.net, Телефон: +380661234567
            Ткаченко Олег Михайлович, 37 років, Дата народження: 05.12.1986, Посада: Дизайнер, Досвід: 8 років, Адреса: Дніпро, Емейл: tkachenko@example.com, Телефон: +380931234567
        """;

        // TASK 1.1
        Pattern numbers = Pattern.compile("\\+\\d{12}");
        Matcher matcher = numbers.matcher(employees);
        System.out.println("Phone numbers: ");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        Pattern emails = Pattern.compile("[\\w.-]+@[\\w.-]+\\.[\\w.-]+");
        Matcher emailMatcher = emails.matcher(employees);
        System.out.println("\nEmails: ");
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        //TASK 1.2
        System.out.println("\nUpdated date format: ");
        String updatedDates = employees.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
        System.out.println(updatedDates);

        // TASK 1.3
        System.out.println("Updated positions: :");
        String updatedPositions = updatedDates
                .replaceFirst("Посада: Менеджер", "Посада: Керівник відділу")
                .replaceFirst("Посада: Аналітик", "Посада: Старший аналітик");
        System.out.println(updatedPositions);
    }
}