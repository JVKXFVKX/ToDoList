package ToDos;
import java.util.ArrayList;

public class TodoList {

    private static ArrayList<Todo> todoListArray;


    public TodoList() {
        todoListArray = new ArrayList<Todo>();
    }

    public void pushTodoIntoArray(Todo note) {
        todoListArray.add(note);
    }

    public void removeTodoFromArrayByIndex(int index) {
        todoListArray.remove(index);
    }

    public static ArrayList<Todo> getAllTodos() {
        return todoListArray;
    }
}
