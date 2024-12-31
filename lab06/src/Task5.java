import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task5 {
    public static void insertTextInFile(RandomAccessFile file, String text, long position) throws IOException {
        long currentPosition = file.getFilePointer();
        if (position < file.length()) {
            file.seek(position);
            byte[] bytes = new byte[(int) (file.length()-position)];
            file.readFully(bytes);

            file.seek(position);
            file.writeBytes(text);

            file.write(bytes);

        }else{
            file.seek(position);
            file.writeBytes(text);
        }
        file.seek(currentPosition);
    }
    public static void main(String[] args) {
        String filePath = "checkReport.txt";

        try {
            // Відкриваємо файл для читання і запису
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");

            String textAtBeginning = "Insert in the beginning\n";
            insertTextInFile(file, textAtBeginning, 0);

            String textAtMiddle = "Insert in center\n";
            insertTextInFile(file, textAtMiddle, 50);

            String textAtEnd = "Insert in the end\n";
            insertTextInFile(file, textAtEnd, file.length());

            file.close();
            System.out.println("Текст успішно додано в різні місця файлу.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
