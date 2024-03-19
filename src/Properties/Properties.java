package Properties;
import java.util.*;
import java.io.*;
public class Properties{
//    public static void addExpense() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the expense amount: ");
//        double amount = scanner.nextDouble();
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("daily_expenses.txt", true))) {
//            writer.write(String.valueOf(amount));
//            writer.newLine();
//            System.out.println("Expense added successfully.");
//        } catch (IOException e) {
//            System.out.println("An error occurred while writing to the file.");
//            e.printStackTrace();
//        }
//    }
public static void addExpense(String username) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the expense amount: ");
    double amount = scanner.nextDouble();
    String filename = username + "_expenses.txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        writer.write(String.valueOf(amount));
        writer.newLine();
        System.out.println("Expense added successfully.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
        e.printStackTrace();
    }
}
//    public static void updateExpense() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the expense amount to update: ");
//        double oldAmount = scanner.nextDouble();
//        System.out.print("Enter the new expense amount: ");
//        double newAmount = scanner.nextDouble();
//
//        try {
//            File file = new File("daily_expenses.txt");
//            File tempFile = new File("temp.txt");
//
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//            String line;
//            boolean found = false;
//
//            while ((line = reader.readLine()) != null) {
//                double amount = Double.parseDouble(line);
//                if (amount == oldAmount) {
//                    writer.write(String.valueOf(newAmount));
//                    writer.newLine();
//                    found = true;
//                } else {
//                    writer.write(line);
//                    writer.newLine();
//                }
//            }
//
//            reader.close();
//            writer.close();
//
//            if (found) {
//                if (file.delete()) {
//                    if (tempFile.renameTo(file)) {
//                        System.out.println("Expense updated successfully.");
//                    } else {
//                        System.out.println("An error occurred while updating the expense.");
//                    }
//                } else {
//                    System.out.println("An error occurred while updating the expense.");
//                }
//            } else {
//                System.out.println("Expense not found.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while updating the expense.");
//            e.printStackTrace();
//        }
//    }
public static void updateExpense(String username) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the expense amount to update: ");
    double oldAmount = scanner.nextDouble();
    System.out.print("Enter the new expense amount: ");
    double newAmount = scanner.nextDouble();

    try {
        File file = new File(username + "_expenses.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            double amount = Double.parseDouble(line);
            if (amount == oldAmount) {
                writer.write(String.valueOf(newAmount));
                writer.newLine();
                found = true;
            } else {
                writer.write(line);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();

        if (found) {
            if (file.delete()) {
                if (tempFile.renameTo(file)) {
                    System.out.println("Expense updated successfully.");
                } else {
                    System.out.println("An error occurred while updating the expense.");
                }
            } else {
                System.out.println("An error occurred while updating the expense.");
            }
        } else {
            System.out.println("Expense not found.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred while updating the expense.");
        e.printStackTrace();
    }
}



//    public static void deleteExpense() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the expense amount to delete: ");
//        double amount = scanner.nextDouble();
//
//        try {
//            File file = new File("daily_expenses.txt");
//            File tempFile = new File("temp.txt");
//
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//            String line;
//            boolean found = false;
//
//            while ((line = reader.readLine()) != null) {
//                double expense = Double.parseDouble(line);
//                if (expense == amount) {
//                    found = true;
//                } else {
//                    writer.write(line);
//                    writer.newLine();
//                }
//            }
//
//            reader.close();
//            writer.close();
//
//            if (found) {
//                if (file.delete()) {
//                    if (tempFile.renameTo(file)) {
//                        System.out.println("Expense deleted successfully.");
//                    } else {
//                        System.out.println("An error occurred while deleting the expense.");
//                    }
//                } else {
//                    System.out.println("An error occurred while deleting the expense.");
//                }
//            } else {
//                System.out.println("Expense not found.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while deleting the expense.");
//            e.printStackTrace();
//        }
//    }
public static void deleteExpense(String username) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the expense amount to delete: ");
    double amount = scanner.nextDouble();

    try {
        File file = new File(username + "_expenses.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            double expense = Double.parseDouble(line);
            if (expense == amount) {
                found = true;
            } else {
                writer.write(line);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();

        if (found) {
            if (file.delete()) {
                if (tempFile.renameTo(file)) {
                    System.out.println("Expense deleted successfully.");
                } else {
                    System.out.println("An error occurred while deleting the expense.");
                }
            } else {
                System.out.println("An error occurred while deleting the expense.");
            }
        } else {
            System.out.println("Expense not found.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred while deleting the expense.");
        e.printStackTrace();
    }
}


//    public static void displayExpenses() {
//        try {
//            File file = new File("daily_expenses.txt");
//            if (file.exists()) {
//                BufferedReader reader = new BufferedReader(new FileReader(file));
//
//                String line;
//                int count = 1;
//                System.out.println("Expenses:");
//
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(count + ". " + line);
//                    count++;
//                }
//
//                reader.close();
//            } else {
//                System.out.println("No expenses found.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while reading the expenses.");
//            e.printStackTrace();
//        }
//    }
public static void displayExpenses(String username) {
    try {
        File file = new File(username + "_expenses.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            int count = 1;
            System.out.println("Expenses:");

            while ((line = reader.readLine()) != null) {
                System.out.println(count + ". " + line);
                count++;
            }

            reader.close();
        } else {
            System.out.println("No expenses found.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred while reading the expenses.");
        e.printStackTrace();
    }
}


//    public static void calculateTotalExpense() {
//        double totalExpense = 0.0;
//
//        try (Scanner scanner = new Scanner(new File("daily_expenses.txt"))) {
//            while (scanner.hasNextDouble()) {
//                totalExpense += scanner.nextDouble();
//            }
//            System.out.println("Total Expense: " + totalExpense);
//        }
//        catch (IOException e) {
//            System.out.println("An error occurred while calculating the total expense.");
//            e.printStackTrace();
//        }
//    }
public static void calculateTotalExpense(String username) {
    String fileName = username + "_expenses.txt";
    double totalExpense = 0.0;

    try (Scanner scanner = new Scanner(new File(fileName))) {
        while (scanner.hasNextDouble()) {
            totalExpense += scanner.nextDouble();
        }
        System.out.println("Total Expense for " + username + ": " + totalExpense);
    } catch (IOException e) {
        System.out.println("An error occurred while calculating the total expense.");
        e.printStackTrace();
    }
}



}

