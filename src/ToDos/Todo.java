package ToDos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Todo {

    private String noteContents;
    private final String noteTitle;
    private final LocalDate dateOfNoteConception;
    private LocalDate userDefinedEndDateOfNote;
    private Boolean isTheNoteCompleted;

    public Todo(String title) {
        this.dateOfNoteConception = LocalDate.now();
        this.noteTitle = title;
    }

    public String getNoteContents() {
        return noteContents;
    }

    public void setNoteContents(String noteContents) {
        this.noteContents = noteContents;
    }
    public String getNoteTitle() {
        return noteTitle;
    }

    public LocalDate getDateOfNoteConception() {
        return dateOfNoteConception;
    }

    public LocalDate getUserDefinedEndDateOfNote() {
        return userDefinedEndDateOfNote;
    }

    public void setUserDefinedEndDateOfNote(String userDefinedEndDateOfNote) {
        DateTimeFormatter timeAndDateFormatingObject2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.userDefinedEndDateOfNote = LocalDate.parse(userDefinedEndDateOfNote, timeAndDateFormatingObject2);
    }
}
