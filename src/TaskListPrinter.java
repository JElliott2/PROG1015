import java.util.ArrayList;

public class TaskListPrinter {

    public void printTaskList(ArrayList<Tasks> t){
        //print fields banner
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.println("| # |         Title |                                Description |                     Due Date | Status |");

        //for loop to print each task by ordered elements and format output
        for (int i = 0; i < t.size(); i++) {
            System.out.println("|--------------------------------------------------------------------------------------------------------|");
            Tasks printTask = new Tasks();
            printTask = t.get(i);
            System.out.printf("|%3d|%15s|%44s|%30s|  [%s]   |\n", i+1, printTask.getTitle() , printTask.getDescription() , printTask.getDueDate(), printTask.getStatus());
            printTask = null;
        }
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
    }
}
