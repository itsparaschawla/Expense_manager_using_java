import java.util.*;
import java.io.*;
import static Properties.Properties.*;
public class Main{
    public static void main(String[] args) {
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome! to Monthly Budget Manager                    |");
        System.out.println("------------------------------------------------------|");
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;
        // check if user is already registered
        System.out.print("Do you have an account? (y/n): ");
        String existingUser = input.next();
        if (existingUser.equalsIgnoreCase("y")) {
            // login with existing credentials
            System.out.print("Enter your username: ");
            String username = input.next();

            System.out.print("Enter your password: ");
            String password = input.next();

            try (Scanner scanner = new Scanner(new File("login_details.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] loginDetails = line.split(",");
                    String storedUsername = loginDetails[0];
                    String storedPassword = loginDetails[1];

                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        loggedIn = true;
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                e.printStackTrace();
            }

            if (!loggedIn) {
                System.out.println("Invalid login credentials! Please try again later.");
                return;
            }

            System.out.println("Successfully logged in!");
        } else {
            // register a new user
            System.out.print("Enter your desired username: ");
            String username = input.next();

            System.out.print("Enter your desired password: ");
            String password = input.next();

            try (FileWriter fileWriter = new FileWriter("login_details.txt", true)) {
                fileWriter.write(username + "," + password + "\n");
            } catch (IOException e) {
                System.out.println("Error writing to file!");
                e.printStackTrace();
            }

            System.out.println("Successfully registered! Please login to continue.");
        }

        // menu for budget manager
        boolean continueProgram;
        do {
            System.out.println("------------------------------------------------------|");
            System.out.println("Select the desired option from the menu below:        |");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. ADD                                                |");
            System.out.println("2. UPDATE                                             |");
            System.out.println("3. DELETE                                             |");
            System.out.println("4. DISPLAY                                            |");
            System.out.println("5. CALCULATE TOTAL EXPENSE                            |");
            System.out.println("------------------------------------------------------|");
            System.out.print("Choose the number corresponding to the desired option-");

            int choice = sc.nextInt();
            System.out.println("enter username");
            String username= input.next();
            switch (choice) {
                case 1:
                    addExpense(username);
                    break;
                case 2:
                    updateExpense(username);
                    break;
                case 3:
                    deleteExpense(username);
                    break;
                case 4:
                    displayExpenses(username);
                    break;
                case 5:
                    calculateTotalExpense(username);
                    break;
                default:
                    System.out.println("Invalid input! Try again :(");
            }
            System.out.println("------------------------------------------------------|");
            System.out.print("Do you want to continue? (y/n): ");
            Scanner opt=new Scanner(System.in);
            String continueChoice = opt.next();
            continueProgram = continueChoice.equalsIgnoreCase("y");
        } while (continueProgram);
        System.out.println("Thank you for using Monthly Budget Manager! Goodbye!  |");
        System.out.println("------------------------------------------------------|");
    }
}
