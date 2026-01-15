import java.util.ArrayList;

public class TodoList {

    private static ArrayList<Todo> todoListArray;


    public TodoList() {
        todoListArray = new ArrayList<Todo>();
    }

    public void pushTodoIntoArray(Todo note) {
        todoListArray.add(note);
    }

    public void removeTodoFromArray(Todo note) {
        todoListArray.remove(note);
    }

    public static ArrayList<Todo> getAllTodos() {
        return todoListArray;
    }

}
