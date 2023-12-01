import java.util.Scanner;
import java.io.File;

public class ArrayListDB {

    private static void handleAlbum(String command, String album, AlbumArrayList database) {
        try {
            Album beingHandled = new Album(album);
            if (command.equalsIgnoreCase("add")) {
                database.add(beingHandled);
            } else if (command.equalsIgnoreCase("remove")) {
                database.remove(beingHandled);
            } else {
                System.out.println("Transact history command not recognized");
            }
        } catch (Exception e) {
            System.out.println("Album not in correct format. Please re-enter command and try again. Do not forget to put spaces around the dash.");
        }
    }
    public static void main(String[] args) {
        //Processing file
        String fileName = "";
        for (String s: args) {
            fileName = s;
        }
        
        File transactHistory = new File(fileName);
        
        AlbumArrayList storeDatabase = new AlbumArrayList();
        int transactCount = 0;

        try {
            Scanner dataProcessScanner = new Scanner(transactHistory);
            while (dataProcessScanner.hasNextLine()) {
                String eachLine = dataProcessScanner.nextLine();
                try {
                    String[] splittedLine = eachLine.split(":");
                    handleAlbum(splittedLine[0], splittedLine[1], storeDatabase);
                    transactCount += 1;
                } catch(Exception e) {
                    System.out.println("Invalid command format for transaction history");
                }
            }
            dataProcessScanner.close();
        } catch(Exception e) {
            System.out.println("File Not Found");
            System.exit(0);
        }

        // Implementing user interface
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println(transactCount + " trasanction(s) processed");
        System.out.println("Please provide command: ADD, REMOVE, LIST, QUIT");
        while (true) {
            String command = userInputScanner.nextLine();
            if (command.equalsIgnoreCase("add")) {
                System.out.println("Artist - Album: ");
                String inputAlbum = userInputScanner.nextLine();
                handleAlbum(command, inputAlbum, storeDatabase);
            } else if (command.equalsIgnoreCase("list")) {
                storeDatabase.getList();
            } else if (command.equalsIgnoreCase("remove")) {
                System.out.println("Enter number: ");
                try {
                    int targetIndex = Integer.parseInt(userInputScanner.nextLine());
                    storeDatabase.remove(targetIndex - 1);
                } catch (Exception e) {
                    System.out.println("Please input number :')");
                }
                
            } else if (command.equalsIgnoreCase("quit")) {
                System.out.println("Have a nice day!");
                break;
            } else {
                System.out.println("Command not recognized. Please provide command: ADD, REMOVE, LIST, QUIT");
            }
        }

        userInputScanner.close();
    }
}