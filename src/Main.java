import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //unnecessary ascii welcome banner
        System.out.println("*******************************************************");
        System.out.println("  ----------------------------------------------------");
        System.out.println("*******************************************************");
        System.out.print("   __             __                        __           \n");
        System.out.print("  / /_____ ______/ /______ ___  ____ ______/ /____  _____\n");
        System.out.print(" / __/ __ `/ ___/ //_/ __ `__ \\/ __ `/ ___/ __/ _ \\/ ___/\n");
        System.out.print("/ /_/ /_/ (__  ) ,< / / / / / / /_/ (__  ) /_/  __/ /    \n");
        System.out.print("\\__/\\__,_/____/_/|_/_/ /_/ /_/\\__,_/____/\\__/\\___/_/     \n\n");
        System.out.println("*******************************************************");
        System.out.println("  ----------------------------------------------------");
        System.out.println("*******************************************************");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //initialize an array list to store the task objects
        ArrayList<Tasks> tasksList = new ArrayList<Tasks>();

        //using a while loop to kick back to the main menu after completing an action
        while (1 == 1) {
            //initialize variables
            Menu menuInt = new Menu();
            int menuChosen = menuInt.menu();

            //switch statement for choice received from Menu method
            switch (menuChosen) {
                case 1:
                    //ADD TASK: create a new Tasks object and TaskAdder object to call the TaskAdder method
                    Tasks newTask = new Tasks();
                    TaskAdder addTaskObj = new TaskAdder();
                    addTaskObj.addTask(newTask, tasksList);
                    break;

                case 2:
                    //MARK COMPLETE: print tasks list and then mark a task as complete
                    TaskListPrinter printMe2 = new TaskListPrinter();
                    printMe2.printTaskList(tasksList);

                    //get valid input for the task to mark complete
                    System.out.print("Which task would you like to mark as completed: ");
                    Scanner markCompleteInput = new Scanner(System.in);
                    boolean validInput = false;
                    while (!validInput) {
                        if (markCompleteInput.hasNextInt()) {
                            int checkInt = markCompleteInput.nextInt();
                            if (checkInt < 1 | checkInt > tasksList.size()) {
                                System.out.print("That day is out of range. Please try again: ");
                            } else {
                                checkInt -= 1;
                                Tasks completeThisTask = tasksList.get(checkInt);
                                completeThisTask.setStatus("X");
                                validInput = true;
                            }
                        } else {
                            System.out.print("Incorrect input type. Please try again: ");
                            markCompleteInput.nextLine();
                        }
                    }
                    //remembering to close scanner - actually, this breaks the input
                    //markCompleteInput.close();
                    break;


                case 3:
                    //DELETE: removing a task
                    TaskListPrinter printMe3 = new TaskListPrinter();
                    printMe3.printTaskList(tasksList);
                    System.out.print("Which task would you like to remove: ");

                    //while loop to check for valid task list choice
                    Scanner delChoice = new Scanner(System.in);
                    int delNum = 0;
                    boolean validInput3 = false;
                    while (!validInput3) {
                        if (delChoice.hasNextInt()) {
                            int checkInt = delChoice.nextInt();
                            if (checkInt < 0 | checkInt > tasksList.size()) {
                                System.out.print("That choice is out of range. Please try again: ");
                            } else {
                                delNum = checkInt - 1;
                                validInput3 = true;
                            }
                        } else {
                            System.out.print("Incorrect input type. Please try again: ");
                            delChoice.nextLine();
                        }
                    }
                    tasksList.remove(delNum);
                    break;

                case 4:
                    //EDIT: change an element of a task
                    int listNum = 0;
                    TaskListPrinter printMe4 = new TaskListPrinter();
                    printMe4.printTaskList(tasksList);
                    System.out.print("Which task would you like to edit?: ");

                    //while loop to check for valid task list choice
                    Scanner indexChoice = new Scanner(System.in);
                    boolean validInput4 = false;
                    while (!validInput4) {
                        if (indexChoice.hasNextInt()) {
                            int checkInt = indexChoice.nextInt();
                            if (checkInt < 0 | checkInt > tasksList.size()) {
                                System.out.print("That choice is out of range. Please try again: ");
                            } else {
                                listNum = checkInt - 1;
                                validInput4 = true;
                            }
                        } else {
                            System.out.print("Incorrect input type. Please try again: ");
                            indexChoice.nextLine();
                        }
                    }
                    TaskEdit editObj = new TaskEdit();
                    editObj.editTask(tasksList, listNum);
                    break;

                case 5:
                    //LIST TASK: print all tasks
                    TaskListPrinter printMe5 = new TaskListPrinter();
                    printMe5.printTaskList(tasksList);
                    break;

                //exiting program
                case 6:
                    System.out.print("Program closing");
                    for (int n = 0; n < 5; n++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(".");
                    }
                    //closing scanners
                    Scanner closeThis = new Scanner(System.in);
                    closeThis.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
