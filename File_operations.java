import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class File_operations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("n")) {
            System.out.println("\nMenu based app - File Operations in Java\n");
            System.out.println("1. Create a new folder");
            System.out.println("2. Create a new text file");
            System.out.println("3. Write into a text file");
            System.out.println("4. Append data to a text file");
            System.out.println("5. Rename a file");
            System.out.println("6. Delete a file");
            System.out.println("\nEnter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("\nCreate a new folder\n");
                    System.out.println("Please enter the Folder-name to be Created: ");
                    String folderName = scanner.nextLine();
                    System.out.println("Please enter the Path where you wish to save a new folder: ");
                    String folderPath = scanner.nextLine();

                    try {
                        createFolder(folderPath, folderName);
                        System.out.println("\nFolder is created Successfully!");
                    } catch (IOException e) {
                        System.out.println("\nError occurred while creating a folder: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\nCreate a new text file\n");
                    System.out.println("Please enter the path where you want to create the file: ");
                    String filePath = scanner.nextLine();
                    System.out.println("Please enter the name of the file you want to create: ");
                    String fileName = scanner.nextLine();

                    try {
                        createFile(filePath, fileName);
                        System.out.println("\nFile is created Successfully!");
                    } catch (IOException e) {
                        System.out.println("\nError occurred while creating a file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\nWrite into a text file\n");
                    System.out.println("Please enter the path of the file: ");
                    filePath = scanner.nextLine();
                    System.out.println("Please enter the data you want to write into the file: ");
                    String data = scanner.nextLine();

                    try {
                        writeToFile(filePath, data);
                        System.out.println("\nData is written to file Successfully!");
                    } catch (IOException e) {
                        System.out.println("\nError occurred while writing to file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nAppend data to a text file\n");
                    System.out.println("Please enter the path of the file: ");
                    filePath = scanner.nextLine();
                    System.out.println("Please enter the data you want to append to the file: ");
                    data = scanner.nextLine();

                    try {
                        appendToFile(filePath, data);
                        System.out.println("\nData is appended to file Successfully!");
                    } catch (IOException e) {
                        System.out.println("\nError occurred while appending to file: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\nRename a file\n");
                    System.out.println("Please enter the path of the file: ");
                    filePath = scanner.nextLine();
                    System.out.println("Please enter the current name of the file: ");
                    String oldFileName = scanner.nextLine();
                    System.out.println("Please enter new File-Name: ");
                    String newFileName = scanner.nextLine();
                    try {
                        renameFile(filePath, oldFileName, newFileName);
                        System.out.println("\nFile is renamed Successfully!");
                    } catch (IOException e) {
                        System.out.println("\nError occurred while renaming the file: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\nDelete a file\n");
                    System.out.println("Please enter the path of the file: ");
                    filePath = scanner.nextLine();

                    try {
                        deleteFile(filePath);
                        System.out.println("\nFile is deleted Successfully!");
                    } catch (IOException e) {
                        System.out.println("\nError occurred while deleting a file: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("\nInvalid Option. Please enter a valid option.");
                    break;
            }

            System.out.println("\nPress 'Y' to go back to the Main File-Operations Menu: ");
            choice = scanner.nextLine();
        }
        scanner.close();
    }

    public static void createFolder(String folderPath, String folderName) throws IOException {
        File file = new File(folderPath + File.separator + folderName);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("\nFolder is created!");
            } else {
                throw new IOException("Failed to create a folder");
            }
        }
    }

    public static void createFile(String filePath, String fileName) throws IOException {
        File file = new File(filePath + File.separator + fileName);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("\nFile is created!");
            } else {
                throw new IOException("Failed to create a file");
            }
        }
    }

    public static void writeToFile(String filePath, String data) throws IOException {
        FileWriter writer = new FileWriter(filePath, false);
        writer.write(data);
        writer.close();
    }

    public static void appendToFile(String filePath, String data) throws IOException {
        FileWriter writer = new FileWriter(filePath, true);
        writer.write(data);
        writer.close();
    }

    public static void renameFile(String filePath, String oldFileName, String newFileName) throws IOException {
        File oldFile = new File(filePath + File.separator + oldFileName);
        if (oldFile.exists()) {
            File newFile = new File(filePath + File.separator + newFileName);
            if (newFile.exists()) {
                throw new IOException("File already exists with the new name");
            } else {
                if (oldFile.renameTo(newFile)) {
                    System.out.println("\nFile is renamed successfully!");
                } else {
                    throw new IOException("Failed to rename the file");
                }
            }
        } else {
            throw new IOException("File not found with the old name");
        }
    }

    public static void deleteFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("\nFile is deleted!");
            } else {
                throw new IOException("Failed to delete the file");
            }
        } else {
            throw new IOException("File not found");
        }
    }
}