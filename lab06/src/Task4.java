import java.io.*;

public class Task4 {
    public static void copyTextFile(String source, String destination) {
        try (FileReader fr = new FileReader(source);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(destination);
             BufferedWriter bw = new BufferedWriter(fw);){
             String line;
             while((line = br.readLine()) != null){
                 bw.write(line);
                 bw.newLine();
             }
             System.out.println("Successfully copied text to " + destination);
        }catch (Exception e){
            System.err.println("Text file error: " + e.getMessage());
        }
    }

    public static void copyBinaryFile(String source, String destination){
        try(FileInputStream fi = new FileInputStream(source);
            BufferedInputStream br = new BufferedInputStream(fi, 200);
            FileOutputStream fo = new FileOutputStream(destination);
            BufferedOutputStream bw = new BufferedOutputStream(fo, 200);
        ){
            byte[] buffer = new byte[1024];
            int length;
            while ((length = br.read(buffer)) != -1) {
                bw.write(buffer, 0, length);
            }
            System.out.println("Successfully copied binary file to " + destination);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        String textSourcePath = "checkReport.txt";
        String textDestinationPath = "copiedCheckReport.txt";
        copyTextFile(textSourcePath, textDestinationPath);

        String binarySourcePath = "imageToCopy.png";
        String binaryDestinationPath = "copiedImageToCopy.png";
        copyBinaryFile(binarySourcePath, binaryDestinationPath);
    }
}
