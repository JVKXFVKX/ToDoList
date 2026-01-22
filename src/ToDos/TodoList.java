package ToDos;
import java.util.ArrayList;

public class TodoList {

    private static ArrayList<TodoItem> todoListArray;

    public TodoList() {
        todoListArray = new ArrayList<TodoItem>();
    }

    public void pushTodoIntoArray(TodoItem note) {
        todoListArray.add(note);
    }

    public void removeTodoFromArrayByIndex(int index) {
        todoListArray.remove(index);
    }

    public static ArrayList<TodoItem> getAllTodos() {
        return todoListArray;
    }
}
