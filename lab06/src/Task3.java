import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String date = "28.03.2019";
        String time = "13:25:12";
        StringBuilder builder = new StringBuilder();

        builder.append("Дата та час покупки: ").append(date).append(" ").append(time).append("\n");
        builder.append("===========================================\n");
        builder.append(String.format("%-3s %-10s %-15s %-10s\n", "№", "Товар", "Категорія", "Ціна"));
        builder.append("===========================================\n");

        Object[][] items = {
                {1, "Джинси", "Жіночий одяг", 1500.78},
                {2, "Спідниця", "Жіночий одяг", 1000.56},
                {3, "Краватка", "Чоловічий одяг", 500.78},
                {4, "Сорочка", "Чоловічий одяг", 800.45},
                {5, "Сукня", "Жіночий одяг", 2000.00},
                {6, "Куртка", "Чоловічий одяг", 3200.99},
                {7, "Футболка", "Жіночий одяг", 250.50},
                {8, "Брюки", "Чоловічий одяг", 1400.30},
                {9, "Шарф", "Жіночий одяг", 300.75},
                {10, "Капелюх", "Чоловічий одяг", 600.60}
        };

        double total = 0.0;

        for (Object[] item : items) {
            int number = (int) item[0];
            String product = (String) item[1];
            String category = (String) item[2];
            double price = (double) item[3];
            total += price;

            builder.append(String.format("%-3d %-10s %-15s %-10.2f ₴\n", number, product, category, price));
        }

        builder.append("===========================================\n");
        builder.append(String.format("%-30s %10.2f ₴\n", "Разом:", total));

        try{
            FileWriter writer = new FileWriter("checkReport.txt");
            writer.write(builder.toString());
            writer.close();
            System.out.println("Success: report was written successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            FileReader fileReader = new FileReader("checkReport.txt");
            Scanner scanner = new Scanner(fileReader);
            //int charactersRead = 0;
            System.out.println("Check report from file: \n");
            while (scanner.hasNextLine()) {
                System.out.print(scanner.nextLine()+"\n");
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
