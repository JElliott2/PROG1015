import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tasks {
    //declare variables for Task object
    private String title;
    //day broken into separate elements for data handling and ability to assemble date later
    private int day;
    private int month;
    private int year;
    private Date dueDate;
    private String status;
    private String description;


    //setters and getters for the above variables
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public int getDay(){
        return day;
    }
    public void setDay(int day){
        this.day = day;
    }

    public int getMonth(){
        return month;
    }
    public void setMonth(int month){
        this.month = month;
    }

    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public void setDueDate(Tasks t){
        //collating the three date variables into a formatted date
        String dateString = t.getYear() + "-" + t.getMonth() + "-" + t.getDay();
        SimpleDateFormat dueDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate = null;
        try {
            dueDate = dueDateFormatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.dueDate = dueDate;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

}
