import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TaskEdit {
    public ArrayList<Tasks> editTask(ArrayList<Tasks> tList, int listIndex){
        //print tasks so user can identify by number the task they want to delete
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.println("| # |         Title |                                Description |                     Due Date | Status |");
        Tasks printTask = new Tasks();
        printTask = tList.get(listIndex);
        System.out.printf("|%3d|%15s|%44s|%30s|   [%s]  |\n", listIndex+1, printTask.getTitle() , printTask.getDescription() , printTask.getDueDate(), printTask.getStatus());
        printTask = null;
        System.out.println("+--------------------------------------------------------------------------------------------------------+");

        //scan for choice
        Scanner elementChoice = new Scanner(System.in);
        System.out.println("What would you like to edit?: ");
        System.out.println("1. Title ");
        System.out.println("2. Description ");
        System.out.println("3. Due Date ");
        System.out.println("4. Exit program ");

        int menuChoice = 0;
        boolean validInput = false;
        while (!validInput) {
            if (elementChoice.hasNextInt()) {
                int checkInt = elementChoice.nextInt();
                if (checkInt < 1 | checkInt > 4) {
                    System.out.print("That choice is out of range. Please try again: ");
                } else {
                    menuChoice = checkInt;
                    validInput = true;
                }
            } else {
                System.out.print("Incorrect input type. Please try again: ");
                elementChoice.nextLine();
            }
        }

        //switch statement for which element to edit
        switch(menuChoice){
            case 1:
                //edit title
                Scanner titleInput = new Scanner(System.in);
                System.out.print("Please enter the new title for the task: ");
                Tasks editElementFromThis = tList.get(listIndex);
                editElementFromThis.setTitle(titleInput.nextLine());
                break;

            case 2:
                //edit description
                Scanner descInput = new Scanner(System.in);
                System.out.print("Please enter the new description for the task: ");
                Tasks editElementFromThis2 = tList.get(listIndex);
                editElementFromThis2.setDescription(descInput.nextLine());
                break;

            case 3:
                //edit due date: simply use set date again and reset the full date (could make more granular)
                Tasks dateTask = tList.get(listIndex);
                Scanner dateInput = new Scanner(System.in);
                //validate integers for day month and year (turn this into a separate function to reduce redundancy)
                System.out.print("Please enter the day of the month the task is due: ");
                boolean validInputND = false;
                while (!validInputND) {
                    if (dateInput.hasNextInt()) {
                        int checkInt = dateInput.nextInt();
                        if (checkInt < 1 | checkInt > 31) {
                            System.out.print("That day is out of range. Please try again: ");
                        } else {
                            dateTask.setDay(checkInt);
                            validInputND = true;
                        }
                    } else {
                        System.out.print("Incorrect input type. Please try again: ");
                        dateInput.nextLine();
                    }
                }

                System.out.print("Please enter the month of the year the task is due: ");
                boolean validInputNM = false;
                while (!validInputNM) {
                    if (dateInput.hasNextInt()) {
                        int checkInt = dateInput.nextInt();
                        if (checkInt < 1 | checkInt > 12) {
                            System.out.print("That month is out of range. Please try again: ");
                        } else {
                            dateTask.setMonth(checkInt);
                            validInputNM = true;
                        }
                    } else {
                        System.out.print("Incorrect input type. Please try again: ");
                        dateInput.nextLine();
                    }
                }

                System.out.print("Please enter the year the task is due: ");
                boolean validInputNY = false;
                while (!validInputNY) {
                    if (dateInput.hasNextInt()) {
                        int checkInt = dateInput.nextInt();
                        if (checkInt < 2022 | checkInt > 2032) {
                            System.out.print("That year is out of range. Please try again: ");
                        } else {
                            dateTask.setYear(checkInt);
                            validInputNY = true;
                        }
                    } else {
                        System.out.print("Incorrect input type. Please try again: ");
                        dateInput.nextLine();
                    }
                }
                //set date using updated list object
                dateTask.setDueDate(dateTask);
                break;

            case 4:
                //close program
                System.out.print("Program closing");
                for (int n = 0; n < 5; n++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(".");
                }
                System.exit(0);
                break;
        }

        return tList;
    }
}
