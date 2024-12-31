import java.io.File;
import java.io.IOException;

public class Task6 {
    public static void main(String[] args) {
        try {
            File directory = new File("inner_directory");
            if (directory.mkdir()) {
                System.out.println("Directory created");
            }

            System.out.println("Absolute path of directiry: " + directory.getAbsolutePath());

            //!!!
            File parentFile = directory.getParentFile();
            if (parentFile != null) {
                System.out.println("Parent directory: " + parentFile.getName());
            }

            File file1 = new File(directory, "file1.txt");
            File file2 = new File(directory, "file2.txt");
            if (file1.createNewFile() && file2.createNewFile()) {
                System.out.println("Files 'file1.txt' and 'file2.txt' created successfully in 'inner_directory'.");
            }

            if (file1.delete()) {
                System.out.println("Files 'file1.txt' deleted successfully.");
            }

            File fileRename = new File("renamed_inner_directory");
            directory.renameTo(fileRename);

            File directoryForFiles = new File("directory_for_files");
            if (directoryForFiles.exists() && directoryForFiles.isDirectory()) {
                File[] files = directoryForFiles.listFiles();
                if (files != null) {
                    for (File file : files) {
                        String type = file.isDirectory() ? "Directory" : "File";
                        long size = file.length();
                        System.out.println(file.getName() + " - Type: " + type + ", Size: " + size + " bytes");
                    }
                }
            } else {
                System.out.println("Directory 'directory_for_files' does not exist.");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
