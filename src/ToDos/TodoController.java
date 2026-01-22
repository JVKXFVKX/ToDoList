package ToDos;

public class TodoController {
    private final TodoItem titleController;
    private final TodoItem contentController;

    public TodoController(TodoItem titleController, TodoItem contentController) {
        this.titleController = titleController;
        this.contentController = contentController;
    }

    public void setTodoTitle(String title) {
        titleController.setTitle(title);
    }
    public String getTodoTitle() {
        return titleController.getTitle();
    }
    public void setTodoContents(String contents) {
        contentController.setContents(contents);
    }
    public String getTodoContent() {
        return contentController.getContents();
    }
}