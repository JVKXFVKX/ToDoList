package ToDos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TodoItem {

    private String contents;
    private String title;
    private final LocalDate dateCreated;
    private LocalDate dueDate;
    private Boolean completed;
    private String tempDueDate = setDueDate("01-01-2030");

    public TodoItem() {
        //title = "New Note";
        this.dateCreated = LocalDate.now();
    }

public void setTitle(String title) {
        this.title = title;
}

    public String getTitle() {
        return this.title;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDate getDateCreated() {
        return this.dateCreated;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public String setDueDate(String dueDate) {
        DateTimeFormatter formatingObject = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (Objects.equals(dueDate, "")) {
            assert tempDueDate != null;
            this.dueDate = LocalDate.parse(tempDueDate, formatingObject);
        }
        else {
            this.dueDate = LocalDate.parse(dueDate, formatingObject);
        }
        return dueDate;
    }
}
