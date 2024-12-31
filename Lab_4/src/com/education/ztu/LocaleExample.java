package com.education.ztu;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleExample {
    public static void main(String[] args) {
        Locale usLocale = new Locale("en", "US");
        Locale esLocale = new Locale("es", "ES");
        Locale uaLocale = new Locale("ua", "UA");

        receipt(usLocale);
        System.out.println();
        receipt(esLocale);
        System.out.println();
        receipt(uaLocale);
    }

    private static void receipt(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("data", locale);

        System.out.println(rb.getString("receipt.title"));
        System.out.println(rb.getString("receipt.date") + ": 28.03.2019 13:25:12");
        System.out.println("================================================");


        System.out.printf("%-3s %-10s %-20s %-10s\n",
                rb.getString("receipt.itemNumber"),
                rb.getString("receipt.product"),
                rb.getString("receipt.category"),
                rb.getString("receipt.price"));
        System.out.println("================================================");

        Object[][] items = {
                {1, rb.getString("product.jeans"), rb.getString("category.women"), 1500.78},
                {2, rb.getString("product.skirt"), rb.getString("category.women"), 1000.56},
                {3, rb.getString("product.tie"), rb.getString("category.men"), 500.78}
        };

        double total = 0.0;

        for (Object[] item : items) {
            int number = (int) item[0];
            String product = (String) item[1];
            String category = (String) item[2];
            double price = (double) item[3];
            total += price;


            System.out.printf("%-3d %-10s %-20s %-10.2f ₴\n", number, product, category, price);
        }

        System.out.println("================================================");
        System.out.printf("%-30s %15.2f ₴\n", rb.getString("receipt.total"), total);
    }
}
