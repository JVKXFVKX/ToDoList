import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Todo {

    private String noteContents;
    private final String dateOfNoteConception;
    private LocalDate userDefinedEndDateOfNote;
    private Boolean isTheNoteCompleted;

    public Todo() {
        DateTimeFormatter timeAndDateFormatingObject = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime rawDateAndTimeObject = LocalDateTime.now();
        this.dateOfNoteConception = rawDateAndTimeObject.format(timeAndDateFormatingObject);
    }

    public String getNoteContents() {
        return noteContents;
    }

    public void setNoteContents(String noteContents) {
        this.noteContents = noteContents;
    }

    public String getDateOfNoteConception() {
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
