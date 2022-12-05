import java.util.ArrayList;
import java.util.Scanner;

public class TaskAdder {

    public Tasks addTask(Tasks addTaskObj, ArrayList<Tasks> tasksList) {

        //get title from user (no validation as any input can be a title and the variable is not used in another process, merely printed)
        System.out.print("Please enter the title you want to give to the task: ");
        Scanner addingTask = new Scanner(System.in);
        addTaskObj.setTitle(addingTask.nextLine());
        //get description - no validation as with above
        System.out.print("Please enter a description for the task: ");
        addTaskObj.setDescription(addingTask.nextLine());

        //validate integers for day month and year : in future turn input gathering into a separate polyfunction
        System.out.print("Please enter the day of the month the task is due: ");
        boolean validInput = false;
        while (!validInput) {
            if (addingTask.hasNextInt()) {
                int checkInt = addingTask.nextInt();
                if (checkInt < 1 | checkInt > 31) {
                    System.out.print("That day is out of range. Please try again: ");
                } else {
                    addTaskObj.setDay(checkInt);
                    validInput = true;
                }
            } else {
                System.out.print("Incorrect input type. Please try again: ");
                addingTask.nextLine();
            }
        }

        System.out.print("Please enter the month of the year the task is due: ");
        boolean validInput2 = false;
        while (!validInput2) {
            if (addingTask.hasNextInt()) {
                int checkInt = addingTask.nextInt();
                if (checkInt < 1 | checkInt > 12) {
                    System.out.print("That month is out of range. Please try again: ");
                } else {
                    addTaskObj.setMonth(checkInt);
                    validInput2 = true;
                }
            } else {
                System.out.print("Incorrect input type. Please try again: ");
                addingTask.nextLine();
            }
        }

        System.out.print("Please enter the year the task is due: ");
        boolean validInput3 = false;
        while (!validInput3) {
            if (addingTask.hasNextInt()) {
                int checkInt = addingTask.nextInt();
                if (checkInt < 2022 | checkInt > 2032) {
                    System.out.print("That year is out of range. Please try again: ");
                } else {
                    addTaskObj.setYear(checkInt);
                    validInput3 = true;
                }
            } else {
                System.out.print("Incorrect input type. Please try again: ");
                addingTask.nextLine();
            }
        }
        //setting date using the set day/month/year attributes
        addTaskObj.setDueDate(addTaskObj);
        //set status to incomplete as default
        addTaskObj.setStatus(" ");
        //add task to the arraylist after assigning variables
        tasksList.add(addTaskObj);
        return addTaskObj;
    }
}
