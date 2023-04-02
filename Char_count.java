
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Char_count {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        int count = 0;

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                count += line.length();
            }

            fileScanner.close();

            System.out.println("Total number of characters in file are: " + count);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
