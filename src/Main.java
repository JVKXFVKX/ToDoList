import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        TodoList myListOfToDos = new TodoList();
        Todo myNewTodo1 = new Todo();
        Todo myNewTodo2 = new Todo();

        myNewTodo1.setNoteContents("Oh hey, im just trying to get this project up and running.");
        myNewTodo2.setNoteContents("Fuck, im onto something here.");

        myListOfToDos.pushTodoIntoArray(myNewTodo1);
        myListOfToDos.pushTodoIntoArray(myNewTodo2);
        myNewTodo1.setUserDefinedEndDateOfNote("23-09-2026");
        myNewTodo2.setUserDefinedEndDateOfNote("23-09-2026");

         for(Todo todoLoop : TodoList.getAllTodos()) {
            System.out.println("\t\t\tDate Written " + todoLoop.getDateOfNoteConception());
            System.out.println("- " + todoLoop.getNoteContents());
            System.out.println("- " + todoLoop.getUserDefinedEndDateOfNote().format(displayFormatter));

         }

        myListOfToDos.removeTodoFromArray(myNewTodo1);

        for(Todo todo : TodoList.getAllTodos()) {
            System.out.println(todo.getDateOfNoteConception());
            System.out.println("- " + todo.getNoteContents());
        }

    }
}

