# PROG1015 - Final Project
## **Task**: develop a console application that can store/edit tasks during run time.

This java application is called 'taskmaster' and can be used to temporarily create/store/edit tasks.
                                                                          
The application has five main functions:
+ Create tasks
+ Mark tasks as complete
+ Edit tasks
+ Delete tasks
+ Print all stored tasks

***

The current version of the application uses basic classes with a setter/getter approach to allow elements of the task list to be edited after their creation. The included files have the following intended uses:

**Main.java** - initialize program, call the menu function, and run the menu result through a switch  
**Menu.java** - print menu choices and validate menu input  
**TaskAdder.java** - get user input for the task elements, set those elements in the task object, then add the new task object to the list  
**TaskEdit.java** - print the current list of tasks, ask user for which task and element to edit, then use a switch to edit the appropriate element  
**TaskListPrinter.java** - print the current list of tasks  
**Tasks.java** - blueprint for task objects (title/duedate/description)  

***

To do: 
- [ ] Modify how output is handled so that when output is needed a function is called instead of repeated code sections.
* Integrate file storage and persistent tasks.
* Web frontend.
* Creation of users and user-specific lists.
