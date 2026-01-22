import Gui.MyGUI;
import ToDos.TodoItem;
import ToDos.TodoList;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userMenuChoice;
        DateTimeFormatter displayDateOnly = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        Scanner scanner = new Scanner(System.in);
        TodoList myListOfToDos = new TodoList();
        MyGUI mygui = new MyGUI(myListOfToDos);

        do {
            Menu menu = new Menu();
            userMenuChoice = scanner.nextInt();
            scanner.nextLine();

            if (userMenuChoice == 1) {
                System.out.print("Enter Title: ");
                String userTitle = scanner.nextLine();
                TodoItem newTodo = new TodoItem();

                System.out.println("Please enter your note:");
                String userNewNote = scanner.nextLine();
                newTodo.setContents(userNewNote);
                myListOfToDos.pushTodoIntoArray(newTodo);

                System.out.print("Enter desired completion date (MM-dd-yyyy): ");
                String userDesiredDate = scanner.nextLine();
                newTodo.setDueDate(userDesiredDate);
            }

            if (userMenuChoice == 2) {
                for (TodoItem todoLoop : TodoList.getAllTodos()) {
                    System.out.println("\tDate Written: " + todoLoop.getDateCreated().format(displayDateOnly));
                    System.out.println("\t\t\t" + todoLoop.getTitle() + "\n" + todoLoop.getContents());
                    System.out.println("\tDesired Completion Date: " + todoLoop.getDueDate().format(displayDateOnly) + "\n");
                }

            }

            if (userMenuChoice == 3) {
                System.out.println("Select a note to delete: ");
                for (TodoItem todoLoop : TodoList.getAllTodos()) {
                    System.out.println(todoLoop.getTitle());
                }
                int userNoteRemovalDecision = scanner.nextInt();
                myListOfToDos.removeTodoFromArrayByIndex(userNoteRemovalDecision);

            }

        } while (userMenuChoice != 4);

        scanner.close();
    }
}

