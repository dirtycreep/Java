package task1;

import java.util.Scanner;

public class Main {
    /** Stored an instance of HomeControlUnit */
    private static task1.HomeControlUnit hcu;

    /** Stored menu list as String array */
    private static String[] operationNames = {
            "1. Add Room",
            "2. Add an unit",
            "3. Delete unit",
            "4. Power ON unit",
            "5. Power OFF unit",
            "6. Show all units",
            "7. Show sorted powered units (power decrement)",
            "8. Show total actual power",
            "9. Find unit",
            "0. Exit"};

    /** This is the programm entry point
     *  Firsly, this method creats an instance of HomeControlUnit
     *  and launch console menu
     */
    public static void main(String[] args) {
        hcu = new task1.HomeControlUnit();
        menu();
    }

    /** This private method prints console menu
     */
    private static void printMenu() {
        for (String name : operationNames)
            System.out.println(name);
    }

    /**This private method launchs the nessesared method, based on user's choise
    */
    private static void menu() {
        boolean runWhile = true;
        while (runWhile) {
            printMenu();
            int k = inputInt("operation number");
            switch (k) {
                case 1: // Add New Room
                        hcu.addNewRoom(inputString("Room Name"));
                        break;
                case 2: // Add New Unit
                    hcu.addNewUnit(inputString("Unit Name"), inputInt("Unit power"), inputString("Existing Room Name"));
                    break;
                case 3: // Delete Unit
                    hcu.deleteUnit(inputInt("Existing Unit ID"));
                    break;
                case 4: // Power ON Unit
                    hcu.powerOnUnit(inputInt("Existing Unit ID"));
                    break;
                case 5: // Power OFF Unit
                    hcu.powerOffUnit(inputInt("Existing Unit ID"));
                    break;
                case 6: // Show ALL UNITS
                    hcu.printAllUnits();
                    break;
                case 7: // Show Sorted UNITS
                    hcu.printAllSortedUnits();
                    break;
                case 8: // Show total actual power
                    hcu.showActualPower();
                    break;
                case 9: // Find Unit
                    hcu.findUnit(inputString("Please input unit Name or part of Name"));
                    break;
                case 0: // Exit from Application
                   runWhile = false;
            }
        }
    }

    /**
     * This private method asks for Integer from console
     * @param str - this String will be print before request parametr from console
     * @return - Int - inputed parametr by user in console
     */
    private static int inputInt(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Input " + str);
        return scan.nextInt();
    }

    /**
     * This private method asks for String from console
     * @param str - this String will be print before request parametr from console
     * @return - String - inputed parametr by user in console
     */
    private static String inputString(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Input " + str);
        return scan.nextLine();
    }


}
