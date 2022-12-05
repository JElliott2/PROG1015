import java.util.Scanner;

public class Menu {

    //run the menu and return the choice
    public int menu(){
        Scanner menuChoice = new Scanner(System.in);
        int menuChosen = 0;
        while(menuChosen == 0){
            System.out.println("What would you like to do?");
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as complete");
            System.out.println("3. Remove a task");
            System.out.println("4. Edit a task");
            System.out.println("5. List all tasks");
            System.out.println("6. Exit the program");
            System.out.print("Choice: ");
            try {
                menuChosen = menuChoice.nextInt();
                if (menuChosen < 0 | menuChosen > 6){
                    System.out.println("Please select a valid option number.");
                    menuChosen = 0;
                }
            } catch(Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                break;
            }
        }
        return menuChosen;
    }
}
